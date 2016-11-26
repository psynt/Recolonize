package cycle;

import java.util.ArrayList;

import application.IController;
import entities.Entity;
import entities.Member;
import javafx.collections.FXCollections;

public class DummyGame implements IGame {
	public ArrayList<Entity> list = new ArrayList<Entity>();
	private IController ic;
	
	
	public DummyGame( IController ic) {
		this.ic = ic;
		list.add(new Member("Bob",10));
		list.add(new Member("John",10));
		list.add(new Member("Amy",10));
		ic.updateList(FXCollections.observableArrayList(list));
	}
	

	@Override
	public void setEntityList(ArrayList<Entity> a) {
		list = a;
	}
	
	

	

}
