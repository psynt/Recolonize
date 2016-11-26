package skills;
/**
 * Initializes skills with the value that is passed in
 * @author nichita
 *
 */
public class BasicSkillInit extends SkillInit {
	private int n;
	/**
	 * Initializes the skill factory with:
	 * @param n initial created skill value
	 * @param name skill name
	 */
	public BasicSkillInit(int n,String name) {
		super(name);
		this.n = n;
	}
	
	@Override
	public Skill newSkill() {
		return new Skill(name, n);
	}

}
