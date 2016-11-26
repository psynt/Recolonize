package skills;

public class MemberSkillsFactory {
	public static MemberSkills create(int m){
		return new MemberSkills(new RandomSkillInit(m));
	}

}
