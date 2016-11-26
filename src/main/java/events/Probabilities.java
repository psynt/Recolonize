package events;

public enum Probabilities {
	Low,Med,High;
	public int getProbability(){
		switch(this){
		case High: return 75;
		case Low: return 25;
		case Med: return 50;
		default: throw new RuntimeException("Probability not found");
		}
	}

}
