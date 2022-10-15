import java.util.Random;

public class ramdomGenerate {
	public ramdomGenerate() {
		// TODO Auto-generated constructor stub
	}
	
	//----------Genera un numero ramdom desde el 0 hasta el numro solicitado por el parametro
	
	public int generarNumTab(int rango) {
		Random numAleatorio = new Random();
		int n = numAleatorio.nextInt(rango-0+1);
		return n;
	}
}