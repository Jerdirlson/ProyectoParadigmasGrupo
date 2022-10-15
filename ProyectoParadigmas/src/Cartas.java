public class Cartas {
	
	int id;
	String nombre = "";
	//private int nContador = 0;
	private Cartas[] arrCartas = new Cartas[32];
	
	
	public Cartas[] getArrCartas() {
		return arrCartas;
	}

	public void setArrCartas(Cartas[] arrCartas) {
		this.arrCartas = arrCartas;
	}

	public Cartas(String nombre, int id) {
		this.id = id;
		this.nombre = nombre;
		
	}
	
	
	
	public void generarCartas() {
		
		arrCartas[0] = new Cartas("imagenes/img1.png", 1);
		arrCartas[1] = new Cartas("imagenes/img2.png", 2);
		arrCartas[2] = new Cartas("imagenes/img3.png", 3);
		arrCartas[3] = new Cartas("imagenes/img4.png", 4);
		arrCartas[4] = new Cartas("imagenes/img5.png", 5);
		arrCartas[5] = new Cartas("imagenes/img6.png", 6);
		arrCartas[6] = new Cartas("imagenes/img7.png", 7);
		arrCartas[7] = new Cartas("imagenes/img8.png", 8);
		arrCartas[8] = new Cartas("imagenes/img9.png", 9);
		arrCartas[9] = new Cartas("imagenes/img10.png", 10);
		arrCartas[10] = new Cartas("imagenes/img11.png", 11);
		arrCartas[11] = new Cartas("imagenes/img12.png", 12);
		arrCartas[12] = new Cartas("imagenes/img13.png", 13);
		arrCartas[13] = new Cartas("imagenes/img14.png", 14);
		arrCartas[14] = new Cartas("imagenes/img15.png", 15);
		arrCartas[15] = new Cartas("imagenes/img16.png", 16);
		arrCartas[16] = new Cartas("imagenes/img17.png", 17);
		arrCartas[17] = new Cartas("imagenes/img18.png", 18);
		arrCartas[18] = new Cartas("imagenes/img19.png", 19);
		arrCartas[19] = new Cartas("imagenes/img20.png", 20);
		arrCartas[20] = new Cartas("imagenes/img21.png", 21);
		arrCartas[21] = new Cartas("imagenes/img22.png", 22);
		arrCartas[22] = new Cartas("imagenes/img23.png", 23);
		arrCartas[23] = new Cartas("imagenes/img24.png", 24);
		arrCartas[24] = new Cartas("imagenes/img25.png", 25);
		arrCartas[25] = new Cartas("imagenes/img26.png", 26);
		arrCartas[26] = new Cartas("imagenes/img27.png", 27);
		arrCartas[27] = new Cartas("imagenes/img28.png", 28);
		arrCartas[28] = new Cartas("imagenes/img29.png", 29);
		arrCartas[29] = new Cartas("imagenes/img30.png", 30);
		arrCartas[30] = new Cartas("imagenes/img31.png", 31);
		arrCartas[31] = new Cartas("imagenes/img32.png", 32);
	
	}
	
	public Cartas() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
