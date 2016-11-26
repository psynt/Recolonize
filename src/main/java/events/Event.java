package events;

import java.util.ArrayList;

/**
 * All events should stem from this
 * @author nichita
 *
 */
public abstract class Event {
	protected Probabilities p;
	/**
	 * Constructor. sets probability
	 * @param pr probability
	 */
	public Event(Probabilities pr) {
		p = pr;
	}
	
	/**
	 * Event passes if and only if a random int [1,100] <= return of this function
	 * @return the probability of the event as int
	 */
	public int getProbability(){
		return p.getProbability();
	}
	
}
