package cycle;

import entities.Entity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Colony {
	private ObservableList<Entity> entities = FXCollections.observableArrayList();
	private int survivors;
	private int rations;
	private int uncooked;
	private int weapons;
	// need to add cookbots, turrets and radio
	
	public int getRations() {
		return rations;
	}

	public void setRations(int rations) {
		this.rations = rations;
	}

	public int getUncooked() {
		return uncooked;
	}

	public void setUncooked(int uncooked) {
		this.uncooked = uncooked;
	}

	public int getWeapons() {
		return weapons;
	}

	public void setWeapons(int weapons) {
		this.weapons = weapons;
	}

	public void setSurvivors(int survivors) {
		this.survivors = survivors;
	}
	
	public int getSurvivors() {
		return survivors;
	}
	
	
}
