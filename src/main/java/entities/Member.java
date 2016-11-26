package entities;

import skills.MemberSkills;
import skills.MemberSkillsFactory;

public class Member extends Entity{
	private final MemberSkills skillset;
	
	public Member(long id, String name,  int s){
		super(id, " " + name);
		super.group = false;
		skillset = MemberSkillsFactory.create(s);
	}
	
	public Member(int id){
		this(id,"Bob",10);
	}

	@Override
	public int getCook() {
		return skillset.getCook();
	}

	@Override
	public int getSearch() {
		return skillset.getSearch();
	}

	@Override
	public int getFight() {
		return skillset.getFight();
	}
	
	@Override
	public String toString() {
		return getName() + " has: " + getSearch() + " searching, " + getCook() + " cooking, " + getFight() + " fighting";
	}
}
