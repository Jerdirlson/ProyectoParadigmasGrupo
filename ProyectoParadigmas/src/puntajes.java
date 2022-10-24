import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class puntajes {
    

    String[] cabecera = {"Nombre","Modo","Dificultad", "Tiempo", "Puntuacion"};
    JFrame ventanauntajes;
    JTable tabla ;
   


    creacionxml obtenerMatriz = new creacionxml();



    public void generarTabla(){
       

        obtenerMatriz.registrosXML();
        ventanauntajes = new JFrame("Puntajes");
        ventanauntajes.setLayout(new FlowLayout());
        ventanauntajes.setSize(700,200);

        JTable tabla = new JTable(obtenerMatriz.getDatosXML(),cabecera);
        JScrollPane tablaa = new JScrollPane(tabla);
        tablaa.setPreferredSize(new Dimension(450,100));
        
        ventanauntajes.add(tablaa);
        //ventanauntajes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        ventanauntajes.setVisible(true);
       

    }

    public puntajes(){

    }

}
