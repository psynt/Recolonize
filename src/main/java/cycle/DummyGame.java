package cycle;

import java.util.ArrayList;

import entities.Entity;
import entities.Member;

public class DummyGame extends ArrayList<Entity> implements IGame {
	public ArrayList<Entity> list = new ArrayList<Entity>();
	
	public DummyGame() {
		list.add(new Member("Bob",10));
		list.add(new Member("John",10));
		list.add(new Member("Amy",10));
	}


	@Override
	public boolean add(Entity e) {
		return list.add(e);
	}

	@Override
	public void rm(Entity e) {
		list.remove(e);
	}


	@Override
	public void setList(ArrayList<Entity> a) {
		list = a;
		
	}

	

}
