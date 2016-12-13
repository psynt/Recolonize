package application;

import entities.Member;
import javafx.collections.ObservableList;

public interface IController {

    /**
     * update the list that will be shown to the user.
     * @param e new list
     */
	void updateList(ObservableList<Member> e);

    /**
     * call when game is lost
     */
	void lost();

}
