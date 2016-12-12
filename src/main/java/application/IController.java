package application;

import entities.Member;
import javafx.collections.ObservableList;

public interface IController {
	void updateList(ObservableList<Member> e);
	void lost();

}
