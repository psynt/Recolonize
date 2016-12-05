package skills;

import java.util.Random;
/**
 * initializes skills with a random value [1,m]
 * @author nichita
 *
 */
public class RandomSkillInit extends SkillInit {
	private static Random r= new Random();
	private int max;
	private XpCurve x= XCv.apply();
	/**
	 * 
	 * @param m maximum value for the random generator
	 * @param name name of the skill
	 */
	public RandomSkillInit(int m,String name) {
		super(name);
		max=m;
	}

	@Override
	public Skill newSkill() {
		return new Skill(name,x.xpForLevel(r.nextInt(max)+1));
	}


}
