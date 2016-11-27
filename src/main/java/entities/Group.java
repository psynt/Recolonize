package entities;

import java.util.ArrayList;

public final class Group extends Entity{
	private ArrayList<Member> members;
	/**
	 * 
	 * @param members ArrayList of members that the group should start out with
	 * @param name name of the group
	 */
	public Group( ArrayList<Member> members, String name) {
		super("*" + name);
		super.group = true;
		this.members = members;
		
	}
	/**
	 * 
	 * @param name name of the group
	 */
	public Group(String name) {
		this(new ArrayList<Member>(),name);
	}
	/**
	 * 
	 * @param m Member to be added
	 */
	public void add(Member m){
		members.add(m);
	}
	
	@Override
	public int getCook(){
		return members.parallelStream().map(e -> e.getCook()).reduce(0, (a ,b)-> a+b);
		
	}
	
	@Override
	public int getSearch(){
		return members.parallelStream().map(e -> e.getSearch()).reduce(0, (a ,b)-> a+b);
	}
	
	@Override
	public int getFight(){
		return members.parallelStream().map(e -> e.getFight()).reduce(0, (a ,b)-> a+b);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(getName() + " has: " + getSearch() + " searching, " + getCook() + " cooking, " + getFight() + " fighting\n");
		members.stream().forEach(e -> sb.append("\t" + e.toString() + "\n"));
		return sb.toString();
	}
	@Override
	public ArrayList<Member> getAll() {
		return members;
	}

}
