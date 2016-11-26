package skills;

public class Skill {
	private int level;
	private final String name;
	
	public Skill(String name, int level) {
		this.level = level;
		this.name = name;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	

}
