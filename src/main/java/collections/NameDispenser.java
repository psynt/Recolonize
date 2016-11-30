package collections;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NameDispenser {
	private static ArrayList<String> names = null;
	private static int index = 0;
	
	public static void init() throws ParserConfigurationException, SAXException, IOException {
		names = new ArrayList<String>();
		File file = new File("Res/Names.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);
		NodeList nl = document.getElementsByTagName("name");
		for(int i = 0 ; i<nl.getLength() ; i++){
			names.add(nl.item(i).getTextContent());
		}
		//System.out.println(names);
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
