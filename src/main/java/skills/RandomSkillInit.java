package skills;

public class RandomSkillInit implements SkillInit {
	private int max;
	
	public RandomSkillInit(int m) {
		max=m;
	}

	@Override
	public Integer newSkill() {
		return (int)(Math.random() * max);
	}

}
