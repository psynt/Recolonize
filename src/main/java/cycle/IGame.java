package cycle;

import java.util.ArrayList;
import entities.Entity;

public interface IGame {
	void setEntityList(ArrayList<Entity> list);
	
	int getMemberCount();
	int getFoodCount();
	int getWepCount();
	int getUncCount();
	
	/**
	 * when the user presses the "next" button, this gets called
	 * @return result of the day as a string
	 */
	String next();
}
