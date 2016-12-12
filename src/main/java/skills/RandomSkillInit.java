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
	 */
	public RandomSkillInit(int m) {
		max=m;
	}

	@Override
	public Skill newSkill(String name) {
		return new Skill(name,x.xpForLevel(r.nextInt(max)+1));
	}


}
