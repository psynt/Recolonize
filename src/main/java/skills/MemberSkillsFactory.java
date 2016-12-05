package skills;

import java.util.HashMap;

import static application.Constants.*;

public class MemberSkillsFactory {
	
	/**
	 * Creates an instance of the appropriate skillset for Members
	 * @param m maximum value [1,m] that skills can start with
	 * @return Member skillset
	 */
	public static HashMap<String,Skill> create(int m){
		HashMap<String,Skill> s= new HashMap<>();
		SkillInit init = new RandomSkillInit(m);

		for(String name : SKILL_NAMES){
			Skill sk = init.newSkill(name);
			s.put(name,sk);
		}
		return s;
	}

}
