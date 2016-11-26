package skills;

import java.util.Hashtable;
/**
 * Skillset for members
 * @author nichita
 *
 */
public class MemberSkills implements ISkillSet{

	private Hashtable<String,Skill> skillset;
	/**
	 * Constructs a new skillset
	 * @param n number of skills
	 */
	public MemberSkills(int n){
		skillset = new Hashtable<String, Skill>(n);
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
		return skillset.get("cook").getLevel();
	}

	public int getSearch() {
		return skillset.get("search").getLevel();
	}

	public int getFight() {
		return skillset.get("fight").getLevel();
	}

	@Override
	public Skill[] getSkills() {
		return (Skill[]) skillset.entrySet().stream().map(e -> e.getValue()).toArray();
	}

	@Override
	public void add(Skill s) {
		skillset.put(s.getName(), s);
	}
	
	
	
}
