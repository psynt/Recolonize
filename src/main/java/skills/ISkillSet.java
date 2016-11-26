package skills;

/**
 * all skillsets should implement this
 * @author nichita
 *
 */
public interface ISkillSet {
	/**
	 * 
	 * @return number of skills
	 */
	int getSkillNum();
	
	/**
	 * 
	 * @return String[] containing names of all skills
	 */
	String[] getSkillNames();
	
	/**
	 * 
	 * @return Skill[] containing all skills
	 */
	Skill[] getSkills();
	
	/**
	 * adds a skill to the skillset
	 * @param s skill to be added
	 */
	void add(Skill s);
}
