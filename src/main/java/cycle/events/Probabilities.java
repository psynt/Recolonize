package cycle.events;

/**
 * Set of values that event probabilities can have
 * @author nichita
 *
 */
public enum Probabilities {
	almostNever,veryLow,Low,Medium,High,Certain;
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
		case almostNever: i = 1;
			break;
		default: throw new RuntimeException("Undefined Probability");
		}
		return i;
	}

	public boolean roll(){
	    return (int)((Math.random() * 100) + 1) <= this.getProbability();
    }
	
}
