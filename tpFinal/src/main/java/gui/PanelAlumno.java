package gui;

import database.Database;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class PanelAlumno extends javax.swing.JPanel {

    public PanelAlumno() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelLegajo = new javax.swing.JLabel();
        txtLegajo = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        labelMaterias = new javax.swing.JLabel();
        txtMaterias = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(320, 240));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Datos del alumno");

        labelLegajo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelLegajo.setText("Nro de Legajo");
        labelLegajo.setToolTipText("Ingrese un número entre 0 y 99999");

        txtLegajo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLegajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLegajoActionPerformed(evt);
            }
        });

        labelNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNombre.setText("Nombre");
        labelNombre.setToolTipText("Ingrese el nombre del alumno");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        labelMaterias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelMaterias.setText("Materias");
        labelMaterias.setToolTipText("Ingrese las materias separadas por una \",\"");

        txtMaterias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMateriasActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("Limpia todos los campos del formulario");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Envia los datos a la base de datos");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelTitulo)
                        .addGap(124, 124, 124))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelMaterias)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(labelNombre)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnLimpiar)
                                .addComponent(labelLegajo))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnGuardar))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelTitulo)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLegajo)
                    .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaterias)
                    .addComponent(txtMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar))
                .addGap(75, 75, 75))
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean validarLegajo(String legajo) {
        //Válida que el String legajo sea un número que contenga de 1 a 5 digítos.
        //Si el String pasa la validación retorna true, sino false.
        return legajo.matches("[0-9]{1,5}");
    }
    public void limpiarCampos(){
        txtLegajo.setText("");
        txtNombre.setText("");
        txtMaterias.setText("");
    }
    private void txtLegajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLegajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLegajoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMateriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMateriasActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        try{
            Database db = new Database();
            db.conectar();
            Statement stmt = db.getStatement();
            String sql ="INSERT INTO alumnos VALUES(\"%s\",\"%s\",\"%s\")";
            String legajo = txtLegajo.getText();
            String nombre = txtNombre.getText();
            String materias_aprobadas = txtMaterias.getText();
            String query = String.format(sql,legajo,nombre,materias_aprobadas);
            if(validarLegajo(legajo)){
                stmt.executeUpdate(query);
                limpiarCampos();
                JOptionPane.showMessageDialog(null,"Datos guardados con éxito.");
            }
            else{
                JOptionPane.showMessageDialog(null,"El legajo ingresado no es válido.");
            }
            db.desconectar();
        }catch(SQLException sqlExc){
            System.out.println("Algo salió mal");
            JOptionPane.showMessageDialog(null, sqlExc);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel labelLegajo;
    private javax.swing.JLabel labelMaterias;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField txtLegajo;
    private javax.swing.JTextField txtMaterias;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
