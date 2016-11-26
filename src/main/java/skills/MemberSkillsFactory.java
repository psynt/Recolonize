package skills;

import static application.Constants.*;

public class MemberSkillsFactory {
	public static MemberSkills create(int m){
		SkillInit s=new RandomSkillInit(m,"fight");
		MemberSkills ms =  new MemberSkills(NUM_SKILLS);
		for(String name : SKILL_NAMES){
			s.setName(name);
			ms.add(s.newSkill());
		}
		return ms;
	}

}
