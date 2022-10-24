import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;


public class puntajes {
    
    String[] cabecera = {"Nombre","Modo","Dificultad", "Tiempo", "Puntuacion"};
    JFrame ventanaPuntajes;
    JTable tabla ;
    JLayeredPane panelPuntajes;

   
   
    creacionxml obtenerMatriz = new creacionxml();

    public void generarTabla(){
       

        obtenerMatriz.registrosXML();
        ventanaPuntajes = new JFrame("Puntajes");
        ventanaPuntajes.setLayout(new FlowLayout());
        ventanaPuntajes.setSize(700,200);
        ventanaPuntajes.setResizable(false);
  
        JTable tabla = new JTable(obtenerMatriz.getDatosXML(),cabecera){
            
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==5){
                    return true;
                }else {
                    return false;
                }
                
            }

        };
  
        //        tabla.setGridColor(Color.WHITE);

        //No permite que se cambien las columnas de lugar en la tabla
        tabla.getTableHeader().setReorderingAllowed(false) ;
        tabla.setRowSelectionAllowed(false);

        //Para que no se pueda editar el tamaño de las columnas de la tabla
        TableColumnModel columnModel = tabla.getColumnModel();
        for(int i = 0; i < cabecera.length; i++){
            columnModel.getColumn(i).setResizable(false);
           

        }
        
        JScrollPane tablaa = new JScrollPane(tabla);
        
        tablaa.setPreferredSize(new Dimension(450,100));
        
      
       // ventanauntajes.add(tablaa);
        
        ventanaPuntajes.add(tablaa);
        //ventanauntajes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        ventanaPuntajes.setVisible(true);
       

    }

    public puntajes(){

    }

}
