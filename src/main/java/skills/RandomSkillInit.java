package skills;

public class RandomSkillInit extends SkillInit {
	private int max;
	
	public RandomSkillInit(int m,String name) {
		super(name);
		max=m;
	}

	@Override
	public Skill newSkill() {
		return new Skill(name,(int)(Math.random() * max));
	}


}
