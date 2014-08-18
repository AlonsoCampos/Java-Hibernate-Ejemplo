/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Detallesmateriales;
import Model.Marcas;
import Model.Materiales;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yoshi
 */
public class ViewSearchMateriales extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewSearchMateriales
     */
    public ViewSearchMateriales() {
        initComponents();
        choisejPanel.setVisible(false);
        //actualizarMaterial();
    }
    void limpiarTabla()
    {
        while (materialesjTable.getRowCount()!=0)
        {
         ((DefaultTableModel)materialesjTable.getModel()).removeRow(0);
        }
    }
    void actualizarMarca(){
        busquedajTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                searchMarca();
            }

            public void removeUpdate(DocumentEvent e) {
               limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
             limpiarTabla();
             searchMarca();
            }

        });
    }
    void actualizarCodigo(){
        busquedajTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                searchCodigo();
            }

            public void removeUpdate(DocumentEvent e) {
               limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
             limpiarTabla();
             searchCodigo();
            }

        });
    }
    void actualizarDetalles(){
        busquedajTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                searchDetalles();
            }

            public void removeUpdate(DocumentEvent e) {
               limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
             limpiarTabla();
             searchDetalles();
            }

        });
    }
    void actualizarMaterial(){
        busquedajTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                searchMateriales();
            }

            public void removeUpdate(DocumentEvent e) {
               limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
             limpiarTabla();
             searchMateriales();
            }

        });
    }
    void searchCodigo(){
           for(Materiales material: Controller.ConsultasMateriales.ListaMaterial())
            {
            for(Detallesmateriales detalles: Controller.ConsultasMateriales.ListaDetallesMaterialesCodigo(busquedajTextField.getText()))
            {       
                String idMateriales= String.valueOf(material.getIdMateriales());
                String idDetallesM= String.valueOf(detalles.getMateriales().getIdMateriales());
                
                if(idMateriales.equalsIgnoreCase(idDetallesM))
                {
                        DefaultTableModel datos=(DefaultTableModel)materialesjTable.getModel();
                        Vector resultado=new Vector();   
                        resultado.add(detalles.getIdDetalleMaterial());
                        resultado.add(detalles.getCodigo());
                        resultado.add(detalles.getMateriales().getMaterial());
                        resultado.add(detalles.getMateriales().getMarcas().getMarca());
                        resultado.add(detalles.getFechaCaducidad());
                        resultado.add(detalles.getStock());
                        datos.addRow(resultado);
                }    
         
        }// Fin Detalles Materiales
       } // Fin Materiales    
    
    }
    void searchDetalles(){
           for(Materiales material: Controller.ConsultasMateriales.ListaMaterial())
            {
            for(Detallesmateriales detalles: Controller.ConsultasMateriales.ListaDetallesMaterialesDetalles(busquedajTextField.getText()))
            {       
                String idMateriales= String.valueOf(material.getIdMateriales());
                String idDetallesM= String.valueOf(detalles.getMateriales().getIdMateriales());
                
                if(idMateriales.equalsIgnoreCase(idDetallesM))
                {
                        DefaultTableModel datos=(DefaultTableModel)materialesjTable.getModel();
                        Vector resultado=new Vector();   
                        resultado.add(detalles.getIdDetalleMaterial());
                        resultado.add(detalles.getCodigo());
                        resultado.add(detalles.getMateriales().getMaterial());
                        resultado.add(detalles.getMateriales().getMarcas().getMarca());
                        resultado.add(detalles.getFechaCaducidad());
                        resultado.add(detalles.getStock());
                        datos.addRow(resultado);
                }    
         
        }// Fin Detalles Materiales
       } // Fin Materiales    
    
    }
    void searchMateriales(){
        for(Detallesmateriales detalles: Controller.ConsultasMateriales.ListaDetallesMateriales())
            {
             for(Materiales material: Controller.ConsultasMateriales.ListaMaterial(busquedajTextField.getText()))
            {
                String idMateriales= String.valueOf(material.getIdMateriales());
                String idDetallesM= String.valueOf(detalles.getMateriales().getIdMateriales());
                if(idMateriales.equalsIgnoreCase(idDetallesM))
                {
                        DefaultTableModel datos=(DefaultTableModel)materialesjTable.getModel();
                        Vector resultado=new Vector();   
                        resultado.add(detalles.getIdDetalleMaterial());
                        resultado.add(detalles.getCodigo());
                        resultado.add(detalles.getMateriales().getMaterial());
                        resultado.add(detalles.getMateriales().getMarcas().getMarca());
                        resultado.add(detalles.getFechaCaducidad());
                        resultado.add(detalles.getStock());
                        datos.addRow(resultado);
                }
        }// Fin Detalles Materiales
       } // Fin Materiales    
    }
    void searchMarca(){
           for(Materiales material: Controller.ConsultasMateriales.ListaMaterial())
            {
            for(Detallesmateriales detalles: Controller.ConsultasMateriales.ListaDetallesMateriales())
            {
              for (Marcas marca :Controller.ConsultasMateriales.ListaMarca(busquedajTextField.getText())) {
                
                String idMateriales= String.valueOf(material.getIdMateriales());
                String idDetallesM= String.valueOf(detalles.getMateriales().getIdMateriales());
                if(idMateriales.equalsIgnoreCase(idDetallesM))
                {
                    String idMaterialMarca = String.valueOf(material.getMarcas().getIdMarca());
                    String idMarca = String.valueOf(marca.getIdMarca());
                
                    if(idMaterialMarca.equalsIgnoreCase(idMarca))
                    {
                        DefaultTableModel datos=(DefaultTableModel)materialesjTable.getModel();
                        Vector resultado=new Vector();   
                        resultado.add(detalles.getIdDetalleMaterial());
                        resultado.add(detalles.getCodigo());
                        resultado.add(detalles.getMateriales().getMaterial());
                        resultado.add(detalles.getMateriales().getMarcas().getMarca());
                        resultado.add(detalles.getFechaCaducidad());
                        resultado.add(detalles.getStock());
                        datos.addRow(resultado);
                    }
                }    
         }//Fin de Marca
        }// Fin Detalles Materiales
       } // Fin Materiales    
    }
    void ChoiseMaterial(){
        if(materialesjTable.getSelectedRow()>=0){
            choisejPanel.setVisible(true);
        }else{
            choisejPanel.setVisible(false);
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

        searchbuttonGroup = new javax.swing.ButtonGroup();
        choisebuttonGroup = new javax.swing.ButtonGroup();
        searchjPanel = new javax.swing.JPanel();
        materialjRadioButton = new javax.swing.JRadioButton();
        marcajRadioButton = new javax.swing.JRadioButton();
        caducidadjRadioButton = new javax.swing.JRadioButton();
        cantidadjRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        busquedajTextField = new javax.swing.JTextField();
        choisejPanel = new javax.swing.JPanel();
        verDetallesjToggleButton = new javax.swing.JToggleButton();
        cancelarjToggleButton = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        materialesjTable = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Busqueda");

        searchjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por:"));

        searchbuttonGroup.add(materialjRadioButton);
        materialjRadioButton.setSelected(true);
        materialjRadioButton.setText("Material");
        materialjRadioButton.setToolTipText("Busqueda por:");
        materialjRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialjRadioButtonActionPerformed(evt);
            }
        });

        searchbuttonGroup.add(marcajRadioButton);
        marcajRadioButton.setText("Marca");
        marcajRadioButton.setToolTipText("Busqueda por:");
        marcajRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcajRadioButtonActionPerformed(evt);
            }
        });

        searchbuttonGroup.add(caducidadjRadioButton);
        caducidadjRadioButton.setText("Codigo");
        caducidadjRadioButton.setToolTipText("Busqueda por:");
        caducidadjRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caducidadjRadioButtonActionPerformed(evt);
            }
        });

        searchbuttonGroup.add(cantidadjRadioButton);
        cantidadjRadioButton.setText("Detalles");
        cantidadjRadioButton.setToolTipText("Busqueda por:");
        cantidadjRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadjRadioButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/search.png"))); // NOI18N
        jLabel1.setText("Buscar:");

        javax.swing.GroupLayout searchjPanelLayout = new javax.swing.GroupLayout(searchjPanel);
        searchjPanel.setLayout(searchjPanelLayout);
        searchjPanelLayout.setHorizontalGroup(
            searchjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchjPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(materialjRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(marcajRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caducidadjRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cantidadjRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busquedajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        searchjPanelLayout.setVerticalGroup(
            searchjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(busquedajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(materialjRadioButton)
                        .addComponent(marcajRadioButton)
                        .addComponent(caducidadjRadioButton)
                        .addComponent(cantidadjRadioButton)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        choisejPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elige Registro:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        choisebuttonGroup.add(verDetallesjToggleButton);
        verDetallesjToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Yes.png"))); // NOI18N
        verDetallesjToggleButton.setText("Ver Detalles");
        verDetallesjToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verDetallesjToggleButtonActionPerformed(evt);
            }
        });

        choisebuttonGroup.add(cancelarjToggleButton);
        cancelarjToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/No.png"))); // NOI18N
        cancelarjToggleButton.setText("Cancelar");
        cancelarjToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarjToggleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout choisejPanelLayout = new javax.swing.GroupLayout(choisejPanel);
        choisejPanel.setLayout(choisejPanelLayout);
        choisejPanelLayout.setHorizontalGroup(
            choisejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choisejPanelLayout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(verDetallesjToggleButton)
                .addGap(45, 45, 45)
                .addComponent(cancelarjToggleButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        choisejPanelLayout.setVerticalGroup(
            choisejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choisejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(verDetallesjToggleButton)
                .addComponent(cancelarjToggleButton))
        );

        materialesjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Codigo", "Material", "Marca", "Caducidad", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        materialesjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialesjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(materialesjTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(choisejPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(searchjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choisejPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void materialjRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialjRadioButtonActionPerformed
        actualizarMaterial();
    }//GEN-LAST:event_materialjRadioButtonActionPerformed

    private void marcajRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcajRadioButtonActionPerformed
        actualizarMarca();
    }//GEN-LAST:event_marcajRadioButtonActionPerformed

    private void caducidadjRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caducidadjRadioButtonActionPerformed
        actualizarCodigo();
    }//GEN-LAST:event_caducidadjRadioButtonActionPerformed

    private void cantidadjRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadjRadioButtonActionPerformed
        actualizarDetalles();
    }//GEN-LAST:event_cantidadjRadioButtonActionPerformed

    private void materialesjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialesjTableMouseClicked
        ChoiseMaterial();
    }//GEN-LAST:event_materialesjTableMouseClicked

    private void cancelarjToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarjToggleButtonActionPerformed
        materialesjTable.clearSelection();
    }//GEN-LAST:event_cancelarjToggleButtonActionPerformed

    private void verDetallesjToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDetallesjToggleButtonActionPerformed
       if(materialesjTable.getSelectedRow()>-1)
       {
        int selected = materialesjTable.getSelectedRow();                  
        String id=materialesjTable.getValueAt(selected, 0).toString();
        String nombre=materialesjTable.getValueAt(selected, 2).toString();    
        int confirm= JOptionPane.showConfirmDialog(null, "¿Esta seguro?");
        if(confirm==0){
            ViewMateriales s =new ViewMateriales();
            Principal.jDesktopPane1.add(s);
            s.CargarMateriales(Integer.parseInt(id));
            s.show();
            JOptionPane.showMessageDialog(null, "La fila seleccionada es: "+nombre);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Se ha cancelado");
            materialesjTable.clearSelection();
        }
       }else{
           JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila","Error de Seleccion",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_verDetallesjToggleButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busquedajTextField;
    private javax.swing.JRadioButton caducidadjRadioButton;
    private javax.swing.JToggleButton cancelarjToggleButton;
    private javax.swing.JRadioButton cantidadjRadioButton;
    private javax.swing.ButtonGroup choisebuttonGroup;
    private javax.swing.JPanel choisejPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton marcajRadioButton;
    private javax.swing.JTable materialesjTable;
    private javax.swing.JRadioButton materialjRadioButton;
    private javax.swing.ButtonGroup searchbuttonGroup;
    private javax.swing.JPanel searchjPanel;
    private javax.swing.JToggleButton verDetallesjToggleButton;
    // End of variables declaration//GEN-END:variables
}
