package sistemaInscripciones;

import gui.MainWindow;


public class TpFinal {
    public static void main(String[] args){
        MainWindow ventana = new MainWindow();
        ventana.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ventana.setSize(1024, 720);
        ventana.setResizable(true);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
