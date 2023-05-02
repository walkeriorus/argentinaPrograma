package gui;

import database.Database;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VerMaterias extends javax.swing.JPanel {

    public VerMaterias() {
        initComponents();
        inicio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName("panelMaterias"); // NOI18N
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));
    }// </editor-fold>//GEN-END:initComponents
    private void inicio() {
        int filas;
        Database db = new Database();
        db.conectar();
        Statement stmt = db.getStatement();
        String sql = "SELECT * FROM `tp_final`.materias";
        //Titulo del panel principal(Esto seria la primera fila dentro del panel)
        Font fuenteTitulos = new Font("Arial", 1, 14);
        JPanel titulosColumnas = new JPanel();
        titulosColumnas.setPreferredSize(new Dimension(1024, 50));
        titulosColumnas.setLayout(new GridLayout(1, 2));

        JLabel labelNombre = new JLabel("Nombre");
        labelNombre.setFont(fuenteTitulos);
        JLabel labelCorrelativas = new JLabel("Correlativas");
        labelCorrelativas.setFont(fuenteTitulos);
        //
        titulosColumnas.add(labelNombre);
        titulosColumnas.add(labelCorrelativas);
        add(titulosColumnas, "North");

        //Panel para poner las filas de información de cada alumno,tendra un GridLayout
        JPanel panelDatos = new JPanel();
        panelDatos.setPreferredSize(new Dimension(1024, 620));
        try {
            //Consulta para determinar la cantidad de alumnos en la tabla alumnos.
            ResultSet count = stmt.executeQuery("SELECT COUNT(nombre)FROM materias");
            if (count.next()) {
                filas = count.getInt(1);
                count.close();
                panelDatos.setLayout(new GridLayout(filas, 2));
                //Consulta para obtener los datos de todos las materias
                ResultSet rsMaterias = stmt.executeQuery(sql);
                //Creación de las filas con la información sacada de la base de datos
                Dimension dimensionesFilas = new Dimension(1024 / 2, (720 - 50) / filas);
                while (rsMaterias.next()) {
                    String nombre = rsMaterias.getString("nombre");
                    String correl = rsMaterias.getString("correlativas");
                    //
                    JLabel l_nombre = new JLabel(nombre);
                    l_nombre.setPreferredSize(dimensionesFilas);
                    l_nombre.setFont(fuenteTitulos);
                    //
                    JLabel l_correl = new JLabel(correl);
                    l_correl.setPreferredSize(dimensionesFilas);
                    l_correl.setFont(fuenteTitulos);
                    //
                    panelDatos.add(l_nombre);
                    panelDatos.add(l_correl);
                }

                //
                add(panelDatos, "South");
                System.out.println("Layout del panel principal: " + getLayout().toString());
                db.desconectar();
            }
        }
        catch (SQLException sqlExc) {
            System.out.println("Error");
            System.out.println(sqlExc);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
