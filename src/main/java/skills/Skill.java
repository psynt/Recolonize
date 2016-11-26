package skills;

/**
 * Skill containing its name and its level
 * @author nichita
 *
 */
public class Skill {
	private int level;
	private final String name;
	
	/**
	 * Constructor
	 * @param name skill name
	 * @param level starting level
	 */
	public Skill(String name, int level) {
		this.level = level;
		this.name = name;
	}
	
	/**
	 * 
	 * @return skill level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * 
	 * @param level skill level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * 
	 * @return skil lname
	 */
	public String getName() {
		return name;
	}
	

}
