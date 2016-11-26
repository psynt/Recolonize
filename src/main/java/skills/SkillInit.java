package skills;

/**
 * Automated skill initializers should extend this
 * @author nichita
 *
 */
public abstract class SkillInit {
	protected String name;
	
	/**
	 * 
	 * @param name Skill name
	 */
	public SkillInit(String name){
		this.name=name;
	}
	
	/**
	 * 
	 * @param name Skill name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * 
	 * @return new Skill
	 */
	public abstract Skill newSkill();

}
