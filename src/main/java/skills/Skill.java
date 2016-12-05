package skills;

/**
 * Skill containing its name and its xp
 * @author nichita
 *
 */
public class Skill {
	private int xp;
	private final String name;
	private XpCurve xpc;

	/**
	 * Constructor
	 * @param name skill name
	 * @param xp starting xp
	 */
	public Skill(String name, int xp) {
		this.xp = xp;
		this.name = name;
		xpc = XCv.apply();
	}
	
	/**
	 * 
	 * @return skill level
	 */
	public int getLevel() {
		//System.err.println(xp + " is level " + xpc.getLevel(xp));
		return xpc.getLevel(xp);
	}
	/**
	 * Xp limited to 1 000 000
	 * @param xp skill xp
	 */
	public void gainXp(int xp) {
		if(this.xp + xp >=1e6){
			this.xp = (int)1e6;
		}
		this.xp += xp;
	}
	/**
	 * 
	 * @return skill name
	 */
	public String getName() {
		return name;
	}
	public int getXp(){
		return xp;
	}
	

}
