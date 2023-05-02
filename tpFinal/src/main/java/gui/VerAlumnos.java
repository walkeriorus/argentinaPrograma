package gui;

import database.Database;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

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
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void inicio() {
        int filas;
        Database db = new Database();
        db.conectar();
        Statement stmt = db.getStatement();
        String sql = "SELECT * FROM `tp_final`.alumnos";
        //Titulo del panel principal(Esto seria la primera fila dentro del panel)
        Font fuenteTitulos = new Font("Arial", 1, 14);
        //JPanel para el Titulo de las columnas
        JPanel titulosColumnas = new JPanel();
        titulosColumnas.setPreferredSize(new Dimension(1024,50));
        titulosColumnas.setMaximumSize(new Dimension(1024,100));
        titulosColumnas.setLayout(new GridLayout(1,3));
        //Creo un separador horizontal
        JSeparator separador_hor = new JSeparator();
        separador_hor.setPreferredSize(new Dimension(1024,2));
//        titulosColumnas.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        //
        JLabel labelLegajo = new JLabel("Legajo");
        labelLegajo.setFont(fuenteTitulos);
        JLabel labelNombre = new JLabel("Nombre");
        labelNombre.setFont(fuenteTitulos);
        JLabel labelMaterias = new JLabel("Materias");
        labelMaterias.setFont(fuenteTitulos);
        //
        titulosColumnas.add(labelLegajo);
        titulosColumnas.add(labelNombre);
        titulosColumnas.add(labelMaterias);
        add(titulosColumnas,"North");
        
        //Panel para poner las filas de información de cada alumno,tendra un GridLayout
        JPanel panelCampos = new JPanel();
        panelCampos.setPreferredSize(new Dimension(1024,620));
        try {
            //Consulta para determinar la cantidad de alumnos en la tabla alumnos.
            ResultSet count = stmt.executeQuery("SELECT COUNT(legajo)FROM alumnos");
            if (count.next()) {
                filas = count.getInt(1);
                count.close();
                
                panelCampos.setLayout(new GridLayout(filas,3));
                //Consulta para obtener los datos de todos los alumnos en la tabla alumnos.
                ResultSet rs = stmt.executeQuery(sql);
                //Creación de las filas con la información sacada de la base de datos
                Dimension dimensionesFilas = new Dimension(1024/3,(720-50)/filas);
                while (rs.next()) {
                    //Por cada registro que viene en el ResultSet se crean 3 JLabel
                    //con el contenido de los campos "legajo","nombre"y"materias_aprobadas"
                    //de la tabla alumnos.
                    String leg = rs.getString("legajo");
                    String name = rs.getString("nombre");
                    String mats = rs.getString("materias_aprobadas");
                    JLabel lleg = new JLabel(leg);
                    lleg.setPreferredSize(dimensionesFilas);
                    lleg.setFont(fuenteTitulos);
                    JLabel lname = new JLabel(name);
                    lname.setPreferredSize(dimensionesFilas);
                    lname.setFont(fuenteTitulos);
                    JLabel lmats = new JLabel(mats);
                    lmats.setPreferredSize(dimensionesFilas);
                    lmats.setFont(fuenteTitulos);
                    //Agrego los JLabels creados al JPanel panelCampos usando el método add()
                    panelCampos.add(lleg);
                    panelCampos.add(lname);
                    panelCampos.add(lmats);

                }
                
                //
                add(panelCampos,"South");
                System.out.println("Layout del panel principal: " + getLayout().toString());
                db.desconectar();
            }
        }
        catch (SQLException sqlExc) {
            System.out.println("Error");
            System.out.println(sqlExc);
        }
    }

    public JPanel panelGridLayout(int filas, int columnas) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(filas, columnas));
        return jPanel;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
