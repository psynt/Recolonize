package guiparts;

import application.Report;
import entities.Group;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ExistingGroupController {

	private Report<Group> s;
	@FXML ComboBox<String> group;
	@FXML Button but;
	private ObservableList<Group> groups;
	private ObservableList<String> gn;
	
	public ExistingGroupController(Report<Group> s, ObservableList<Group> groups) {
		
		this.s = s;
		this.groups = groups;
		
		gn = FXCollections.observableArrayList();
		groups.stream().forEach(e -> gn.add(e.getName()));
		
	}
	
	public void initialize() {
		group.setItems(gn);
		
	}
	
	@FXML public void grSelected(){
		but.setDisable(group.getSelectionModel().getSelectedIndex() == -1);
	}
	
	@FXML public void nameSet(ActionEvent event) {
		try{
			Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			s.tell(groups.get(group.getSelectionModel().getSelectedIndex()));
			stage.close();
		}catch(RuntimeException e){
			System.out.println("Invalid group selected");
		}
	}

}
