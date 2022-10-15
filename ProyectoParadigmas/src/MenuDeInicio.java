
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuDeInicio extends JFrame implements ActionListener{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	
	JLabel nomjudador,etiquetaTitulo, etiquetaNombreJugador, fondoPanel, creditos;
   JButton puntajes,iniciarJuego,salir;
   JTextField txtNomJugador;
   
	
		public MenuDeInicio () {
			
			this.setTitle("Menu");
			this.setSize(1440,800) ;		//Definimos el tamaño
			this.setLocationRelativeTo(null);		//definimos que se centre en la pantalla 
	      this.setDefaultCloseOperation(EXIT_ON_CLOSE);		//para que el programa despues de cerrado no se ejecute en segundo plano 
	      this.setResizable(false);		//Quita el poder maximizar la pantalla
	      this.setLayout(null);
	      componentes();
		}
		
		//Este metodo contiene todos los componentes
		
		@SuppressWarnings("removal")
		public void componentes() {
			
			JLayeredPane panel = new JLayeredPane();
			panel.setLayout(null);
			panel.setSize(1440, 800);
			panel.setLocation(0,0);
			panel.setVisible(true);
			
			this.getContentPane().add(panel);

			fondoPanel = new JLabel();
			fondoPanel.setSize(1500, 1000);   //ImagenPrueba3 (1500,1000) check			-- 
			fondoPanel.setLocation(0,0);
			fondoPanel.setIcon(new ImageIcon("Imagenes/ImagenPrueba3.jpg"));
			panel.add(fondoPanel, new Integer(1));
			
			
			etiquetaTitulo = new JLabel ("Juego de memoria");  //Se establece lo que debe contener la etiqueta 
			etiquetaTitulo.setBounds(470, 80, 600, 70);		//Se utiliza para definir un rectangulo delimitador para la etiqueta 
			etiquetaTitulo.setFont(new Font("Showcard Gothic", Font.PLAIN, 60));		//se usa para definir el tipo de letra y el tamaño
			
			
			etiquetaNombreJugador = new JLabel ("Nombre del jugador");
			etiquetaNombreJugador.setBounds(570,200,600,70);
			etiquetaNombreJugador.setFont(new Font("Cooper Black", Font.PLAIN, 30));
			
			
			//Caja de texto donde se coloca el nombre del jugador
			
			txtNomJugador = new JTextField();
			txtNomJugador.setBounds(540,300,400,40);
			txtNomJugador.setHorizontalAlignment(JTextField.CENTER);			//Se utilizar para centrar el texto
			txtNomJugador.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 20));
			
			
			creditos = new JLabel ("Creditos a: Jerdirlson Santamaria - Juan Diego Sanabria");  //Se establece lo que debe contener la etiqueta 
			creditos.setBounds(900, 700, 500, 60);		//Se utiliza para definir un rectangulo delimitador para la etiqueta 
			creditos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));		//se usa para definir el tipo de letra y el tamaño
			
			//Boton de iniciar el juego
			
			iniciarJuego = new JButton("Iniciar juego");
			iniciarJuego.setBounds(590,400,300,45);
			iniciarJuego.setFont(new Font("Cooper Black", Font.PLAIN, 15));
			iniciarJuego.addActionListener(this);					//Para detectar y manejar los eventos de una accion, osea presionarlo
			
			
			
			//Boton donde va a mostrar los puntajes
			
			puntajes = new JButton("Puntajes");
			puntajes.setBounds(590,480,300,45);
			puntajes.setFont(new Font("Cooper Black", Font.PLAIN, 15));
			puntajes.addActionListener(this);
			
			
			
			//Boton para salir 
			salir = new JButton("Salir");
			salir.setBounds(590,560,300,45);
			salir.setFont(new Font("Cooper Black", Font.PLAIN, 15));
			salir.addActionListener(this);
			
			
			panel.add(etiquetaTitulo, new Integer(3));							//Agrega la etiqueta al panel
			panel.add(etiquetaNombreJugador, new Integer(4));
			panel.add(txtNomJugador, new Integer(5));
			panel.add(creditos, new Integer(6));
			panel.add(iniciarJuego, new Integer(7));
			panel.add(puntajes, new Integer(8));
			panel.add(salir, new Integer(9));
		}

		
		//Eventos de accion de cada boton
		
		public void actionPerformed(ActionEvent e) {	//action event e es para representar la accion de un usuario en la interfaz
			
			//Esto es lo que va a realizar el boton de iniciar el juego
			
			if (e.getSource() == iniciarJuego) {			//getsource saber si el boton esta presionado 
				
				if (txtNomJugador.getText().equals("")) {		//Esto se hace para comprobar si la casilla de nombre tiene algo
					JOptionPane.showMessageDialog(null, "Colocar nombre de jugador");
				}
				else {
					//De lo contrario se debe iniciar el juego de memoria
					
					Menu ventana = new Menu();
					
					//definimos que el nombre jugador va a obtener el valor que se coloco en txtnomjugador
					
					ventana.nombreJugador.setText(txtNomJugador.getText());

					
					this.setVisible(false);
				}
			}
			
			//Muestra los puntajes
			
			
			
			
			//Este es el boton de salir 
			
			if (e.getSource() == salir) {
				
				//La idea es que muestre una ventana donde pregunte si quiere salir
				if (JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro de querer salir de la aplicacion?",
		               "Salir del juego", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
		               System.exit(0);
				
			}
		}
		
}
