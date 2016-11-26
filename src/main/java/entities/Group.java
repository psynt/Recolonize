package entities;

import java.util.ArrayList;

public class Group extends Entity{
	private ArrayList<Member> members;
	
	public Group(long id, ArrayList<Member> members, String name) {
		super(id, "*" + name);
		super.group = true;
		this.members = members;
		
	}
	
	public Group(long id, String name) {
		this(id, new ArrayList<Member>(),name);
	}
	
	public void add(Member m){
		members.add(m);
	}
	
	public ArrayList<Member> getMembers(){
		return members;
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

}
