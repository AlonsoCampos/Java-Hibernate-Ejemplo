/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Detallesmateriales;
import Model.Materiales;
import Model.Ubicacion;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yoshi
 */
public class ViewUbicacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewUbicacion
     */
    public ViewUbicacion() {
        initComponents();
        confirmarjPanel.setVisible(false);
        mostar();
        ActivarBusqueda();
    }
void ActivarBusqueda(){
    if(!anaqueljRadioButton.isSelected() && !seccionjRadioButton.isSelected()){
        JOptionPane.showMessageDialog(null, "Debe de selecciona al menos una\n opcion para buscar",
                "Atencion", JOptionPane.WARNING_MESSAGE);
    }else if(anaqueljRadioButton.isSelected()){
        actualizarAnaquel();
    }else if(seccionjRadioButton.isSelected()){
        actualizarSeccion();
    }
}    
void actualizarAnaquel(){
        busquedajTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                BuquedaAnaquel();
            }

            public void removeUpdate(DocumentEvent e) {
               limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
             limpiarTabla();
             BuquedaAnaquel();
            }

        });
    }
void BuquedaAnaquel()
    {
        List<Ubicacion>consultar = Controller.ConsultasMateriales.ListaUbicacionAnaquel(busquedajTextField.getText());
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)ubicacionjTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Ubicacion registro=(Ubicacion)elemento.next();
        resultado.add(registro.getIdUbicacion());
        resultado.add(registro.getAnaquel());
        resultado.add(registro.getSeccion());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }

void actualizarSeccion(){
        busquedajTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                BuquedaSeccion();
            }

            public void removeUpdate(DocumentEvent e) {
               limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
             limpiarTabla();
             BuquedaSeccion();
            }

        });
    }
void BuquedaSeccion()
    {
        List<Ubicacion>consultar = Controller.ConsultasMateriales.ListaUbicacionSeccion(busquedajTextField.getText());
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)ubicacionjTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Ubicacion registro=(Ubicacion)elemento.next();
        resultado.add(registro.getIdUbicacion());
        resultado.add(registro.getAnaquel());
        resultado.add(registro.getSeccion());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }

void mostar()
    {
        List<Ubicacion>consultar = Controller.ConsultasMateriales.ListaUbicacion();
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)ubicacionjTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Ubicacion registro=(Ubicacion)elemento.next();
        resultado.add(registro.getIdUbicacion());
        resultado.add(registro.getAnaquel());
        resultado.add(registro.getSeccion());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }

void limpiarTabla()
    {
        while (ubicacionjTable.getRowCount()!=0)
        {
         ((DefaultTableModel)ubicacionjTable.getModel()).removeRow(0);
        }
    }
void ChoiseUbicacion(){
        if(ubicacionjTable.getSelectedRow()>=0){
            confirmarjPanel.setVisible(true);
        }else{
            confirmarjPanel.setVisible(false);
        }
    }
public static Ubicacion CodigoUbicacion(int ubicacion){
        Ubicacion idUbicacion= Controller.ConsultasMateriales.UnicaUbicacion(ubicacion);
        if(idUbicacion!=null){
            return idUbicacion;
        }else{
            return null;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        newjPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        anaqueljTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        seccionjTextField = new javax.swing.JTextField();
        savejButton = new javax.swing.JButton();
        canceljButton = new javax.swing.JButton();
        searchjPanel = new javax.swing.JPanel();
        anaqueljRadioButton = new javax.swing.JRadioButton();
        seccionjRadioButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        busquedajTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ubicacionjTable = new javax.swing.JTable();
        confirmarjPanel = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ubicacion");
        setToolTipText("Agrega la ubicacion");

        newjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Añadir una nueva Ubicacion"));

        jLabel1.setText("Anaquel:");

        jLabel2.setText("Seccion:");

        savejButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/save.png"))); // NOI18N
        savejButton.setToolTipText("Guardar Cambios");
        savejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savejButtonActionPerformed(evt);
            }
        });

        canceljButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/cancel.png"))); // NOI18N
        canceljButton.setToolTipText("Cancelar ");
        canceljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canceljButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newjPanelLayout = new javax.swing.GroupLayout(newjPanel);
        newjPanel.setLayout(newjPanelLayout);
        newjPanelLayout.setHorizontalGroup(
            newjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newjPanelLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(newjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(anaqueljTextField)
                    .addComponent(seccionjTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(savejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canceljButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        newjPanelLayout.setVerticalGroup(
            newjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(canceljButton)
                    .addComponent(savejButton)
                    .addGroup(newjPanelLayout.createSequentialGroup()
                        .addGroup(newjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(anaqueljTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(newjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(seccionjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por:"));

        buttonGroup1.add(anaqueljRadioButton);
        anaqueljRadioButton.setSelected(true);
        anaqueljRadioButton.setText("Anaquel");
        anaqueljRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                anaqueljRadioButtonMouseEntered(evt);
            }
        });
        anaqueljRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anaqueljRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(seccionjRadioButton);
        seccionjRadioButton.setText("Seccion");
        seccionjRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seccionjRadioButtonActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/search.png"))); // NOI18N
        jLabel4.setText("Ubicacion:");

        busquedajTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedajTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchjPanelLayout = new javax.swing.GroupLayout(searchjPanel);
        searchjPanel.setLayout(searchjPanelLayout);
        searchjPanelLayout.setHorizontalGroup(
            searchjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchjPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busquedajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(searchjPanelLayout.createSequentialGroup()
                .addComponent(anaqueljRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seccionjRadioButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        searchjPanelLayout.setVerticalGroup(
            searchjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchjPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anaqueljRadioButton)
                    .addComponent(seccionjRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(busquedajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        ubicacionjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Anaquel", "Seccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ubicacionjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubicacionjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ubicacionjTable);
        ubicacionjTable.getColumnModel().getColumn(0).setResizable(false);
        ubicacionjTable.getColumnModel().getColumn(1).setResizable(false);
        ubicacionjTable.getColumnModel().getColumn(2).setResizable(false);

        confirmarjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elegir una ubicacion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        buttonGroup2.add(jToggleButton1);
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Yes.png"))); // NOI18N
        jToggleButton1.setText("Confirmar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jToggleButton2);
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/No.png"))); // NOI18N
        jToggleButton2.setText("Cancelar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout confirmarjPanelLayout = new javax.swing.GroupLayout(confirmarjPanel);
        confirmarjPanel.setLayout(confirmarjPanelLayout);
        confirmarjPanelLayout.setHorizontalGroup(
            confirmarjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmarjPanelLayout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jToggleButton1)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        confirmarjPanelLayout.setVerticalGroup(
            confirmarjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmarjPanelLayout.createSequentialGroup()
                .addGroup(confirmarjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(newjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(confirmarjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmarjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savejButtonActionPerformed
        if(!anaqueljTextField.getText().isEmpty() && !seccionjTextField.getText().isEmpty())
        {
            if(Controller.ControllerUbicacion.CreateUbicacion
                    (anaqueljTextField.getText(), seccionjTextField.getText())==true){
                JOptionPane.showMessageDialog(null, "Agregado correctamente","Operacion exitosa",JOptionPane.INFORMATION_MESSAGE);
                limpiarTabla();
                mostar();
                anaqueljTextField.setText("");
                seccionjTextField.setText("");
            }else{
            JOptionPane.showMessageDialog(null, "No se ha podido agregar \nIntente mas tarde","Operacion fallida",JOptionPane.ERROR_MESSAGE);    
            }
        }
    }//GEN-LAST:event_savejButtonActionPerformed

    private void canceljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canceljButtonActionPerformed
        anaqueljTextField.setText("");
        seccionjTextField.setText("");
    }//GEN-LAST:event_canceljButtonActionPerformed

    private void anaqueljRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anaqueljRadioButtonActionPerformed
        actualizarAnaquel();
    }//GEN-LAST:event_anaqueljRadioButtonActionPerformed

    private void seccionjRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seccionjRadioButtonActionPerformed
        actualizarSeccion();
    }//GEN-LAST:event_seccionjRadioButtonActionPerformed

    private void busquedajTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedajTextFieldActionPerformed
        
    }//GEN-LAST:event_busquedajTextFieldActionPerformed

    private void anaqueljRadioButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anaqueljRadioButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_anaqueljRadioButtonMouseEntered

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if(ubicacionjTable.getSelectedRow()>-1)
       {
        int selected = ubicacionjTable.getSelectedRow();                  
        String id=ubicacionjTable.getValueAt(selected, 0).toString();
        String anaquel=ubicacionjTable.getValueAt(selected, 1).toString();    
        String seccion=ubicacionjTable.getValueAt(selected, 2).toString();
        int confirm= JOptionPane.showConfirmDialog(null, "¿Esta seguro?");
        if(confirm==0)
        {
//            ViewMateriales s =new ViewMateriales();
//            Principal.jDesktopPane1.add(s);
//            s.CargarMateriales(Integer.parseInt(id));
//            s.show();
//            JOptionPane.showMessageDialog(null, "La fila seleccionada es: "+nombre);
//            dispose();
              ViewMateriales.ubicacionjTextField.setText(anaquel+"-"+seccion);
              ViewMateriales.idUbicacion=CodigoUbicacion(Integer.parseInt(id));
              dispose();
              //JOptionPane.showMessageDialog(null, ViewMateriales.idUbicacion.getIdUbicacion());
        }else{
            JOptionPane.showMessageDialog(null, "Se ha cancelado");
            ubicacionjTable.clearSelection();
        }
       }else{
           JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila","Error de Seleccion",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void ubicacionjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubicacionjTableMouseClicked
//        if(ubicacionjTable.getSelectedRow()==-1){
//            confirmarjPanel.setVisible(false);
//        }else{
//            confirmarjPanel.setVisible(true);
//        }
        ChoiseUbicacion();
    }//GEN-LAST:event_ubicacionjTableMouseClicked

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        ubicacionjTable.clearSelection();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton anaqueljRadioButton;
    private javax.swing.JTextField anaqueljTextField;
    private javax.swing.JTextField busquedajTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton canceljButton;
    private javax.swing.JPanel confirmarjPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JPanel newjPanel;
    private javax.swing.JButton savejButton;
    private javax.swing.JPanel searchjPanel;
    private javax.swing.JRadioButton seccionjRadioButton;
    private javax.swing.JTextField seccionjTextField;
    private javax.swing.JTable ubicacionjTable;
    // End of variables declaration//GEN-END:variables
}
