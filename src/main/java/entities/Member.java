package entities;

import skills.MemberSkillsFactory;
import skills.Skill;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Represents individuals in our Colony
 * @author nichita
 *
 */
public final class Member extends Entity{
	private HashMap<String,Skill> skillset;

	/**
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
		return skillset.get("cook").getLevel();
	}

	@Override
	public int getSearch() {
		return skillset.get("search").getLevel();
	}

	@Override
	public int getFight() {
		return skillset.get("fight").getLevel();
	}

	@Override
	public String toString() {
		return getName() + " has: " + getSearch() + " searching, " + getCook() + " cooking, " + getFight() + " fighting";
	}

	/**
	 * gain xp
	 * @param skill skill that xp is gained in
	 * @param amount amount of xp that is gained
	 */
	public void addXp(String skill,int amount){
		skillset.get(skill).gainXp(amount);
	}


	@Override
	public ArrayList<Member> getAll() {
		ArrayList<Member> a = new ArrayList<Member>();
		a.add(this);
		return a;
	}
}
