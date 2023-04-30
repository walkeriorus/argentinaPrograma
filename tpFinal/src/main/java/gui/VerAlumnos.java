package gui;

import database.Database;
import java.awt.Color;
import java.awt.ComponentOrientation;
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
        //Definir el Layout del Panel
        int filas, columnas, hgap, vgap;
//        GridLayout panelGrilla = new GridLayout();
//        hgap = 10;
//        vgap = 10;
//        columnas = 1;
        //Seteo la separación vertical y horizontal entre filas y columnas.
//        panelGrilla.setHgap(hgap);
//        panelGrilla.setVgap(vgap);
        //Seteo la orientacion en que se disponen los elementos en el panel principal
        //Con esto los elementos se van ubicando de izquierda a derecha y de arriba hacia abajo.
//        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //Conexion a la base de datos
        Database db = new Database();
        db.conectar();
        Statement stmt = db.getStatement();
        String sql = "SELECT * FROM `tp_final`.alumnos";
        //Titulo del panel principal(Esto seria la primera fila dentro del panel)
        Font fuenteTitulos = new Font("Arial", 1, 14);
        //Panel para los titulos de las columnas
//        JPanel panelTitulos = panelGridLayout(1, 3);
        JLabel labelLegajo = new JLabel("Legajo");
        labelLegajo.setFont(fuenteTitulos);
        JLabel labelNombre = new JLabel("Nombre");
        labelNombre.setFont(fuenteTitulos);
        JLabel labelMaterias = new JLabel("Materias");
        labelMaterias.setFont(fuenteTitulos);
//        panelTitulos.add(labelLegajo);
//        panelTitulos.add(labelNombre);
//        panelTitulos.add(labelMaterias);

        try {
            //Consulta para determinar la cantidad de alumnos en la tabla alumnos.
//            ResultSet count = stmt.executeQuery("SELECT COUNT(legajo)FROM alumnos");
//            if (count.next()) {
//                filas = count.getInt(1);
//                count.close();
//                //Sabiendo la cantidad de filas defino la grilla del panel principal
////                panelGrilla.setRows(filas);
////                panelGrilla.setColumns(columnas);
////                setLayout(panelGrilla);
//            }
            //Consulta para obtener los datos de todos los alumnos en la tabla alumnos.
            ResultSet rs = stmt.executeQuery(sql);
            //Agrego el panelTitulos
//            add(panelTitulos);
            //Creación de las filas con la información sacada de la base de datos
            while (rs.next()) {
                //Por cada registro que viene en el ResultSet se crean 3 JLabel
                //con el contenido de los campos "legajo","nombre"y"materias_aprobadas"
                //de la tabla alumnos.
                String leg = rs.getString("legajo");
                String name = rs.getString("nombre");
                String mats = rs.getString("materias_aprobadas");
                JLabel lleg = new JLabel(leg);
                JLabel lname = new JLabel(name);
                JLabel lmats = new JLabel(mats);
                //Creo un JPanel con GridLayout de 1 fila y 3 columnas
                JPanel rowPanel = panelGridLayout(1, 3);
                //Se agregan todos los JLabels creados al JPanel usando el método
                //add( Component );
                rowPanel.add(lleg);
                rowPanel.add(lname);
                rowPanel.add(lmats);
                //Agrego el elemento rowPanel al panel principal
                add(rowPanel);
                add(new JSeparator());
            }
            System.out.println("Layout del panel principal: " + getLayout().toString());
            db.desconectar();
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
