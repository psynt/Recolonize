package cycle;

import entities.Entity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Game implements IGame {
	private Day day;
	private Night night;
	private Colony colony;
	
	public void initialise() {
		day = new Day();
		night = new Night();
		colony = new Colony();
	}
	
	public void performDay() {
		day.perform();
	}
	
	public void performNight() {
		night.perform();
	}
	
	
}
