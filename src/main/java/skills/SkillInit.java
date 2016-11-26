package skills;

public abstract class SkillInit {
	protected String name;
	
	public SkillInit(String name){
		this.name=name;
	}
	public void setName(String name){
		this.name = name;
	}

	public abstract Skill newSkill();

}
