package cycle;

import entities.Member;

import java.util.ArrayList;

public interface IGame {
	void setEntityList(ArrayList<Member> list);
	
	int getMemberCount();
	int getFoodCount();
	int getWepCount();
	int getUncCount();

	void addWep(int x);

	/**
	 * when the user presses the "next" button, this gets called
	 * @return result of the day as a string
	 */
	String next();
}
