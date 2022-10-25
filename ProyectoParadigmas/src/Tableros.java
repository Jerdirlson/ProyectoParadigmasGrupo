import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

//Cuando se termine el juego se tiene que parar el contador 
public class Tableros implements ActionListener {
	private JLabel fondoPanel, fondoPanelGeneral;

	JLabel nombreJugador;
	JLabel tipoDificultad;
	JLabel tipoModo;
	private JLabel fondoPanelJuego;

	private JButton[][] matrizBotones; // En esta matriz se crean los botones
	private Cartas[][] matriz; // Una matriz auxiliar para guardar la aleaotriedad de las cartas

	private int temp; // Obtiene el id de la primera carta
	private int temp2; // Obtiene el id de la segunca carta
	private int cartaSelec1x; // Obtiene la posicion x de la primera carta
	private int cartaSelec1y; // Obtiene la posicion y de la primera carta
	private int cartaSelec2x; // Obtiene la posicion x de la segunda carta
	private int cartaSelec2y; // Obtiene la posicion y de la segunda carta
	private int contador = 0; // Contador de cuantas cartas han sido seleccionadas
	private int posX; // Posicion x de la carta
	private int posY; // Posicion y de la carta

	static private int seg, min; // Para el contador de segundos
	static private Timer tiempo;
	static JLabel cronometro;
	private TimerTask tarea;

	int puntuacion = 0; // Puntuacion acumulada
	int puntuacionJugador2 = 0;

	private int CartasAjugar;
	private int contadorPares = 0;

	private int contadorTurnoJugadores = 0;

	private boolean sumarContador = true; // Booleano utilizado para verificar si el contador va a aumentar
	private boolean carta1 = true; // Seleccion de carta Btn
	private boolean carta2 = true; // Seleccion de carta Btn

	JLabel labelNombreJugadorDos;

	private JButton botonSalir;

	private JLabel ponerPuntuacion; // Label de puntuacion
	private JLabel ponerPuntuacionJugadorDos;

	private JFrame frame; // ventana donde se mostrará el juego

	private JLabel turnos;

	private JLayeredPane panelJuego;
	private JLayeredPane panel;
	private JLayeredPane panelGeneral;

	@SuppressWarnings({ "removal" })
	public void componentes() {

		// -------------------------------------------Panel------------------------------------
		// Propiedades JPanel
		panel = new JLayeredPane();
		panel.setLayout(null); // Esto nos permite colocar los demas componentes donde queramos
		panel.setSize(1440, 800); // Aqui va el tamaño del panel, en este caso va a variar con el tamaño que tenga
									// la ventana
		panel.setLocation(0, 0); // Esto nos permite definir de donde va a empezar nuestro panel
		frame.add(panel, new Integer(1)); // Aqui lo agregamos a el panel a la ventana

		// Fondo de presentacion

		fondoPanel = new JLabel();
		fondoPanel.setSize(1440, 800); // Se le da el tamaño de la ventana
		fondoPanel.setIcon(new ImageIcon("Imagenes/Fondo Juego.png")); // Se le indica donde va a estar la imagen de
																		// fondo
		fondoPanel.setLocation(0, 0); // nos permite definir desde donde va a empezar la imagen
		panel.add(fondoPanel, new Integer(1)); // Agregamos el fondo al panelPresentacion

		botonSalir = new JButton();
		botonSalir.setBounds(50, 25, 100, 50);
		
		botonSalir.setOpaque(true);
		botonSalir.setFocusPainted(false);
		botonSalir.setBorderPainted(false);
		botonSalir.setContentAreaFilled(false);
		botonSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon botonSalirImg = new ImageIcon("imagenes/botonSalir.png");
		botonSalir.setIcon(new ImageIcon(botonSalirImg.getImage().getScaledInstance(100,50,Image.SCALE_SMOOTH)));
		botonSalir.addActionListener(this);
		
	
		
		panel.add(botonSalir, new Integer(2));

		// ----------------------------------------Panel
		// General----------------------------------
		// Panel donde va a tener el tiempo y el nombre del jugador

		panelGeneral = new JLayeredPane();
		panelGeneral.setSize(400, 600);
		panelGeneral.setLayout(null);
		panelGeneral.setLocation(50, 95);
		panel.add(panelGeneral, new Integer(2));

		// Porpiedades panelGeneral

		// Fondo panelGeneral

		fondoPanelGeneral = new JLabel();
		fondoPanelGeneral.setSize(500, 600);
		fondoPanelGeneral.setIcon(new ImageIcon("Imagenes/FondoBlanco.jpg"));
		fondoPanelGeneral.setLocation(0, 0);
		panelGeneral.add(fondoPanelGeneral, new Integer(1));

		tipoDificultad = new JLabel();
		tipoDificultad.setBounds(50, 20, 500, 100);
		tipoDificultad.setFont(new Font("AngryBirds", Font.PLAIN, 50));
		panelGeneral.add(tipoDificultad, new Integer(3));

		tipoModo = new JLabel();
		tipoModo.setBounds(200, 20, 500, 100);
		tipoModo.setFont(new Font("AngryBirds", Font.PLAIN, 50));
		panelGeneral.add(tipoModo, new Integer(4));

		nombreJugador = new JLabel();
		nombreJugador.setBounds(50, 100, 500, 100);
		nombreJugador.setFont(new Font("AngryBirds", Font.PLAIN, 40));
		panelGeneral.add(nombreJugador, new Integer(2));

		cronometro = new JLabel();
		cronometro.setBounds(50, 490, 500, 100);
		cronometro.setFont(new Font("AngryBirds", Font.PLAIN, 40));
		panelGeneral.add(cronometro, new Integer(2));

		// ----------------------------------------Panel
		// Juego----------------------------------

		// Panel de juego
		panelJuego = new JLayeredPane();
		panelJuego.setSize(730, 800);
		panelJuego.setLayout(null);
		panelJuego.setLocation(550, 35);

		panel.add(panelJuego, new Integer(2));

		// Propiedades panelJugador

		fondoPanelJuego = new JLabel();
		fondoPanelJuego.setSize(900, 700);
		fondoPanelJuego.setIcon(new ImageIcon("Imagenes/FondoBlanco.jpg"));
		fondoPanelJuego.setLocation(0, 0);
		panelJuego.add(fondoPanelJuego, new Integer(1));

		// visibilidad
		panel.setVisible(true);
		panelGeneral.setVisible(true);

	}

	// Getters and Setters-----
	public JButton[][] getMatrizBotones() {
		return matrizBotones;
	}

	public boolean isSumarContador() {
		return sumarContador;
	}

	public void setSumarContador(boolean sumarContador) {
		this.sumarContador = sumarContador;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getPuntuacionJugador2() {
		return puntuacionJugador2;
	}

	public void setPuntuacionJugador2(int puntuacionJugador2) {
		this.puntuacionJugador2 = puntuacionJugador2;
	}

	public int getTemp() {
		return temp;
	}

	public int getTemp2() {
		return temp2;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getCartaSelec1x() {
		return cartaSelec1x;
	}

	public int getCartaSelec1y() {
		return cartaSelec1y;
	}

	public int getCartaSelec2x() {
		return cartaSelec2x;
	}

	public int getCartaSelec2y() {
		return cartaSelec2y;
	}

	public int getContador() {
		return contador;
	}

	public int getMin() {
		return min;
	}

	public int getSeg() {
		return seg;
	}

	// -----Metodo para regresar un boton al estado normal cuando las cartas son
	// diferentes --------
	public void botonEstadoNormal() {

		ImageIcon interrogante = new ImageIcon("imagenes/interrogante.png");
		matrizBotones[getCartaSelec1x()][getCartaSelec1y()].setIcon(
		new ImageIcon(interrogante.getImage().getScaledInstance(matrizBotones[getPosX()][getPosY()].getWidth(),
		matrizBotones[getPosX()][getPosY()].getHeight(), Image.SCALE_SMOOTH)));
		matrizBotones[getCartaSelec2x()][getCartaSelec2y()].setIcon(
		new ImageIcon(interrogante.getImage().getScaledInstance(matrizBotones[getPosX()][getPosY()].getWidth(),
		matrizBotones[getPosX()][getPosY()].getHeight(), Image.SCALE_SMOOTH)));
		

	}

	// ---Metodo para deshabilitar el boton cuando las cartas son Iguales

	public void deshabilitarBoton() {

		matrizBotones[getCartaSelec1x()][getCartaSelec1y()].setEnabled(false);
		matrizBotones[getCartaSelec1x()][getCartaSelec1y()].setBorder(BorderFactory.createLineBorder(Color.gray));
		matrizBotones[getCartaSelec2x()][getCartaSelec2y()].setEnabled(false);
		matrizBotones[getCartaSelec2x()][getCartaSelec2y()].setBorder(BorderFactory.createLineBorder(Color.gray));
		
	}

	// ----Pone un timer de 2 segundos, funcionaria como la comparacion de las dos
	// imagenes ----
	public void verificarImagenes() {

		setSumarContador(false);

		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {

				validarImagenes();
				setSumarContador(true);
				carta1 = true;
				carta2 = true;

			}
		};
		timer.schedule(tarea, 1000);
	}

	// Este metodo es llamado cuando el contador es = 2
	public void validarImagenes() {

		if (getTemp() == getTemp2()) {
			System.out.println("Cartas iguales");
			// Si las cartas son iguales se deshabilita el boton y suma 10 puntos
			contadorPares = contadorPares + 1;
			puntuacion = puntuacion + 10;
			setPuntuacion(puntuacion);
			deshabilitarBoton();

			actualizarPuntuacion();

		} else {
			System.out.println("Son diferentes");
			// Si las cartas son diferentes los botones vuelven al estado normal
			botonEstadoNormal();

		}
		juegoTerminado();
	}

	public void verificarImagenesModalidadMaquina() {

		setSumarContador(false);

		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {

				validarImagenes();
				bloquearSumarContador();
				turnos.setText("MAQUINA");
				carta1 = true;
				carta2 = true;

			}
		};
		timer.schedule(tarea, 1000);
	}

	// ----Pone un timer de 2 segundos, funcionaria como la comparacion de las dos
	// imagenes ----
	public void verificarImagenesModalidad2() {

		setSumarContador(false);

		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				nombreJugadorTurno();
				validarImagenesModalidad2();
				setSumarContador(true);
				carta1 = true;
				carta2 = true;

			}
		};
		timer.schedule(tarea, 1000);

	}

	// Este metodo es llamado cuando el contador es = 2
	public void validarImagenesModalidad2() {

		if (getTemp() == getTemp2()) {
			System.out.println("Cartas iguales");
			// Si las cartas son iguales se deshabilita el boton y suma 10 puntos
			contadorPares = contadorPares + 1;
			deshabilitarBoton();
			if (contadorTurnoJugadores == 1) { // Actualiza la puntuacion en el jugador uno

				puntuacion = puntuacion + 10;
				setPuntuacion(puntuacion);
				actualizarPuntuacion();

			} // Actualiza la puntuacion en el jugador Dos
			if (contadorTurnoJugadores == 2) {

				puntuacionJugador2 = puntuacionJugador2 + 10;
				setPuntuacionJugador2(puntuacionJugador2);
				actualizarPuntuacionModalidad2();
				contadorTurnoJugadores = 0;
			}

		} else {
			System.out.println("Son diferentes");
			// Si las cartas son diferentes los botones vuelven al estado normal
			botonEstadoNormal();
			// Actualiza la puntuacion en el jugador Dos
			if (contadorTurnoJugadores == 2) {
				contadorTurnoJugadores = 0;
			}
		}
		juegoTerminado();
	}

	public void cronometro() {

		min = 0;
		seg = 0;
		tiempo = new Timer();
		tarea = new TimerTask() {

			public void run() {
				seg++;
				if (seg == 60) {
					min++;
					seg = 0;
				}
				if (seg < 10) {
					cronometro.setText("Tiempo " + min + ":" + "0" + seg);

				} else {
					cronometro.setText("Tiempo " + min + ":" + seg);
				}

			}
		};
		tiempo.schedule(tarea, 1, 1000);
	}

	// Actualiza la puntiación del jugador

	@SuppressWarnings("removal")
	public void actualizarPuntuacion() {

		ponerPuntuacion.setText("Puntuacion: " + getPuntuacion());
		panelGeneral.add(ponerPuntuacion, new Integer(5));

	}

	@SuppressWarnings("removal")
	public void actualizarPuntuacionModalidad2() {

		ponerPuntuacionJugadorDos.setText("Puntuacion: " + getPuntuacionJugador2());
		panelGeneral.add(ponerPuntuacionJugadorDos, new Integer(6));

	}

	// Este panel sale si las cartas seleccionadas son iguales
	public void alertaCartaIgual() {

		JOptionPane.showMessageDialog(null, "Debes seleccionar una carta Diferente");

	}

	public void insertarImagen() {
		// Meotodo ultizado para insertar la imagen en el boton cuando el boton es
		// oprimido

		String imagen = matriz[getPosX()][getPosY()].getNombre();
		ImageIcon imagenAColocar = new ImageIcon(imagen);
		matrizBotones[getPosX()][getPosY()].setOpaque(true);
		matrizBotones[getPosX()][getPosY()].setBackground(Color.white);
		matrizBotones[getPosX()][getPosY()].setIcon(new ImageIcon(imagenAColocar.getImage().getScaledInstance(matrizBotones[getPosX()][getPosY()].getWidth(),matrizBotones[getPosX()][getPosY()].getWidth(), Image.SCALE_SMOOTH)));
		
	}

	// Este metodo arma el tablero de forma aleatoria

	public void armarTablero(Cartas mazo[], int size, int numeroCartas) {
		ramdomGenerate generador = new ramdomGenerate();
		// Cartas cartas = new Cartas();
		matriz = new Cartas[size][size];

		int aleatorio = size - 1;
		int x = 0;
		int y = 0;

		for (int i = 0; i < numeroCartas; i++) {

			for (int n = 0; n < 2; n++) {
				x = generador.generarNumTab(aleatorio);
				;
				y = generador.generarNumTab(aleatorio);
				if (matriz[x][y] == null) {
					matriz[x][y] = mazo[i];
				} else {
					while (matriz[x][y] != null) {
						x = generador.generarNumTab(aleatorio);
						y = generador.generarNumTab(aleatorio);
					}
					matriz[x][y] = mazo[i];
				}
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matriz[i][j].getNombre());
			}
			System.out.println(" ");
		}
	}

	// ---Labels de puntuaciones-----------------------------------------------
	@SuppressWarnings("removal")
	public void labelPuntuacionJugadorUno() {

		ponerPuntuacion = new JLabel();
		ponerPuntuacion.setBounds(50, 180, 500, 100);
		ponerPuntuacion.setFont(new Font("AngryBirds", Font.PLAIN, 35));
		ponerPuntuacion.setText("Puntuacion: " + getPuntuacion());
		panelGeneral.add(ponerPuntuacion, new Integer(7));

	}

	@SuppressWarnings("removal")
	public void labelPuntuacionJugadorDos() {

		ponerPuntuacionJugadorDos = new JLabel();
		ponerPuntuacionJugadorDos.setBounds(50, 330, 500, 100);
		ponerPuntuacionJugadorDos.setFont(new Font("AngryBirds", Font.PLAIN, 35));
		ponerPuntuacionJugadorDos.setText("Puntuacion: " + getPuntuacionJugador2());
		panelGeneral.add(ponerPuntuacionJugadorDos, new Integer(8));

	}

	// Labels Nombre de Jugadores---------------------------------------------

	@SuppressWarnings({ "removal", "null" })
	public void labelNombreJugadorDos() {

		labelNombreJugadorDos = new JLabel();
		labelNombreJugadorDos.setBounds(50, 250, 500, 100);
		labelNombreJugadorDos.setFont(new Font("AngryBirds", Font.PLAIN, 35));
		panelGeneral.add(labelNombreJugadorDos, new Integer(9));

	}

	@SuppressWarnings("removal")
	public void turnoJugador() {

		turnos = new JLabel();
		turnos.setBounds(50, 410, 500, 100);
		turnos.setFont(new Font("AngryBirds", Font.PLAIN, 35));
		turnos.setText("Jugador 1");
		panelGeneral.add(turnos, new Integer(10));

	}

	public void nombreJugadorTurno() {
		if (contadorTurnoJugadores == 1) {

			turnos.setText("Jugador 2");
		}
		if (contadorTurnoJugadores == 2) {
			turnos.setText("Jugador 1");
		}
	}

	/**
	 * 
	 * @param size         - tamaño del tablero va de la mano con cartasAJugar, sus
	 *                     valores solo pueden ser 4,6,8
	 * @param CartasAjugar - Sus valores solo pueden ser 8, 18, 32
	 * @param modalidad    - individual = 1, 1vs1 = 2, 1vs maquina = 3
	 */

	public void ventanaPartida(int size, int CartasAjugar, int modalidad) {
		Cartas cartas = new Cartas();
		cartas.generarCartas(); // Genero las cartas de la clase cartas
		this.CartasAjugar = CartasAjugar;
		armarTablero(cartas.getArrCartas(), size, CartasAjugar); // Al llamar este metodo las cartas se pondran en
																	// ligares aleatorios

		// un aleatoriaeda
		// Hacer metodo
		// ----------------------------------------------------------

		frame = new JFrame();
		frame.setTitle("Juego de memoria");
		frame.setSize(1440, 800); // Aqui va el tamaño de la ventana
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar nuestro programa al cerrarlo no se ejecute en
																// segundo plano
		frame.setResizable(false); // Desabilita el boton de maximizar la ventana
		frame.setLayout(null); // Esto nos permite colocar los demas componentes donde queramos
		frame.setBackground(Color.white);

		componentes();

		crearBotones(size);

		switch (modalidad) {
			case 1:
				// Metodos modalidad Individual
				modalidadIndividual(size);
				labelPuntuacionJugadorUno();
				cronometro();
				labelNombreJugadorDos();
				break;
			case 2:

				// Metodos modalidad 1vs1
				turnoJugador();
				modalidadJugadorVsJugador(size);
				labelPuntuacionJugadorUno();
				labelNombreJugadorDos();
				labelPuntuacionJugadorDos();
				cronometro();
				break;
			case 3:

				ModalidadJugadorMaquina(size);

				labelPuntuacionJugadorUno();
				labelNombreJugadorDos();
				labelNombreJugadorDos.setText("MAQUINA");
				labelPuntuacionJugadorDos();
				turnoJugador();
				cronometro();

				// Metodos modalidad 1vs maquina

			default:

		}

		frame.setVisible(true);
	}
	// ----------------------------------------------------------

	// Este metodo crea todos los botones
	@SuppressWarnings("removal")
	public void crearBotones(int size) {
		ImageIcon interrogante = new ImageIcon("imagenes/interrogante.png");
		matrizBotones = new JButton[size][size];

		if (size == 8) {
			int positionBotonx = 0;
			for (int i = 0; i < size; i++) {
				int positionBotony = 0;
				for (int j = 0; j < size; j++) {

					matrizBotones[i][j] = new JButton();
					matrizBotones[i][j].setBounds(50 + positionBotony, 50 + positionBotonx, 70, 70);
					matrizBotones[i][j].setIcon(new ImageIcon(interrogante.getImage().getScaledInstance(matrizBotones[i][j].getWidth(), matrizBotones[i][j].getHeight(), Image.SCALE_SMOOTH)));
					matrizBotones[i][j].setBorder(null);
					matrizBotones[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
					panelJuego.add(matrizBotones[i][j], new Integer(10));

					positionBotony = positionBotony + 80;
				}
				positionBotonx = positionBotonx + 80;
			}
		}else if(size == 6){
			int positionBotonx = 0;
			for (int i = 0; i < size; i++) {
				int positionBotony = 0;
				for (int j = 0; j < size; j++) {

					matrizBotones[i][j] = new JButton();
					matrizBotones[i][j].setBounds(50 + positionBotony, 50 + positionBotonx, 96, 96);
					matrizBotones[i][j].setIcon(new ImageIcon(interrogante.getImage().getScaledInstance(
					matrizBotones[i][j].getWidth(), matrizBotones[i][j].getHeight(), Image.SCALE_SMOOTH)));
					matrizBotones[i][j].setBorder(null);
					matrizBotones[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
					panelJuego.add(matrizBotones[i][j], new Integer(10));

					positionBotony = positionBotony + 107;
				}
				positionBotonx = positionBotonx + 107;
			}
		}else if (size == 4){
			int positionBotonx = 0;
			for (int i = 0; i < size; i++) {
				int positionBotony = 0;
				for (int j = 0; j < size; j++) {

					matrizBotones[i][j] = new JButton();
					matrizBotones[i][j].setBounds(50 + positionBotony, 50 + positionBotonx, 147, 147);
					matrizBotones[i][j].setIcon(new ImageIcon(interrogante.getImage().getScaledInstance(matrizBotones[i][j].getWidth(), matrizBotones[i][j].getHeight(), Image.SCALE_SMOOTH)));
					matrizBotones[i][j].setBorder(null);
					matrizBotones[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
					panelJuego.add(matrizBotones[i][j], new Integer(10));

					positionBotony = positionBotony + 157;
				}
				positionBotonx = positionBotonx + 157;
		}
	}else{
		int positionBotonx = 0;
			for (int i = 0; i < size; i++) {
				int positionBotony = 0;
				for (int j = 0; j < size; j++) {

					matrizBotones[i][j] = new JButton();
					matrizBotones[i][j].setBounds(50 + positionBotony, 50 + positionBotonx, 70, 70);
					matrizBotones[i][j].setIcon(new ImageIcon(interrogante.getImage().getScaledInstance(
					matrizBotones[i][j].getWidth(), matrizBotones[i][j].getHeight(), Image.SCALE_SMOOTH)));

					panelJuego.add(matrizBotones[i][j], new Integer(10));

					positionBotony = positionBotony + 80;
				}
				positionBotonx = positionBotonx + 80;
			}
	}




	}
	// Modalidad de jugador
	// Individual----------------------------------------------------------------------------

	public void modalidadIndividual(int size) {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				matrizBotones[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						for (int k = 0; k < size; k++) {
							for (int l = 0; l < size; l++) {

								// String imagen = ((Cartas) matriz[k][l]).getNombre();

								if (e.getSource() == matrizBotones[k][l]) {

									if (isSumarContador() == true && matrizBotones[k][l].isEnabled() != false) {

										posX = k;
										posY = l;
										if (carta1 == true || carta2 == true) {
											contador++;
											System.out.println("Se sumó al contador");
										}
									} else {
										System.out.println("No se sumó");
									}

									if (contador == 1) {

										if (carta1 == true) {
											insertarImagen();
											temp = matriz[k][l].getId();
											cartaSelec1x = k;
											cartaSelec1y = l;
											carta1 = false;
										}
									}
									if (contador == 2) {

										if (carta2 == true) {
											insertarImagen();
											temp2 = matriz[k][l].getId();
											cartaSelec2x = k;
											cartaSelec2y = l;
											carta2 = false;
										}

									}

									if (contador == 2) {

										contador = 0;

										if (cartaSelec1x != cartaSelec2x || cartaSelec1y != cartaSelec2y) {
											verificarImagenes();
										} else {
											System.out.println("El boton es igual");
											alertaCartaIgual();
											contador = 1;
											temp2 = -1;
											cartaSelec2x = -1;
											cartaSelec2y = -1;
											carta2 = true;

										}
									}
								}
							}
						}
					}
				});
			}
		}
	}

	// Modalidad de Jugador vs
	// Jugador----------------------------------------------------------------------------

	public void modalidadJugadorVsJugador(int size) {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				matrizBotones[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						for (int k = 0; k < size; k++) {
							for (int l = 0; l < size; l++) {

								// String imagen = ((Cartas) matriz[k][l]).getNombre();

								if (e.getSource() == matrizBotones[k][l]) {

									if (isSumarContador() == true && matrizBotones[k][l].isEnabled() != false) {

										posX = k;
										posY = l;
										if (carta1 == true || carta2 == true) {
											contador++;
											System.out.println("Se sumó al contador");
										}
									} else {
										System.out.println("No se sumó");
									}

									if (contador == 1) {

										if (carta1 == true) {
											insertarImagen();
											temp = matriz[k][l].getId();
											cartaSelec1x = k;
											cartaSelec1y = l;
											carta1 = false;
										}
									}
									if (contador == 2) {

										if (carta2 == true) {
											insertarImagen();
											temp2 = matriz[k][l].getId();
											cartaSelec2x = k;
											cartaSelec2y = l;
											carta2 = false;
										}

									}

									if (contador == 2) {

										contador = 0;

										if (cartaSelec1x != cartaSelec2x || cartaSelec1y != cartaSelec2y) {

											// Este metodo debe ser cambiado
											contadorTurnoJugadores++;

											verificarImagenesModalidad2();

										} else {
											System.out.println("El boton es igual");
											alertaCartaIgual();
											contador = 1;
											temp2 = -1;
											cartaSelec2x = -1;
											cartaSelec2y = -1;
											carta2 = true;

										}
									}
								}
							}
						}
					}
				});
			}
		}
	}

	// Modalidad de Bot

	public void ModalidadJugadorMaquina(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				matrizBotones[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						for (int k = 0; k < size; k++) {
							for (int l = 0; l < size; l++) {

								// String imagen = ((Cartas) matriz[k][l]).getNombre();

								if (e.getSource() == matrizBotones[k][l]) {

									if (isSumarContador() == true && matrizBotones[k][l].isEnabled() != false) {

										posX = k;
										posY = l;
										if (carta1 == true || carta2 == true) {
											contador++;
											System.out.println("Se sumó al contador");
										}
									} else {
										System.out.println("No se sumó");
									}

									if (contador == 1) {

										if (carta1 == true) {
											insertarImagen();
											temp = matriz[k][l].getId();
											cartaSelec1x = k;
											cartaSelec1y = l;
											carta1 = false;
										}
									}
									if (contador == 2) {

										if (carta2 == true) {
											insertarImagen();
											temp2 = matriz[k][l].getId();
											cartaSelec2x = k;
											cartaSelec2y = l;
											carta2 = false;
										}

									}

									if (contador == 2) {

										contador = 0;

										if (cartaSelec1x != cartaSelec2x || cartaSelec1y != cartaSelec2y) {

											verificarImagenesModalidadMaquina();

											bloquearSumarContador();
											if (contadorPares < CartasAjugar - 1) {
												System.out.println("pares: " + contadorPares);
												maquinaVolteaImagnesTimer(size);
											} else {
												System.out.println("juego terminado");
											}

										} else {
											System.out.println("El boton es igual");
											alertaCartaIgual();
											contador = 1;
											temp2 = -1;
											cartaSelec2x = -1;
											cartaSelec2y = -1;
											carta2 = true;

										}
									}
								}
							}
						}
					}
				});
			}
		}
	}

	ramdomGenerate numeroRandom = new ramdomGenerate();

	int cartaSelec1xMaquina;
	int cartaSelec1yMaquina;
	int cartaSelec2xMaquina;
	int cartaSelec2yMaquina;

	public int getCartaSelec1xMaquina() {
		return cartaSelec1xMaquina;
	}

	public int getCartaSelec1yMaquina() {
		return cartaSelec1yMaquina;
	}

	public int getCartaSelec2xMaquina() {
		return cartaSelec2xMaquina;
	}

	public int getCartaSelec2yMaquina() {
		return cartaSelec2yMaquina;
	}

	public void turnoMaquina(int size) {

		// Inserta la primera imagen verificancando si el boton esta habilitado

		cartaSelec1xMaquina = numeroRandom.eleccionMaquina(size - 1);
		cartaSelec1yMaquina = numeroRandom.eleccionMaquina(size - 1);

		if (matrizBotones[cartaSelec1xMaquina][cartaSelec1yMaquina].isEnabled() == true) {

			posX = cartaSelec1xMaquina;
			posY = cartaSelec1yMaquina;
			insertarImagen();
			// System.out.println("registra cartass Si");

		} else {
			while (matrizBotones[cartaSelec1xMaquina][cartaSelec1yMaquina].isEnabled() == false) {

				cartaSelec1xMaquina = numeroRandom.eleccionMaquina(size - 1);
				cartaSelec1yMaquina = numeroRandom.eleccionMaquina(size - 1);
				posX = cartaSelec1xMaquina;
				posY = cartaSelec1yMaquina;
				System.out.println("registra cartass else");
			}
			insertarImagen();
		}

		temp = matriz[cartaSelec1xMaquina][cartaSelec1yMaquina].getId();
		System.out.println(cartaSelec1xMaquina + " " + cartaSelec1yMaquina);

		// Inserta la segunda imagen verificancando si el boton esta habilitado y que no
		// permita darle clic a la misma carta

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		cartaSelec2xMaquina = numeroRandom.eleccionMaquina(size - 1);
		cartaSelec2yMaquina = numeroRandom.eleccionMaquina(size - 1);

		if ((cartaSelec2xMaquina != cartaSelec1xMaquina || cartaSelec2yMaquina != cartaSelec1yMaquina)
				&& matrizBotones[cartaSelec2xMaquina][cartaSelec2yMaquina].isEnabled() == true) {
			System.out.println("La imagen Cumple las condiciones");

			posX = cartaSelec2xMaquina;
			posY = cartaSelec2yMaquina;
			insertarImagen();
			temp2 = matriz[cartaSelec2xMaquina][cartaSelec2yMaquina].getId();
			System.out.println(cartaSelec2xMaquina + " " + cartaSelec2yMaquina);

		} else {
			System.out.println("La imagen NO cumple las condiciones");

			while ((cartaSelec2xMaquina == cartaSelec1xMaquina && cartaSelec2yMaquina == cartaSelec1yMaquina)
					|| matrizBotones[cartaSelec2xMaquina][cartaSelec2yMaquina].isEnabled() == false) {

				cartaSelec2xMaquina = numeroRandom.eleccionMaquina(size - 1);
				cartaSelec2yMaquina = numeroRandom.eleccionMaquina(size - 1);

			}
			posX = cartaSelec2xMaquina;
			posY = cartaSelec2yMaquina;
			insertarImagen();
			temp2 = matriz[cartaSelec2xMaquina][cartaSelec2yMaquina].getId();
		}
		verificarImagenesMaquina();
	}

	public void maquinaVolteaImagnesTimer(int size) {

		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				// Tareas

				turnoMaquina(size);

			}
		};
		timer.schedule(tarea, 2000);
	}

	public void deshabilitarBotonMaquina() {

		matrizBotones[getCartaSelec1xMaquina()][getCartaSelec1yMaquina()].setEnabled(false);
		matrizBotones[getCartaSelec1xMaquina()][getCartaSelec1yMaquina()].setBorder(BorderFactory.createLineBorder(Color.gray));
		matrizBotones[getCartaSelec2xMaquina()][getCartaSelec2yMaquina()].setEnabled(false);
		matrizBotones[getCartaSelec2xMaquina()][getCartaSelec2yMaquina()].setBorder(BorderFactory.createLineBorder(Color.gray));
		

	}

	// ----Pone un timer de 2 segundos, funcionaria como la comparacion de las dos
	// imagenes ----
	public void verificarImagenesMaquina() {

		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {

				validarImagenesMaquina();
				carta1 = true;
				carta2 = true;

			}
		};
		timer.schedule(tarea, 1000);
	}

	// Este metodo es llamado cuando el contador es = 2
	public void validarImagenesMaquina() {

		if (getTemp() == getTemp2()) {
			System.out.println("Cartas iguales");
			// Si las cartas son iguales se deshabilita el boton y suma 10 puntos
			contadorPares = contadorPares + 1;

			puntuacionJugador2 = puntuacionJugador2 + 10;

			actualizarPuntuacionModalidad2();
			deshabilitarBotonMaquina();

		} else {
			System.out.println("Son diferentes");
			// Si las cartas son diferentes los botones vuelven al estado normal
			botonEstadoNormalMaquina();

		}
		turnos.setText("JUGADOR UNO");
		juegoTerminado();
	}

	public void botonEstadoNormalMaquina() {

		ImageIcon interrogante = new ImageIcon("imagenes/interrogante.png");
		matrizBotones[getCartaSelec1xMaquina()][getCartaSelec1yMaquina()].setIcon(new ImageIcon(interrogante.getImage().getScaledInstance(matrizBotones[getPosX()][getPosY()].getWidth(),matrizBotones[getPosX()][getPosY()].getWidth(), Image.SCALE_SMOOTH)));
		matrizBotones[getCartaSelec2xMaquina()][getCartaSelec2yMaquina()].setIcon(new ImageIcon(interrogante.getImage().getScaledInstance(matrizBotones[getPosX()][getPosY()].getWidth(),matrizBotones[getPosX()][getPosY()].getWidth(), Image.SCALE_SMOOTH)));

	}

	public void bloquearSumarContador() {
		setSumarContador(false);
		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {

				// Poner aca sino sieve
				setSumarContador(true);

			}
		};
		timer.schedule(tarea, 3700);
	}

	public JLabel nombreGanador() {

		if (puntuacion > puntuacionJugador2) {
			return nombreJugador;
		} else {
			return labelNombreJugadorDos;
		}

	}

	public int puntuacionGanador() {

		if (nombreGanador().getText() == nombreJugador.getText()) {
			return puntuacion;
		} else {
			return puntuacionJugador2;
		}
	}

	creacionxml xml = new creacionxml();

	public String obtenerNombreJugador1 = "";
	public String obtenerNombreJugador2 = "";
	public int puntuacionJugador1xml = 0;
	public int puntuacionJugador2xml = 0;

	public String modoJugado;
	public String dificultadJugada;

	public void juegoTerminado() {
		if (contadorPares == CartasAjugar) {
			
			modoJugado = tipoModo.getText();
			dificultadJugada = tipoDificultad.getText();

			
			if (puntuacion > puntuacionJugador2){
				obtenerNombreJugador1 = nombreJugador.getText();
				puntuacionJugador1xml = getPuntuacion();

				obtenerNombreJugador2 = labelNombreJugadorDos.getText();
				puntuacionJugador2xml = getPuntuacionJugador2();
			} else if(puntuacionJugador2 > puntuacion){

				obtenerNombreJugador1 = labelNombreJugadorDos.getText();
				puntuacionJugador1xml = getPuntuacionJugador2();

				obtenerNombreJugador2 = nombreJugador.getText();
				puntuacionJugador2xml = getPuntuacion();

			}else{

				obtenerNombreJugador1 = nombreJugador.getText();
				puntuacionJugador1xml = getPuntuacion();

				obtenerNombreJugador2 = labelNombreJugadorDos.getText();
				puntuacionJugador2xml = getPuntuacionJugador2();
			}


			System.out.println("El juego terminó");
			tarea.cancel();
			tiempo.cancel();
			xml.crearArchivo(puntuacionJugador1xml, obtenerNombreJugador1, min, seg, modoJugado, obtenerNombreJugador2, puntuacionJugador2xml,dificultadJugada);

			xml.registrosXML();
			if (puntuacion != puntuacionJugador2) {
				if (getSeg() < 10) {
					String mensaje = "El ganador fue: " + nombreGanador().getText() + " Su puntuacion fue: "
							+ puntuacionGanador() + " Con un tiempo total de " + getMin() + ":" + "0" + getSeg();
					JOptionPane.showMessageDialog(null, mensaje, "Ganador!!", JOptionPane.INFORMATION_MESSAGE);

				} else {
					String mensaje = "El ganador fue: " + nombreGanador().getText() + " Su puntuacion fue: "
							+ puntuacionGanador() + " Con un tiempo total de " + getMin() + ":" + getSeg();
					JOptionPane.showMessageDialog(null, mensaje, "Ganador!!", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				if (getSeg() < 10) {
					String mensaje = "Empate " + " con un tiempo total de " + getMin() + ":" + "0" + getSeg();
					JOptionPane.showMessageDialog(null, mensaje, "Empate!!", JOptionPane.INFORMATION_MESSAGE);
				} else {

					String mensaje = "Empate " + " con un tiempo total de " + getMin() + ":" + getSeg();
					JOptionPane.showMessageDialog(null, mensaje, "Empate!!", JOptionPane.INFORMATION_MESSAGE);
				}
			}

			MenuDeInicio ventana = new MenuDeInicio();
			ventana.setVisible(true);
			frame.setVisible(false);

			System.out.println(String.valueOf(getPuntuacion()));

		}
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == botonSalir) {
			tarea.cancel();
			tiempo.cancel();

			MenuDeInicio ventana = new MenuDeInicio();
			ventana.setVisible(true);
			frame.setVisible(false);
		}
	}

	public Tableros() {
	}
}
