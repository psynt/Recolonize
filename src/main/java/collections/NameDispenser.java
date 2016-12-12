package collections;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class NameDispenser {
	private static ArrayList<String> names = null;
	private static int index = 0;
	
	public static void init() throws ParserConfigurationException, SAXException, IOException {
		names = new ArrayList<String>();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(NameDispenser.class.getResourceAsStream("/Names.xml"));
		NodeList nl = document.getElementsByTagName("name");
		for(int i = 0 ; i<nl.getLength() ; i++){
			names.add(nl.item(i).getTextContent());
		}
	}
	public static String next() {
		
		if(names == null){
			try {
				init();
			} catch (ParserConfigurationException | SAXException | IOException e1) {
				e1.printStackTrace();
			}
		}
		
		String s = names.get(index);
		index++;
		if(index>=names.size()) index -= names.size();
		return s;
		
	}

}
