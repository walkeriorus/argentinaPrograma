package gui;
import database.Database;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class FormAlumno extends javax.swing.JFrame {
    public FormAlumno() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labLegajo = new javax.swing.JLabel();
        textLegajo = new javax.swing.JTextField();
        labNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        labMaterias = new javax.swing.JLabel();
        textMateriasAprobadas = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Carga de datos del alumno");

        labLegajo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labLegajo.setText("Nro º de Legajo:");
        labLegajo.setToolTipText("Ingrese un número entre 0 y 99999");

        textLegajo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textLegajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLegajoActionPerformed(evt);
            }
        });

        labNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labNombre.setText("Nombre:");
        labNombre.setToolTipText("Ingrese el nombre del alumno");

        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreActionPerformed(evt);
            }
        });

        labMaterias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labMaterias.setText("Materias ");
        labMaterias.setToolTipText("Ingrese las materias aprobadas separadas por una \",\"");

        textMateriasAprobadas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMateriasAprobadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMateriasAprobadasActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("Vacía el valor de todos los campos.");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Enviar los datos a la base de datos.");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 57, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labLegajo)
                            .addComponent(labNombre)
                            .addComponent(labMaterias)
                            .addComponent(btnLimpiar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textLegajo)
                            .addComponent(textNombre)
                            .addComponent(textMateriasAprobadas)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnGuardar)))))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labLegajo)
                    .addComponent(textLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNombre)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labMaterias)
                    .addComponent(textMateriasAprobadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean validarLegajo(String legajo) {
        //Válida que el String legajo sea un número que contenga de 1 a 5 digítos.
        //Si el String pasa la validación retorna true, sino false.
        return legajo.matches("[0-9]{1,5}");
    }
    public void limpiarCampos(){
        textLegajo.setText("");
        textNombre.setText("");
        textMateriasAprobadas.setText("");
    }
    private void textLegajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLegajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLegajoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        Database db = new Database();
        db.conectar();
        Statement stmt = db.getStatement();
        String sql ="INSERT INTO alumnos VALUES(\"%s\",\"%s\",\"%s\")";
        try{
            String legajo = textLegajo.getText();
            String nombre = textNombre.getText();
            String materias_aprobadas = textMateriasAprobadas.getText();
            String query = String.format(sql,legajo,nombre,materias_aprobadas);
            if(validarLegajo(legajo)){
                stmt.executeUpdate(query);
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

    private void textMateriasAprobadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMateriasAprobadasActionPerformed
 
    }//GEN-LAST:event_textMateriasAprobadasActionPerformed

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed

    }//GEN-LAST:event_textNombreActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labLegajo;
    private javax.swing.JLabel labMaterias;
    private javax.swing.JLabel labNombre;
    private javax.swing.JTextField textLegajo;
    private javax.swing.JTextField textMateriasAprobadas;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
