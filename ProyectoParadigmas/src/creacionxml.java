import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
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
    

	public void crearArchivo(int puntos,String nombreJugador, int minutos, int segundos,String modoSelecciondo){
		
		String seg;
		//String puntosJugador = String.valueOf(obternerDatos.getPuntuacion());
		if (segundos <10 ){
			seg = "0"+String.valueOf(segundos);
		}
		else{
			seg = String.valueOf(segundos);
		}


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
			
			Element tiempo = documento.createElement("tiempo");
			Text textTiempo= documento.createTextNode(String.valueOf(minutos)+":"+seg);
			tiempo.appendChild(textTiempo);
			puntaje.appendChild(tiempo);

            Element puntuacion = documento.createElement("puntuacion");
			Text textPuntuacon= documento.createTextNode(String.valueOf(puntos));
			puntuacion.appendChild(textPuntuacon);
			puntaje.appendChild(puntuacion);	
            
            puntajes.appendChild(puntaje);
			documento.getDocumentElement().appendChild(puntajes);
			
			Source source = new DOMSource(documento);
			Result result = new StreamResult(new File("puntajes.xml"));
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			
		











            
		} catch (ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException e) {
			System.out.println();
		}


    }
}
