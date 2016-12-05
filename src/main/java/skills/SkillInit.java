package skills;

/**
 * Automated skill initializers should extend this
 * @author nichita
 *
 */
public abstract class SkillInit {
	/**
	 * 
	 * @return new Skill
	 */
	public abstract Skill newSkill(String name);

}
