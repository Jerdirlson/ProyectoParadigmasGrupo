import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Menu extends JFrame implements ActionListener{
		
	public int tamTablero, cartasAJugar, modalidad;
	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
		JFrame ventanaMenu;
		JLabel fondoMenu, etiquetaTitulo, etiquetaDificultad, etiquetaModo, nombreJugador;
		JToggleButton boton1dificultad, boton2dificultad, boton3dificultad, boton1modo,boton2modo,boton3modo;
		JButton botonJugar;


		private JLabel fondoPanelMenu;


		JLayeredPane panelMenu, panelMenu2;


		private JLabel etiquetaNombreJugador;
		
		private String nombreJugador2;


		private JTextField txtNomJugador;


		private JButton iniciarJuego, botonSalir;


		private JLabel labelnombreJugador2;


		
		/**
		 * 
		 */
		@SuppressWarnings("removal")
		public Menu() {
			
			//Propiedades de esta ventana
			
			ventanaMenu = new JFrame ("Menu juego");
			ventanaMenu.setSize(1440,800);
			ventanaMenu.setLayout(null);
			ventanaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventanaMenu.setLocationRelativeTo(panelMenu);
			ventanaMenu.setResizable(false);
			ventanaMenu.setVisible(false);
			
			//Propiedades del panelMenu
			
			panelMenu = new JLayeredPane();
			panelMenu.setSize(ventanaMenu.getWidth(),ventanaMenu.getHeight());
			panelMenu.setLayout(null);
			panelMenu.setLocation(0,0);
			panelMenu.setVisible(true);
			ventanaMenu.add(panelMenu,0); 
			
			botonSalir = new JButton("Salir");
         botonSalir.setBounds(55, 25, 100, 50);
         botonSalir.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
         botonSalir.addActionListener(this);
         ventanaMenu.add(botonSalir);
			
			//Propiedades del label
			
			fondoMenu = new JLabel();
			fondoMenu.setSize(ventanaMenu.getWidth(),ventanaMenu.getHeight());
			fondoMenu.setIcon(new ImageIcon("imagenes/Fondo Juego.png"));
			fondoMenu.setVisible(true);
			fondoMenu.setLocation(0,0);
			panelMenu.add(fondoMenu,new Integer(1));
			
			
			//Creacion etiquetaTitulo
			
			etiquetaTitulo = new JLabel ("Elija los modos de juego");  //Se establece lo que debe contener la etiqueta 
			etiquetaTitulo.setBounds(300, 80, 900, 100);		//Se utiliza para definir un rectangulo delimitador para la etiqueta 
			etiquetaTitulo.setFont(new Font("Showcard Gothic", Font.PLAIN, 65));		//se usa para definir el tipo de letra y el tamaño
			panelMenu.add(etiquetaTitulo, new Integer(2));	
			
			//Dificultad
			
			etiquetaDificultad = new JLabel ("Dificultades");
			etiquetaDificultad.setBounds(250,180,400,60);
			etiquetaDificultad.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
			panelMenu.add(etiquetaDificultad, new Integer(3));
			
			//Creacion de los botones
			
			//Creacion del primer boton con dificultad 4x4
			boton1dificultad = new JToggleButton ("4x4", false);
			boton1dificultad.setBounds(320,250,150,80);
			boton1dificultad.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
			panelMenu.add(boton1dificultad,new Integer(4));
			boton1dificultad.addActionListener(this);
			
			//Creacion del segundo boton con dificultad 6x6
			
			boton2dificultad = new JToggleButton ("6x6", false);
			boton2dificultad.setBounds(320,370,150,80);
			boton2dificultad.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
			panelMenu.add(boton2dificultad, new Integer(5));
			boton2dificultad.addActionListener(this);
			
			//Creacion del tercer boton con dificultad 8x8
			
			boton3dificultad = new JToggleButton ("8x8", false);
			boton3dificultad.setBounds(320,490,150,80);
			boton3dificultad.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
			panelMenu.add(boton3dificultad,new Integer(6));
			boton3dificultad.addActionListener(this);
			
			
			//Modos de juego
			
			etiquetaModo = new JLabel("Modo de juego");
			etiquetaModo.setBounds(850, 180, 400, 60);
			etiquetaModo.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
			panelMenu.add(etiquetaModo, new Integer(7));
			
			//Creacion de boton modo solo
			
			boton1modo = new JToggleButton ("Solo", false);
			boton1modo.setBounds(920,250,150,80);
			boton1modo.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
			panelMenu.add(boton1modo,new Integer(8));
			boton1modo.addActionListener(this);
			
			//Creacion de boton 1vs1
			
			boton2modo = new JToggleButton ("1VS1", false);
			boton2modo.setBounds(920,370,150,80);
			boton2modo.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
			panelMenu.add(boton2modo, new Integer(9));
			boton2modo.addActionListener(this);
			
			//Creacion de boton 1vs maquina
			
			boton3modo = new JToggleButton ("VS IA", false);
			boton3modo.setBounds(920,490,150,80);
			boton3modo.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
			panelMenu.add(boton3modo, new Integer(10));
			boton3modo.addActionListener(this);
			
			//Creacion del boton jugar
			
			botonJugar = new JButton ("Jugar!!");
			botonJugar.setBounds(600, 620, 200, 80);
			botonJugar.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
			panelMenu.add(botonJugar, new Integer(11));
			botonJugar.addActionListener(this);
			
			nombreJugador = new JLabel();
			nombreJugador.setBounds(700, 180, 400, 60);
			nombreJugador.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
			
			labelnombreJugador2 = new JLabel();
			labelnombreJugador2.setBounds(700, 180, 400, 60);
			labelnombreJugador2.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
			
			
			
			//---------------MenuModo2------------------------------
			
			panelMenu2 = new JLayeredPane();
			panelMenu2.setSize(ventanaMenu.getWidth(),ventanaMenu.getHeight());
			panelMenu2.setLayout(null);
			panelMenu2.setLocation(0,0);
			panelMenu2.setVisible(true);
			ventanaMenu.add(panelMenu,0); 
			
			
			fondoPanelMenu = new JLabel();
			fondoPanelMenu.setSize(1500, 1000);   //ImagenPrueba3 (1500,1000) check			-- 
			fondoPanelMenu.setLocation(0,0);
			fondoPanelMenu.setIcon(new ImageIcon("Imagenes/ImagenPrueba3.jpg"));
			
			
			
			etiquetaTitulo = new JLabel ("Segundo Jugador");  //Se establece lo que debe contener la etiqueta 
			etiquetaTitulo.setBounds(470, 80, 600, 70);		//Se utiliza para definir un rectangulo delimitador para la etiqueta 
			etiquetaTitulo.setFont(new Font("Showcard Gothic", Font.PLAIN, 60));		//se usa para definir el tipo de letra y el tamaño
			
			etiquetaNombreJugador = new JLabel ("Inserte segundo nombre: ");
			etiquetaNombreJugador.setBounds(570,200,600,70);
			etiquetaNombreJugador.setFont(new Font("Cooper Black", Font.PLAIN, 30));
		
			txtNomJugador = new JTextField();
			txtNomJugador.setBounds(540,300,400,40);
			txtNomJugador.setHorizontalAlignment(JTextField.CENTER);			//Se utilizar para centrar el texto
			txtNomJugador.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 20));
			
			
			iniciarJuego = new JButton("Iniciar juego");
			iniciarJuego.setBounds(590,400,300,45);
			iniciarJuego.setFont(new Font("Cooper Black", Font.PLAIN, 15));
			iniciarJuego.addActionListener(this);					//Para detectar y manejar los eventos de una accion, osea presionarlo
			
			
			panelMenu2.add(fondoPanelMenu, new Integer(1));
			panelMenu2.add(etiquetaTitulo, new Integer(2));
			panelMenu2.add(etiquetaNombreJugador, new Integer(3));
			panelMenu2.add(txtNomJugador, new Integer(4));
			panelMenu2.add(iniciarJuego, new Integer(5));
			
			
			ventanaMenu.add(panelMenu);
			panelMenu.setVisible(true);
			ventanaMenu.add(panelMenu2);
			panelMenu2.setVisible(false);	
			ventanaMenu.setVisible(true);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Tableros tablero = new Tableros();
			boolean confirmacion1 = false;
			boolean confirmacion2 = false;
			
			if (e.getSource() == botonSalir) {
			
			ventanaMenu.setVisible(false);
			
			MenuDeInicio ventana = new MenuDeInicio();
		   ventana.setVisible(true);
		
			}
			
			if (e.getSource() == boton1dificultad) {
				boton2dificultad.setSelected(false);;
				boton3dificultad.setSelected(false);	
				tamTablero = 4;
				cartasAJugar = 8;
			}
			
			if (e.getSource() == boton2dificultad) {
				boton1dificultad.setSelected(false);
				boton3dificultad.setSelected(false);
				tamTablero = 6;
				cartasAJugar = 18;
			}
			
			if (e.getSource() == boton3dificultad) {
				boton1dificultad.setSelected(false);
				boton2dificultad.setSelected(false);
				tamTablero = 8;
				cartasAJugar = 32;
			}
			
			if (e.getSource() == boton1modo) {
				boton2modo.setSelected(false);
				boton3modo.setSelected(false);
				modalidad = 1;
			}
			if (e.getSource() == boton2modo) {
				boton1modo.setSelected(false);
				boton3modo.setSelected(false);
				modalidad = 2;	
			}
			if (e.getSource() == boton3modo) {
				boton1modo.setSelected(false);
				boton2modo.setSelected(false);
				modalidad = 3;
			}
			
			if (e.getSource() == botonJugar) {
				
				if (boton2modo.isSelected() == true ) {
					
					nombreJugador2 = JOptionPane.showInputDialog(null,"Digite el nombre Jugador 2: ", "Nombre jugador 2", JOptionPane.QUESTION_MESSAGE );
					labelnombreJugador2.setText(nombreJugador2);
					
				}
				
				if ((boton1dificultad.isSelected() == true) || (boton2dificultad.isSelected() == true)||(boton3dificultad.isSelected() == true)) {
					confirmacion1 = true;
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Seleccionar dificultad.");
				}
				
				if ((boton1modo.isSelected() == true) || ((boton2modo.isSelected() == true)&&(nombreJugador2 != null))||(boton3modo.isSelected() == true)) {
					confirmacion2 = true;
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Seleccionar modo.");

				}
				
				if ((confirmacion1 == true) && (confirmacion2 == true) ) {
					
					tablero.ventanaPartida(tamTablero, cartasAJugar, modalidad);
					ventanaMenu.setVisible(false);
					
					if (boton2modo.isSelected() == true ) {
					tablero.labelNombreJugadorDos.setText(labelnombreJugador2.getText());
					}
					
					//Para pasar el nombre del jugador a la clase Juego
					tablero.nombreJugador.setText(nombreJugador.getText());
					
					
					if (boton1dificultad.isSelected() == true) {
						
						tablero.tipoDificultad.setText(boton1dificultad.getText());
					}
					
					if (boton2dificultad.isSelected() == true) {
						
						tablero.tipoDificultad.setText(boton2dificultad.getText());
					}
					
					if (boton3dificultad.isSelected() == true) {
						
						tablero.tipoDificultad.setText(boton3dificultad.getText());
					}
					
					if (boton1modo.isSelected() == true) {
						tablero.tipoModo.setText(boton1modo.getText());
					}
					if (boton2modo.isSelected() == true) {
						tablero.tipoModo.setText(boton2modo.getText());
						
					}
					if (boton3modo.isSelected() == true) {
						tablero.tipoModo.setText(boton3modo.getText());
					}
						
					}
				
				
					
					
				}
				
			}

		public int getTamTablero() {
			return tamTablero;
		}

		public int getCartasAJugar() {
			return cartasAJugar;
		}

		public int getModalidad() {
			return modalidad;
		}
		
			
		
}
