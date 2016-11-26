package skills;

import java.util.Random;

public class RandomSkillInit extends SkillInit {
	private static Random r= new Random();
	private int max;
	
	public RandomSkillInit(int m,String name) {
		super(name);
		max=m;
	}

	@Override
	public Skill newSkill() {
		return new Skill(name,r.nextInt(max+1));
	}


}
