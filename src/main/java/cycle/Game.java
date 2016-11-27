package cycle;

import java.util.ArrayList;

import application.IController;
import entities.Entity;
import entities.Member;
import javafx.collections.FXCollections;

public class Game implements IGame {
	private Day day;
	private Night night;
	private Colony colony;
	private IController ic;
	private ArrayList<Entity> list = new ArrayList<Entity>();
	private StringBuilder sb = new StringBuilder();
	
	public Game(IController ic) {
		day = new Day();
		night = new Night();
		colony = new Colony();
		this.ic = ic;
		list.addAll(colony.getMembers());
		this.ic.updateList(FXCollections.observableArrayList(colony.getMembers()));
	}
	
	public void performDay() {
		day.perform();
	}
	
	public void performNight() {
		night.perform();
	}
	
	public static ArrayList<Member> unroll(ArrayList<Entity> a){
		ArrayList<Member> r = new ArrayList<Member>();
		
		for (Entity m : a) {
			r.addAll(m.getAll());
		}
		
		return r;
		
	}
	
	public void setEntityList(ArrayList<Entity> list) {
		this.list = list;
	}
	

	@Override
	public String next() {
		sb.delete(0,sb.length());
		sb.append("Pending implementation");
		
		//doStuff()
		
		
		//start updating colony
		
		colony.updateMembers(unroll(list));
		ic.updateList(FXCollections.observableArrayList(list));
		
		return sb.toString();
		
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
