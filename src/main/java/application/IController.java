package application;

import entities.Entity;
import javafx.collections.ObservableList;

public interface IController {
	void updateList(ObservableList<Entity> e);
}
