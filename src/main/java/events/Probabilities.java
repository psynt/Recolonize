package events;

/**
 * Set of values that event probabilities can have
 * @author nichita
 *
 */
public enum Probabilities {
	veryLow,Low,Medium,High,Certain;
	/**
	 * transforms the probabilities into integers
	 * @return int representation of the probability
	 */
	public int getProbability(){
		int i;
		switch (this){
		case Certain: i = 100;
			break;
		case High: i = 30;
			break;
		case Low: i = 10;
			break;
		case Medium: i = 20;
			break;
		case veryLow: i = 5;
			break;
		default: throw new RuntimeException("Undefined Probability");
		}
		return i;
	}
	
}
