package cycle;

import application.Constants;
import application.IController;
import cycle.events.CookEvent;
import cycle.events.SearchEvent;
import cycle.events.ZombiesEvent;
import entities.Member;
import javafx.collections.FXCollections;

import java.util.ArrayList;

public class Game implements IGame {
	private Colony colony;
	private IController ic;
	private ArrayList<Member> list = new ArrayList<>();
	private int dayCount = 0;
	
	public Game(IController ic) {
		colony = new Colony();
		this.ic = ic;
		list.addAll(colony.getMembers());
		this.ic.updateList(FXCollections.observableArrayList(colony.getMembers()));
	}
	
	public void setEntityList(ArrayList<Member> list) {
		this.list = list;
	}

	private StringBuilder finishDay(){
		StringBuilder sb = new StringBuilder();

		ArrayList<Member> searchParty = new ArrayList<>();
		ArrayList<Member> chefs = new ArrayList<>();

		colony.getMembers().forEach(e -> {switch(e.getAssignment()){
			case "Cook": chefs.add(e);
				break;
			case "Search": searchParty.add(e);
				break;
		}
		});

		Colony finds = SearchEvent.findStuff(searchParty);
		int unc = CookEvent.cook(chefs,colony.getUncooked());

		//search results
		sb.append("Your search party finds:\n" +
				finds.getRations() + " rations\n" +
				finds.getUncooked() + " uncooked food\n" +
				finds.getWeapons() + " weapons\n" +
				"And " + finds.getSurvivors() + " survivors:\n");

		finds.getMembers().forEach(e ->sb.append(e.getName()));

		sb.append("\n");

		//end search results
		//cooking results

		sb.append("Meanwhile, your " + chefs.size() + " chefs cook " + unc + " raw food into " + unc * Constants.UNC_RAT
				+ " rations of food \n");

		finds.addRations(unc * Constants.UNC_RAT);
		finds.addUncooked(-unc);

		//cooking end

		colony.merge(finds);

		//zombies start
		int zombies = ZombiesEvent.generateZombies(dayCount);
		sb.append("\n" + zombies + " zombies attack your poor colony tonight.\n");

		int res = ZombiesEvent.killManyZombies(zombies,colony.getMembers());
		if(res < 0){
			sb.append("You survive.\n");
		}else if(res == 0){
			sb.append("You barely made it through the night.\n");
		}else{
			sb.append(res + " zombies break through your defences. They kill some of your colony members.\n");
			//kill res members here
			ArrayList<Member> dead = colony.kill(res);
			dead.forEach(e -> sb.append(e.getName()) );
			sb.append(" die.\n");
		}
		//zombies end

		//meal start
		int eaten = colony.getSurvivors();

		sb.append("Late night feast: your colony members eat.\n");
		colony.addRations(-colony.getSurvivors());
		if(colony.getRations() < 0){
			sb.append("Food is, however, not sufficient.\n");
			ArrayList<Member> dead = colony.kill(-colony.getRations());
			dead.forEach(e -> sb.append(e.getName()));
			sb.append("\nDie of hunger.\n");
			colony.setRations(0);
		}else if(colony.getRations() < 5){
			sb.append("Food is running low!!!\n");
		}

		return sb;
	}


	@Override
	public String next() {
		StringBuilder sb = new StringBuilder();
//		sb.delete(0,sb.length());
//		sb.append("Pending implementation");
		
		//doStuff()
		colony.updateMembers(list);

		sb.append(finishDay());

		if(!survived()){
			sb.append("\n\n You LOST after " + dayCount + " days.\n");
			ic.lost();
			return sb.toString();
		}

		sb.append(startDay());

		list.clear();
		list.addAll(colony.getMembers());

		ic.updateList(FXCollections.observableArrayList(list));
		
		return sb.toString();
		
	}

	private boolean survived(){
		return colony.getSurvivors() > 0;
	}

	private StringBuilder startDay(){
		StringBuilder sb = new StringBuilder();
		dayCount++;
		sb.append("\n\n Welcome to Day " + dayCount + "\n");

		return sb;
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

	@Override
	public void addWep(int x) {
		colony.addWeapons(x);
	}
}
