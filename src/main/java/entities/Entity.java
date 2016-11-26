package entities;

/**
 * Entities - Members or Groups (of members)
 * @author nichita
 *
 */
public abstract class Entity{
	private final String name;
	protected boolean group;
	private Assignment assignment;
	
	
	protected Entity(String name){
		assignment = Assignment.None;
		this.name = name;
	}
	
	/**
	 * Assignment for current entity
	 * @param a new assignment value
	 */
	public void setAsssignment(Assignment a){
		assignment = a;
	}

	/**
	 * 
	 * @return name of the poor sod
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Do not override this or the compiler will eat you alive
	 * @return to group or not to group
	 */
	public final boolean isGroup(){
		return group;
	}
	
	/**
	 * for the pretty table on the front page.
	 * @return table stuff
	 */
	public final String getAssignment() {
		return assignment.toString();
	}
	
	public abstract int getCook();
	public abstract int getSearch();
	public abstract int getFight();

	
}
