package application;

import cycle.Game;
import cycle.IGame;
import entities.Assignment;
import entities.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static application.Constants.*;

public class SampleController implements Initializable,IController{

	@FXML TableView<Member> table;
	@FXML TableColumn<Member,String> name;
	@FXML TableColumn<Member,String> assignment;
	@FXML TableColumn<Member,String> hasWep;
	
	@FXML ContextMenu menu1;
	@FXML MenuItem gvw;
	@FXML MenuItem tkw;

	@FXML TextArea textymexty;

	@FXML TextField mem;
	@FXML TextField food;
	@FXML TextField unc;
	@FXML TextField wep;

	@FXML Button go;

	private boolean lost;
	private IGame ig;
	private ObservableList<Member> list = FXCollections.observableArrayList();
	
	@FXML public void sayHello() {
		System.out.println("Hello World!");
	}
	
	@FXML public void printStats() {
		ObservableList<Member> selection = table.getSelectionModel().getSelectedItems();
		for(Member it:selection){
			System.out.println(it.toString());
		}
		System.out.println();
	}

	@Override
	public void lost(){
		lost = true;
	}


	public void updateList(ObservableList<Member> e){
		list = e;
		table.setItems(list);
		table.refresh();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ig = new Game(this);
		TableColumn<Member,Integer> cols[] = new TableColumn[NUM_SKILLS];
		for (int i = 0 ; i<cols.length ; i++) {
			cols[i] = new TableColumn<Member, Integer>(SKILL_NAMES[i]);
			table.getColumns().add(cols[i]);
			cols[i].setCellValueFactory(new PropertyValueFactory<Member,Integer>(SKILL_NAMES[i]));
		}

		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		name.setCellValueFactory(new PropertyValueFactory<Member,String>("name"));
		assignment.setCellValueFactory(new PropertyValueFactory<Member,String>("assignment"));
		hasWep.setCellValueFactory(new PropertyValueFactory<Member, String>("weapon"));
		table.setItems(list);
		update();
	}

	@FXML public void checkMenuItems() {
		ArrayList<Member> a = new ArrayList<Member>(table.getSelectionModel().getSelectedItems());

		//arm
		long selected = a.parallelStream().filter(e -> !e.hasWeapon()).count();
		boolean enoughWep = selected <= Integer.parseInt(wep.getText());
		gvw.setDisable(!enoughWep);

	}
	
	private void update(){
		mem.setText(ig.getMemberCount() + "");
		food.setText(ig.getFoodCount() + "");
		unc.setText(ig.getUncCount() + "");
		wep.setText(ig.getWepCount() + "");
		table.refresh();
	}

	@FXML public void next() {
		textymexty.setText(ig.next());
		table.refresh();

		if(lost){
			go.setDisable(true);
		}

		update();
		
		
	}

	@FXML public void assign(ActionEvent event) {
		
		Assignment a = Assignment.toAssignment(((MenuItem)event.getSource()).getText());
		
		table.getSelectionModel().getSelectedIndices().parallelStream().forEach(e -> list.get(e).setAsssignment(a));
		table.refresh();

	}


	@FXML
	public void gw(ActionEvent actionEvent) {
		ArrayList<Member> a = new ArrayList<Member>();
		table.getSelectionModel().getSelectedItems().stream().filter(e -> !e.hasWeapon()).forEach(e -> a.add(e));

		a.forEach(e -> e.arm());
		ig.addWep(-a.size());

		update();

	}

	@FXML
	public void tw(ActionEvent actionEvent) {
		ArrayList<Member> a = new ArrayList<Member>();
		table.getSelectionModel().getSelectedItems().stream().filter(e -> e.hasWeapon()).forEach(e -> a.add(e));

		a.forEach(e -> e.disArm());
		ig.addWep(a.size());

		update();

	}
}
