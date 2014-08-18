/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Detallesmateriales;
import Model.DisplayItem;
import Model.Estado;
import Model.Marcas;
import Model.Ubicacion;
import Model.Unidades;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Yoshi
 */
public class ViewMateriales extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewMateriales
     */
    public ViewMateriales() {
        initComponents();
        savejButton.setEnabled(false);
        canceljButton.setEnabled(false);
        loadEstados();
        loadMarcas();
        CargarMateriales(Controller.ConsultasMateriales.FirtsDetallesMaterial().getIdDetalleMaterial());
    }
    public String FormaterarFecha(Date fecha)
    {
        DateFormat df =  DateFormat.getDateInstance();    
        String s =  df.format(fecha);
        return s;
    }
    /*http://surpatterns.com/sitio/tutoriales-programacion-surpatterns/java-manejo-y-formateo-de-fechas-con-dateformat-y-simpledateformat/*/
    public static Ubicacion idUbicacion;
    public static Unidades idUnidad;
    public void CargarMateriales(int idDetalles){
        Detallesmateriales id =Controller.ConsultasMateriales.UnicoDetalleMaterial(idDetalles);
        detallesjTextField.setText(id.getDetalles());
        unidadjTextField.setText(id.getUnidades().getUnidad().toString());        
        codigojTextField.setText(id.getCodigo());
        materialjTextField.setText(id.getMateriales().getMaterial());
        cantidadjSpinner.setValue(id.getStock());
        ubicacionjTextField.setText(id.getMateriales().getUbicacion().getAnaquel().toString()
                +"-"+id.getMateriales().getUbicacion().getSeccion().toString());
        marcajComboBox.setSelectedItem(id.getMateriales().getMarcas().getMarca().toString());
        String fecha = FormaterarFecha(id.getFechaCaducidad());
        caducidaddateChooserCombo.setText(fecha);
        estadojComboBox.setSelectedItem(id.getMateriales().getEstado().getEstado().toString());
        //idjLabel.setText("id: ".concat(id.getMateriales().getIdMateriales().toString()));
        actualjLabel.setText(id.getIdDetalleMaterial().toString());
    }
    void limpiar (){
        codigojTextField.setText("");
        materialjTextField.setText("");
        cantidadjSpinner.setValue(0);
        detallesjTextField.setText("");
        ubicacionjTextField.setText("");
        unidadjTextField.setText("");
    }
    void bloquearEditar(boolean editar){
        ubicacionjTextField.setEditable(editar);
        marcajComboBox.setEditable(editar);
        estadojComboBox.setEditable(editar);
        unidadjTextField.setEditable(editar);
    }
    public  void loadMarcas()
    {
        DefaultComboBoxModel datos=new DefaultComboBoxModel();
        List<Marcas> resultado=Controller.ConsultasMateriales.ListaMarca();
        for(Marcas o: resultado){
           DisplayItem d = new DisplayItem(o.getMarca(), o.getIdMarca());
            datos.addElement(d);
        } 
        marcajComboBox.setModel(datos);
    }
    public  void loadEstados()
    {
        DefaultComboBoxModel datos=new DefaultComboBoxModel();
        List<Estado> resultado=Controller.ConsultasMateriales.ListaEstado();
        for(Estado o: resultado){
           DisplayItem d = new DisplayItem(o.getEstado(), o.getIdEstado());
            datos.addElement(d);
        } 
        estadojComboBox.setModel(datos);
    }
    
     
    void ActivarContenido(boolean activo)
    {
        codigojTextField.setEnabled(activo);
        marcajComboBox.setEnabled(activo);
        materialjTextField.setEnabled(activo);
        cantidadjSpinner.setEnabled(activo);
        ubicacionjTextField.setEnabled(activo);
        caducidaddateChooserCombo.setEnabled(activo);
        estadojComboBox.setEnabled(activo);
        ubicacionjButton.setEnabled(activo);
        detallesjTextField.setEnabled(activo);
        unidadjTextField.setEnabled(activo);
        unidadjButton.setEnabled(activo);
    }
    int accion;
    void AccionBoton(){
        switch(accion){
            case 1:
                
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
    }
    void ActivarOpciones(int opcion)
    {
        boolean inavilitar = false;
        boolean habilitar = true;
        ActivarRegistros(inavilitar);
        
        switch(opcion){
                // Opcion para new
            case 1:
                ActivarContenido(habilitar);
                limpiar();
                accion =1;
                updatejButton.setEnabled(inavilitar);
                deletejButton.setEnabled(inavilitar);
                searchjButton.setEnabled(inavilitar);
                savejButton.setEnabled(habilitar);
                canceljButton.setEnabled(habilitar);
                newjButton.setEnabled(habilitar);
            break;
                //Opcion para editar
            case 2:
                ActivarContenido(habilitar);
                accion=2;
                updatejButton.setEnabled(habilitar);
                deletejButton.setEnabled(inavilitar);
                searchjButton.setEnabled(inavilitar);
                savejButton.setEnabled(habilitar);
                canceljButton.setEnabled(habilitar);
                newjButton.setEnabled(inavilitar);
            break;
                //Opcion para eliminar
            case 3:
                ActivarContenido(false);
                accion =3;
                updatejButton.setEnabled(inavilitar);
                deletejButton.setEnabled(habilitar);
                searchjButton.setEnabled(inavilitar);
                savejButton.setEnabled(habilitar);
                canceljButton.setEnabled(habilitar);
                newjButton.setEnabled(inavilitar);
            break;
                //Cancelar Opcion
               case 4:
                ActivarContenido(false);
                accion=4;
                ActivarRegistros(true);
                updatejButton.setEnabled(habilitar);
                deletejButton.setEnabled(habilitar);
                searchjButton.setEnabled(habilitar);
                savejButton.setEnabled(inavilitar);
                canceljButton.setEnabled(inavilitar);
                newjButton.setEnabled(habilitar);
            break;
                //Opcion para editar
        }
        
    }
    void ActivarRegistros(boolean activo)
    {
        lastjButton.setEnabled(activo);
        firstjButton.setEnabled(activo);
        beforejButton.setEnabled(activo);
        afterjButton.setEnabled(activo);
    }
    void mensajeErrorValidacion(String elemento){
        String mensaje ="Error no puede dejar vacio el campo de ";
        String titulo ="Error de validacion";
        JOptionPane.showMessageDialog(null, mensaje.concat(elemento),titulo,JOptionPane.ERROR_MESSAGE);
    }
    boolean CamposVacios(){
        if(codigojTextField.getText().isEmpty()){  
            mensajeErrorValidacion("Codigo");
            return false;
        }else if(materialjTextField.getText().isEmpty()){
            mensajeErrorValidacion("Material");
            return false;
        }else if(caducidaddateChooserCombo.getText().isEmpty()){
            mensajeErrorValidacion("Caducidad");
            return false;
        }else{
            return true;
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        codigojTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        materialjTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        firstjButton = new javax.swing.JButton();
        beforejButton = new javax.swing.JButton();
        afterjButton = new javax.swing.JButton();
        lastjButton = new javax.swing.JButton();
        newjButton = new javax.swing.JButton();
        updatejButton = new javax.swing.JButton();
        canceljButton = new javax.swing.JButton();
        searchjButton = new javax.swing.JButton();
        deletejButton = new javax.swing.JButton();
        savejButton = new javax.swing.JButton();
        cantidadjSpinner = new javax.swing.JSpinner();
        marcajComboBox = new javax.swing.JComboBox();
        estadojComboBox = new javax.swing.JComboBox();
        idjLabel = new javax.swing.JLabel();
        progresojProgressBar = new javax.swing.JProgressBar();
        caducidaddateChooserCombo = new datechooser.beans.DateChooserCombo();
        ubicacionjButton = new javax.swing.JButton();
        detallesjTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        unidadjButton = new javax.swing.JButton();
        ubicacionjTextField = new javax.swing.JTextField();
        unidadjTextField = new javax.swing.JTextField();
        actualjLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Materiales");
        setToolTipText("Materiales");

        jLabel1.setText("Codigo:");

        codigojTextField.setEnabled(false);

        jLabel2.setText("Material:");

        materialjTextField.setEnabled(false);

        jLabel3.setText("Cantidad:");

        jLabel4.setText("Caducidad:");

        jLabel5.setText("Estado:");

        jLabel6.setText("Ubicacion:");

        jLabel7.setText("Detalles:");

        jLabel8.setText("Marca:");

        firstjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Izquierda L.png"))); // NOI18N
        firstjButton.setToolTipText("Ir al Primero");
        firstjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstjButtonActionPerformed(evt);
            }
        });

        beforejButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Izquierda.png"))); // NOI18N
        beforejButton.setToolTipText("Anterior");
        beforejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beforejButtonActionPerformed(evt);
            }
        });

        afterjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Derecha.png"))); // NOI18N
        afterjButton.setToolTipText("Siguiente");
        afterjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afterjButtonActionPerformed(evt);
            }
        });

        lastjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Derecha F.png"))); // NOI18N
        lastjButton.setToolTipText("Ir al Ultimo");
        lastjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastjButtonActionPerformed(evt);
            }
        });

        newjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/new.png"))); // NOI18N
        newjButton.setToolTipText("Agrega Nuevo");
        newjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newjButtonActionPerformed(evt);
            }
        });

        updatejButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/edit.png"))); // NOI18N
        updatejButton.setToolTipText("Modifica Registro");
        updatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatejButtonActionPerformed(evt);
            }
        });

        canceljButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/cancel.png"))); // NOI18N
        canceljButton.setToolTipText("Cancelar ");
        canceljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canceljButtonActionPerformed(evt);
            }
        });

        searchjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/search.png"))); // NOI18N
        searchjButton.setToolTipText("Buscar");
        searchjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchjButtonActionPerformed(evt);
            }
        });

        deletejButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/delete.png"))); // NOI18N
        deletejButton.setToolTipText("Eliminar Registro");
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });

        savejButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/save.png"))); // NOI18N
        savejButton.setToolTipText("Guardar Cambios");
        savejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savejButtonActionPerformed(evt);
            }
        });

        cantidadjSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        cantidadjSpinner.setToolTipText("");
        cantidadjSpinner.setEnabled(false);

        marcajComboBox.setEditable(true);
        marcajComboBox.setToolTipText("");
        marcajComboBox.setEnabled(false);

        estadojComboBox.setEditable(true);
        estadojComboBox.setEnabled(false);

        idjLabel.setText("id:");

        caducidaddateChooserCombo.setCalendarPreferredSize(new java.awt.Dimension(300, 180));
        caducidaddateChooserCombo.setNothingAllowed(false);
        caducidaddateChooserCombo.setEnabled(false);

        ubicacionjButton.setText("...");
        ubicacionjButton.setToolTipText("Elegir una descripcion");
        ubicacionjButton.setEnabled(false);
        ubicacionjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubicacionjButtonActionPerformed(evt);
            }
        });

        detallesjTextField.setEnabled(false);

        jLabel9.setText("Unidad:");

        unidadjButton.setText("...");
        unidadjButton.setEnabled(false);
        unidadjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidadjButtonActionPerformed(evt);
            }
        });

        ubicacionjTextField.setEditable(false);
        ubicacionjTextField.setEnabled(false);

        unidadjTextField.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualjLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(progresojProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(firstjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(beforejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(afterjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cantidadjSpinner)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(ubicacionjTextField)
                                                    .addComponent(unidadjTextField))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(ubicacionjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(unidadjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(materialjTextField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(codigojTextField)))
                                .addGap(54, 54, 54)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(estadojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(marcajComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(caducidaddateChooserCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(detallesjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(updatejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(savejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(canceljButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deletejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(codigojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(marcajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(caducidaddateChooserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(materialjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cantidadjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(estadojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ubicacionjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ubicacionjButton)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(unidadjButton)
                            .addComponent(unidadjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(detallesjTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canceljButton)
                    .addComponent(beforejButton)
                    .addComponent(firstjButton)
                    .addComponent(afterjButton)
                    .addComponent(lastjButton)
                    .addComponent(newjButton)
                    .addComponent(updatejButton)
                    .addComponent(searchjButton)
                    .addComponent(deletejButton)
                    .addComponent(savejButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(idjLabel)
                    .addComponent(actualjLabel)
                    .addComponent(progresojProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newjButtonActionPerformed
        bloquearEditar(false);
        ActivarOpciones(1);
        
    }//GEN-LAST:event_newjButtonActionPerformed

    private void updatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatejButtonActionPerformed
        bloquearEditar(false);
        ActivarOpciones(2);
        CargarMateriales(Integer.parseInt(actualjLabel.getText()));
    }//GEN-LAST:event_updatejButtonActionPerformed

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejButtonActionPerformed
        bloquearEditar(false);
        ActivarOpciones(3);
    }//GEN-LAST:event_deletejButtonActionPerformed

    private void canceljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canceljButtonActionPerformed
        bloquearEditar(false);
        ActivarOpciones(4);
    }//GEN-LAST:event_canceljButtonActionPerformed

    private void savejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savejButtonActionPerformed
        
        //if(CamposVacios()!=false)
        //{
        if(!ubicacionjTextField.getText().isEmpty() && !unidadjTextField.getText().isEmpty())
        {
            int id = Integer.parseInt(actualjLabel.getText());
            String codigo = codigojTextField.getText();
            String material = materialjTextField.getText();
            //int cantidad = (int) ;
            float can=Float.parseFloat(String.valueOf(cantidadjSpinner.getValue().toString()));
            String descripcion = detallesjTextField.getText();
            Marcas marca = Controller.ConsultasMateriales.UnicaMarca(marcajComboBox.getSelectedItem().toString());
            Date hoy = new Date();
            Estado estado = Controller.ConsultasMateriales.UnicoEstado(estadojComboBox.getSelectedItem().toString());
            Detallesmateriales actual = Controller.ConsultasMateriales.UnicoDetalleMaterial(id);
            
            if(Controller.ControllerMateriales.DeleteMateriales(id)==true){
                Principal.jDesktopPane1.removeAll();
                Principal.jDesktopPane1.repaint();
                ViewMateriales nuevo = new ViewMateriales();
                Principal.jDesktopPane1.add(nuevo);
                nuevo.show();
                bloquearEditar(false);
                ActivarOpciones(4);
            }
            
            /*Con esto se modifica un registro*/
////            if(idUbicacion==null){
////                idUbicacion = Controller.ConsultasMateriales.
////                        UnicaUbicacion(actual.getMateriales().getUbicacion().getIdUbicacion());
////            }
////            if(idUnidad==null){
////                idUnidad = Controller.ConsultasMateriales.UnicaUnidad(actual.getUnidades().getIdUnidades());
////            }
////            if(Controller.ControllerMateriales.UpdateMateriales(id,codigo, material,
////                    marca, idUbicacion, estado, can, hoy, descripcion, idUnidad)==true){
////                Principal.jDesktopPane1.removeAll();
////                Principal.jDesktopPane1.repaint();
////                ViewMateriales nuevo = new ViewMateriales();
////                Principal.jDesktopPane1.add(nuevo);
////                nuevo.show();
////                bloquearEditar(false);
////                ActivarOpciones(4);
////            }
            /*Con esto se agrega un nuevo registro*/
//            if(Controller.ControllerMateriales.CrearMateriales
//                  (material, marca, idUbicacion, estado, codigo, cantidad, hoy,descripcion, idUnidad)==true)
//            {
//                Principal.jDesktopPane1.removeAll();
//                Principal.jDesktopPane1.repaint();
//                ViewMateriales nuevo = new ViewMateriales();
//                Principal.jDesktopPane1.add(nuevo);
//                nuevo.show();
//                bloquearEditar(false);
//                ActivarOpciones(4);
//            }
        }
        //}
    }//GEN-LAST:event_savejButtonActionPerformed

    private void firstjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstjButtonActionPerformed
        bloquearEditar(true);
        CargarMateriales(Controller.ConsultasMateriales.FirtsDetallesMaterial().getIdDetalleMaterial());
    }//GEN-LAST:event_firstjButtonActionPerformed

    private void lastjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastjButtonActionPerformed
        bloquearEditar(true);
        CargarMateriales(Controller.ConsultasMateriales.LastDetallesMaterial().getIdDetalleMaterial());
    }//GEN-LAST:event_lastjButtonActionPerformed

    private void beforejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beforejButtonActionPerformed
        int id = Integer.parseInt(actualjLabel.getText());
        CargarMateriales(Controller.ConsultasMateriales.BeforeDetallesMaterial(id).getIdDetalleMaterial());
    }//GEN-LAST:event_beforejButtonActionPerformed

    private void afterjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afterjButtonActionPerformed
        int id = Integer.parseInt(actualjLabel.getText());
        CargarMateriales(Controller.ConsultasMateriales.AfterDetallesMaterial(id).getIdDetalleMaterial());
    }//GEN-LAST:event_afterjButtonActionPerformed

    private void ubicacionjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubicacionjButtonActionPerformed
        ViewUbicacion ubicacion = new ViewUbicacion();
        Principal.jDesktopPane1.add(ubicacion);
        ubicacion.show();
    }//GEN-LAST:event_ubicacionjButtonActionPerformed

    private void unidadjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidadjButtonActionPerformed
        ViewUnidad unidad = new ViewUnidad();
        Principal.jDesktopPane1.add(unidad);
        unidad.show();        
    }//GEN-LAST:event_unidadjButtonActionPerformed

    private void searchjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchjButtonActionPerformed
        ViewSearchMateriales search = new ViewSearchMateriales();
        Principal.jDesktopPane1.add(search);
        search.show();
        dispose();
    }//GEN-LAST:event_searchjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel actualjLabel;
    private javax.swing.JButton afterjButton;
    private javax.swing.JButton beforejButton;
    private datechooser.beans.DateChooserCombo caducidaddateChooserCombo;
    private javax.swing.JButton canceljButton;
    private javax.swing.JSpinner cantidadjSpinner;
    private javax.swing.JTextField codigojTextField;
    private javax.swing.JButton deletejButton;
    private javax.swing.JTextField detallesjTextField;
    private javax.swing.JComboBox estadojComboBox;
    private javax.swing.JButton firstjButton;
    private javax.swing.JLabel idjLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton lastjButton;
    private javax.swing.JComboBox marcajComboBox;
    private javax.swing.JTextField materialjTextField;
    private javax.swing.JButton newjButton;
    private javax.swing.JProgressBar progresojProgressBar;
    private javax.swing.JButton savejButton;
    private javax.swing.JButton searchjButton;
    private javax.swing.JButton ubicacionjButton;
    public static javax.swing.JTextField ubicacionjTextField;
    private javax.swing.JButton unidadjButton;
    public static javax.swing.JTextField unidadjTextField;
    private javax.swing.JButton updatejButton;
    // End of variables declaration//GEN-END:variables
}
