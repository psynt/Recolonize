package entities;

public abstract class Entity{
	private final String name;
	private final long id;
	protected boolean group;
	private Assignment assignment;
	
	
	protected Entity(long id,String name){
		assignment = Assignment.None;
		this.id = id;
		this.name = name;
	}
	
	public void setAsssignment(Assignment a){
		assignment = a;
	}

	public String getName() {
		return name;
	}
	
	public long getID(){
		return id;
	}
	
	public final boolean isGroup(){
		return group;
	}
	
	public String getAssignment() {
		return assignment.toString();
	}
	
	public abstract int getCook();
	public abstract int getSearch();
	public abstract int getFight();

	
}
