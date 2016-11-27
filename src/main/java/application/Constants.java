package application;

public interface Constants {
	
	int NUM_SKILLS = 3;
	String[] SKILL_NAMES = {"search","cook","fight"};
	
	int INIT_SURV = 10;
	int INIT_RATIONS = 2 * INIT_SURV;
	int INIT_WEAPONS = 0;
	int	INIT_UNC = 0;
	
	/**
	 * food cooked by each person
	 */
	int CHEF_COOK = 2;
	
	/**
	 * uncooked -> ration ratio
	 */
	int UNC_RAT = 3;

}
