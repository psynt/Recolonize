package skills;
/**
 * Initializes skills with the value that is passed in
 * @author nichita
 *
 */
public class BasicSkillInit extends SkillInit {
	private int n;
	private XpCurve x= XCv.apply();
	/**
	 * Initializes the skill factory with:
	 * @param n initial created skill value
	 */
	public BasicSkillInit(int n) {
		this.n = n;
	}
	
	@Override
	public Skill newSkill(String name) {
		return new Skill(name,x.xpForLevel(n));
	}

}
