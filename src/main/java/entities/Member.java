package entities;

import skills.MemberSkills;
import skills.MemberSkillsFactory;

import java.util.ArrayList;
/**
 * Represents individuals in our Colony
 * @author nichita
 *
 */
public final class Member extends Entity{
	private final MemberSkills skillset;
	private boolean weapon;

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

	/**
	 *
	 * @return true if given member has a weapon, false if he may only use his fists
	 */
	public boolean hasWeapon(){
		return weapon;
	}

	/**
	 * gives or takes poor sod's weapon
	 * @param newWeapon new value for field weapon
	 */
	public void giveTakeWeapon(boolean newWeapon) {
		weapon = true;
	}

	@Override
	public String toString() {
		return getName() + " has: " + getSearch() + " searching, " + getCook() + " cooking, " + getFight() + " fighting";
	}

	public MemberSkills getSkillset(){
		return skillset;
	}

	@Override
	public ArrayList<Member> getAll() {
		ArrayList<Member> a = new ArrayList<Member>();
		a.add(this);
		return a;
	}
}
