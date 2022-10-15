import java.util.Random;

public class ramdomGenerate {
	public ramdomGenerate() {
		// TODO Auto-generated constructor stub
	}
	//----------Genera un numero ramdom desde el 0 hasta el numro solicitado por el parametro
	
	Random numAleatorio = new Random();
	
	//----------Genera un numero ramdom desde el 0 hasta el numro solicitado por el parametro
	public int generarNumTab(int rango) {
		int numero = numAleatorio.nextInt(rango-0+1);
		return numero;
	}

	public int eleccionMaquina(int rango) {
		int numero = numAleatorio.nextInt(rango-0+1);
		return numero;
	}


}