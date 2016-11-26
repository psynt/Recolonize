package skills;

import java.util.Hashtable;

public class MemberSkills implements ISkills{

	private Hashtable<String,Integer> skillset;
	
	public MemberSkills(SkillInit s){
		skillset = new Hashtable<String, Integer>(3);
		skillset.put("search", s.newSkill());
		skillset.put("cook", s.newSkill());
		skillset.put("fight", s.newSkill());
		
	}
	
	@Override
	public int getSkillNum() {
		return skillset.size();
	}

	@Override
	public String[] getSkillNames() {
		return (String[]) skillset.entrySet().stream().map(e -> e.getKey()).toArray();
	}

	public int getCook() {
		return skillset.get("cook");
	}

	public int getSearch() {
		return skillset.get("search");
	}

	public int getFight() {
		return skillset.get("fight");
	}
	
	
	
}
