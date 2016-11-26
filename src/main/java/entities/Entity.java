package entities;

public abstract class Entity{
	private final String name;
	private final long id;
	protected boolean group;
	
	protected Entity(long id,String name){
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public long getID(){
		return id;
	}
	
	public boolean isGroup(){
		return group;
	}
	
	public abstract int getCook();
	public abstract int getSearch();
	public abstract int getFight();

	
}
