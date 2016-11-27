package entities;
/**
 * Possible jobs that each entity will do in the current day
 * @author nichita
 *
 */
public enum Assignment {
	None, Search, Cook;

	public static Assignment toAssignment(String text) {
		Assignment a;
		switch (text){
		case "Cook": a = Cook;
			break;
		case "Search": a = Search;
			break;
		case "None": a = None;
			break;
		default: a = None;
			System.err.println("Bad assignment");
			break;
		}
		return a;
	}

}
