package entities;

import java.util.ArrayList;

import skills.MemberSkills;
import skills.MemberSkillsFactory;
/**
 * Represents individuals in our Colony
 * @author nichita
 *
 */
public final class Member extends Entity{
	private final MemberSkills skillset;
	/***
	 * 
	 * @param name Name of the poor guy
	 * @param s starting skill level. handled in MemberSkillsFactory, passed as "m"
	 */
	public Member(String name,  int s){
		super(" " + name);
		super.group = false;
		skillset = MemberSkillsFactory.create(s);
	}
	
	public Member(){
		this("Bob",10);
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

	@Override
	public ArrayList<Member> getAll() {
		ArrayList<Member> a = new ArrayList<Member>();
		a.add(this);
		return a;
	}
}
