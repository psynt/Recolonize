package cycle;

import java.util.ArrayList;

import application.IController;
import entities.Entity;
import entities.Member;
import javafx.collections.FXCollections;

public class DummyGame implements IGame {
	private ArrayList<Entity> list = new ArrayList<Entity>();
	private IController ic;
	private Colony colony;
	
	
	public DummyGame( IController ic) {
		list.add(new Member());
		colony = new Colony();
		colony.findSomeone();
		colony.findSomeone();
		colony.findSomeone();
		colony.findSomeone();
		colony.findSomeone();
		colony.findSomeone();
		colony.findSomeone();
		this.ic = ic;
		this.ic.updateList(FXCollections.observableArrayList(colony.getMembers()));
		
	}
	

	@Override
	public void setEntityList(ArrayList<Entity> a) {
		list = a;
	}


	@Override
	public String next() {
		return "Doing something";
		
	}
	


	@Override
	public int getMemberCount() {
		return colony.getSurvivors();
	}

	@Override
	public int getFoodCount() {
		return colony.getRations();
	}

	@Override
	public int getWepCount() {
		return colony.getWeapons();
	}

	@Override
	public int getUncCount() {
		return colony.getUncooked();
	}

	

}
