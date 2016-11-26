package skills;

public class MemberSkillsFactory {
	public static MemberSkills create(int m){
		SkillInit s=new RandomSkillInit(m,"fight");
		MemberSkills ms =  new MemberSkills(3);
		ms.add(new RandomSkillInit(m,"fight").newSkill());
		s.setName("cook");
		ms.add(s.newSkill());
		s.setName("search");
		ms.add(s.newSkill());
		return ms;
	}

}
