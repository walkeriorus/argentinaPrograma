package gui;

import javax.swing.JPanel;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuSistema_AgregarAlumno = new javax.swing.JMenu();
        menuSistema_verMaterias = new javax.swing.JMenuItem();
        menuSistema_agregarMateria = new javax.swing.JMenuItem();
        menuSistema_verAlumnos = new javax.swing.JMenuItem();
        menuSistema_agregarAlumno = new javax.swing.JMenuItem();
        menuAlumnos = new javax.swing.JMenu();
        menuAlumnos_Inscripcion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Inscripciones");
        setSize(new java.awt.Dimension(0, 0));

        panel_1.setBackground(new java.awt.Color(255, 255, 255));
        panel_1.setMinimumSize(new java.awt.Dimension(468, 469));
        panel_1.setLayout(new java.awt.CardLayout());

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        menuSistema_AgregarAlumno.setText("Sistema");

        menuSistema_verMaterias.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuSistema_verMaterias.setText("Ver materias");
        menuSistema_verMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSistema_verMateriasActionPerformed(evt);
            }
        });
        menuSistema_AgregarAlumno.add(menuSistema_verMaterias);

        menuSistema_agregarMateria.setText("Agregar Materia");
        menuSistema_agregarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSistema_agregarMateriaActionPerformed(evt);
            }
        });
        menuSistema_AgregarAlumno.add(menuSistema_agregarMateria);

        menuSistema_verAlumnos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuSistema_verAlumnos.setText("Ver alumnos");
        menuSistema_verAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSistema_verAlumnosActionPerformed(evt);
            }
        });
        menuSistema_AgregarAlumno.add(menuSistema_verAlumnos);

        menuSistema_agregarAlumno.setText("Agregar Alumno");
        menuSistema_agregarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSistema_agregarAlumnoActionPerformed(evt);
            }
        });
        menuSistema_AgregarAlumno.add(menuSistema_agregarAlumno);

        jMenuBar1.add(menuSistema_AgregarAlumno);

        menuAlumnos.setText("Alumnos");

        menuAlumnos_Inscripcion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuAlumnos_Inscripcion.setText("Inscripción a materias");
        menuAlumnos_Inscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlumnos_InscripcionActionPerformed(evt);
            }
        });
        menuAlumnos.add(menuAlumnos_Inscripcion);

        jMenuBar1.add(menuAlumnos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAlumnos_InscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlumnos_InscripcionActionPerformed

    }//GEN-LAST:event_menuAlumnos_InscripcionActionPerformed

    private void menuSistema_verAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSistema_verAlumnosActionPerformed
        VerAlumnos verAlumnos = new VerAlumnos();
        cambiarPanel(verAlumnos);
    }//GEN-LAST:event_menuSistema_verAlumnosActionPerformed

    private void menuSistema_agregarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSistema_agregarAlumnoActionPerformed

        PanelAlumno panelAlumno = new PanelAlumno();
        cambiarPanel(panelAlumno);
        System.out.println(panel_1.getClass().toString());
    }//GEN-LAST:event_menuSistema_agregarAlumnoActionPerformed

    private void menuSistema_verMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSistema_verMateriasActionPerformed
        // TODO add your handling code here:
        VerMaterias panelMaterias = new VerMaterias();
        cambiarPanel(panelMaterias);
        System.out.println("Menu Sistema, opción ver Materias.");
    }//GEN-LAST:event_menuSistema_verMateriasActionPerformed

    private void menuSistema_agregarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSistema_agregarMateriaActionPerformed
        // TODO add your handling code here:
        PanelMateria panelMateria = new PanelMateria();
        cambiarPanel(panelMateria);
    }//GEN-LAST:event_menuSistema_agregarMateriaActionPerformed
    public void cambiarPanel(JPanel panel) {

        panel_1.removeAll();
        panel_1.add(panel);
        panel_1.repaint();
        panel_1.revalidate();
        panel_1.setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAlumnos;
    private javax.swing.JMenuItem menuAlumnos_Inscripcion;
    private javax.swing.JMenu menuSistema_AgregarAlumno;
    private javax.swing.JMenuItem menuSistema_agregarAlumno;
    private javax.swing.JMenuItem menuSistema_agregarMateria;
    private javax.swing.JMenuItem menuSistema_verAlumnos;
    private javax.swing.JMenuItem menuSistema_verMaterias;
    private javax.swing.JPanel panel_1;
    // End of variables declaration//GEN-END:variables
}
