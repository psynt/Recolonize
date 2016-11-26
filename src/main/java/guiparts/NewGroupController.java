package guiparts;

import application.Report;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewGroupController {

	@FXML TextField newName;
	private Report<String> s;
	
	public NewGroupController(Report<String> s) {
		this.s=s;
	}
	
	@FXML public void nameSet(ActionEvent event) {
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		s.tell(newName.getText());
		stage.close();
	}
}
