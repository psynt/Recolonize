package skills;

public class BasicSkillInit implements SkillInit {

	int n;
	
	public BasicSkillInit(int n) {
		this.n = n;
	}


	public BasicSkillInit() {
		this(1);
	}
	
	
	@Override
	public Integer newSkill() {
		return n;
	}

}
