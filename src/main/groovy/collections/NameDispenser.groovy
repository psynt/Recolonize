package collections

import groovy.json.JsonSlurper
import org.xml.sax.SAXException

import javax.xml.parsers.ParserConfigurationException

class NameDispenser {
	private static names = null;
	private static index = 0;

    /**
     * reads names from Names.json
     *
     */
	static init(){
        names = new ArrayList<String>()
		def jsonRead = new JsonSlurper().parse(NameDispenser.class.getResourceAsStream("/Names.json"))
        jsonRead.each {names.add(it);}
	}

    /**
     * Should cycle when names are exhausted
     * @return a name
     */
	static String next() {
		
		if(!names){
			try {
				init();
			} catch (ParserConfigurationException | SAXException | IOException e1) {
				e1.printStackTrace();
			}
		}
		
		String s = names[index];
		index++;
		if(index>=names.size()) index -= names.size();
		return s;
		
	}

}
