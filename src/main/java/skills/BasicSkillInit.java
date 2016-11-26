package skills;

public class BasicSkillInit extends SkillInit {
	private int n;
	
	public BasicSkillInit(int n,String name) {
		super(name);
		this.n = n;
	}
	
	@Override
	public Skill newSkill() {
		return new Skill(name, n);
	}

}
