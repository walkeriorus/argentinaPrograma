package gui;
import database.Database;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
public class VerAlumnos extends javax.swing.JPanel {

    public VerAlumnos() {
        initComponents();
        inicio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(468, 469));
        setName("panVerAlumnos"); // NOI18N
        setPreferredSize(new java.awt.Dimension(468, 469));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
    }// </editor-fold>//GEN-END:initComponents

    private void inicio(){
        //Definir el Layout del Panel
        int filas,columnas,hgap,vgap;
        filas = 10;
        columnas = 3;
        hgap = 10;
        vgap = 10;
        GridLayout grillaPanel = new GridLayout(filas,columnas,hgap,vgap);
        System.out.println("Columnas del panel verAlumnos: " + grillaPanel.getColumns());
        System.out.println("Filas del panel verAlumnos: " + grillaPanel.getRows());
        setLayout(grillaPanel);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //
        Database db = new Database();
        db.conectar();
        Statement stmt = db.getStatement();
        String sql = "SELECT * FROM `tp_final`.alumnos";
        //Titulo del panel
        Font fuenteTitulos = new Font("Arial",1,14);

        JLabel labelLegajo = new JLabel("Legajo");
        labelLegajo.setFont(fuenteTitulos);
        JLabel labelNombre = new JLabel("Nombre");
        labelNombre.setFont(fuenteTitulos);
        JLabel labelMaterias = new JLabel("Materias");
        labelMaterias.setFont(fuenteTitulos);
        add(labelLegajo);
        add(labelNombre);
        add(labelMaterias);
        try{
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String leg = rs.getString("legajo");
                String name = rs.getString("nombre");
                String mats = rs.getString("materias_aprobadas");
                JLabel lleg = new JLabel(leg);
                JLabel lname = new JLabel(name);
                JLabel lmats = new JLabel(mats);

                add(lleg);
                add(lname);
                add(lmats);
                System.out.println(String.format("Alumno: %s\tLegajo: %s\nMaterias aprobadas: %s", name,leg, mats));

            }
        }catch(SQLException sqlExc){
            System.out.println("Error");
            System.out.println(sqlExc);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
