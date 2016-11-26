package skills;

public interface ISkillSet {
	int getSkillNum();
	String[] getSkillNames();
	Skill[] getSkills();
	void add(Skill s);
}
