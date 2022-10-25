import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class creacionxml {
	
	private String tempNombre;
	private String tempPuntuacion;
	private String tempTiempoAPoner;
	private String tempModo;
	private String tempDificultad;
	private int contador = 1; 




	public String[][] datosXML = new String[3][5];

	public String[][] getDatosXML() {
		return datosXML;
	}
	
	/**
	 * 
	 * @param puntos
	 * @param nombreJugador
	 * @param minutos
	 * @param segundos
	 * @param modoSelecciondo
	 * @param nombreJugador2
	 * @param puntuacionJugador2
	 * @param dificultadString
	 */

	public void crearArchivo(int puntos,String nombreJugador, int minutos, int segundos,String modoSelecciondo, String nombreJugador2,int puntuacionJugador2, String dificultadString){
		
		String tiempoAponer;
		//String puntosJugador = String.valueOf(obternerDatos.getPuntuacion());
		if (segundos <10 ){
			tiempoAponer = String.valueOf(minutos)+":"+"0"+String.valueOf(segundos);
		}
		else{
			tiempoAponer = String.valueOf(minutos)+":"+String.valueOf(segundos);
		}
		if(contador == 0){
			tempNombre= "";
			tempPuntuacion= "";
			tempTiempoAPoner= "";
			tempModo= "";
			tempDificultad = "";
		}else if(contador == 1) {
			tempNombre= nombreJugador;
			tempPuntuacion= String.valueOf(puntos);
			tempTiempoAPoner= tiempoAponer;
			tempModo= modoSelecciondo;
			tempDificultad = dificultadString;

		}
		contador++;
		System.out.println(contador);





        try {
            
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document documento = implementation.createDocument(null, "puntajes", null);
			documento.setXmlVersion("1.0");
			
			Element puntajes = documento.createElement("puntajes");
			Element puntaje = documento.createElement("puntaje");
			
			Element nombre = documento.createElement("nombre");
			Text textNombre = documento.createTextNode(nombreJugador);
            nombre.appendChild(textNombre);
			puntaje.appendChild(nombre);
			
			Element modo = documento.createElement("modo");
			Text textModo = documento.createTextNode(modoSelecciondo);
			modo.appendChild(textModo);
			puntaje.appendChild(modo);
			
			Element dificultad = documento.createElement("dificultad");
			Text textDificultad = documento.createTextNode(dificultadString);
			dificultad.appendChild(textDificultad);
			puntaje.appendChild(dificultad);

			Element tiempo = documento.createElement("tiempo");
			Text textTiempo= documento.createTextNode(tiempoAponer);
			tiempo.appendChild(textTiempo);
			puntaje.appendChild(tiempo);

            Element puntuacion = documento.createElement("puntuacion");
			Text textPuntuacon= documento.createTextNode(String.valueOf(puntos));
			puntuacion.appendChild(textPuntuacon);
			puntaje.appendChild(puntuacion);	
            
            puntajes.appendChild(puntaje);
		
			// puntjaesss dossssssssssssssssss

			Element puntaje2 = documento.createElement("puntaje");
			
			Element nombre2 = documento.createElement("nombre");
			Text textNombre2 = documento.createTextNode(nombreJugador2);
            nombre2.appendChild(textNombre2);
			puntaje2.appendChild(nombre2);
			
			Element modo2 = documento.createElement("modo");
			Text textModo2 = documento.createTextNode(modoSelecciondo);
			modo2.appendChild(textModo2);
			puntaje2.appendChild(modo2);

			Element dificultad2 = documento.createElement("dificultad");
			Text textDificultad2 = documento.createTextNode(dificultadString);
			dificultad2.appendChild(textDificultad2);
			puntaje2.appendChild(dificultad2);
			
			Element tiempo2 = documento.createElement("tiempo");
			Text textTiempo2= documento.createTextNode(tiempoAponer);
			tiempo2.appendChild(textTiempo2);
			puntaje2.appendChild(tiempo2);

            Element puntuacion2 = documento.createElement("puntuacion");
			Text textPuntuacon2= documento.createTextNode(String.valueOf(puntuacionJugador2));
			puntuacion2.appendChild(textPuntuacon2);
			puntaje2.appendChild(puntuacion2);	
			
			puntajes.appendChild(puntaje2);

			// Puntaje tressssssssss

			Element puntaje3 = documento.createElement("puntaje");
			
			Element nombre3 = documento.createElement("nombre");
			Text textNombre3 = documento.createTextNode(tempNombre);
            nombre3.appendChild(textNombre3);
			puntaje3.appendChild(nombre3);
			
			Element modo3 = documento.createElement("modo");
			Text textModo3 = documento.createTextNode(tempModo);
			modo3.appendChild(textModo3);
			puntaje3.appendChild(modo3);

			Element dificultad3 = documento.createElement("dificultad");
			Text textDificultad3 = documento.createTextNode(tempDificultad);
			dificultad3.appendChild(textDificultad3);
			puntaje3.appendChild(dificultad3);
			
			Element tiempo3 = documento.createElement("tiempo");
			Text textTiempo3= documento.createTextNode(tempTiempoAPoner);
			tiempo3.appendChild(textTiempo3);
			puntaje3.appendChild(tiempo3);

            Element puntuacion3 = documento.createElement("puntuacion");
			Text textPuntuacon3= documento.createTextNode(tempPuntuacion);
			puntuacion3.appendChild(textPuntuacon3);
			puntaje3.appendChild(puntuacion3);	
			
			puntajes.appendChild(puntaje3);

			documento.getDocumentElement().appendChild(puntajes);
			
			Source source = new DOMSource(documento);
			Result result = new StreamResult(new File("puntajes.xml"));
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			
            
		} catch (ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException e) {
			System.out.println();
		}
    }

	/**
	 * 
	 */
	public void registrosXML(){

		try {
			// Creo una instancia de DocumentBuilderFactory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// Creo un documentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Obtengo el documento, a partir del XML
			Document documento = builder.parse(new File("puntajes.xml"));

			// Cojo todas las etiquetas coche del documento
			NodeList listaPuntaje = documento.getElementsByTagName("puntaje");

			// Recorro las etiquetas
			for (int i = 0; i < listaPuntaje.getLength(); i++) {
				// Cojo el nodo actual
				Node nodo = listaPuntaje.item(i);
				// Compruebo si el nodo es un elemento
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					// Lo transformo a Element
					Element e = (Element) nodo;
					// Obtengo sus hijos
					NodeList hijos = e.getChildNodes();
					// Recorro sus hijos
					for (int j = 0; j < hijos.getLength(); j++) {
						// Obtengo al hijo actual
						Node hijo = hijos.item(j);
						// Compruebo si es un nodo
						if (hijo.getNodeType() == Node.ELEMENT_NODE) {
							// Muestro el contenido
							System.out.println("Propiedad: " + hijo.getNodeName() + ", Valor: " + hijo.getTextContent());
							
							System.out.println(i + " " + j);
							datosXML[i][j] = hijo.getTextContent();
						}

					}
					System.out.println("");
				}

			}

		} catch (ParserConfigurationException | SAXException | IOException ex) {
			System.out.println("h");
		}
	}
}