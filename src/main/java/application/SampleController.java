package application;

import cycle.Game;
import cycle.IGame;
import entities.Assignment;
import entities.Entity;
import entities.Group;
import entities.Member;
import guiparts.ExistingGroupController;
import guiparts.NewGroupController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static application.Constants.NUM_SKILLS;
import static application.Constants.SKILL_NAMES;

public class SampleController implements Initializable,IController{

	@FXML TableView<Entity> table;
	@FXML TableColumn<Entity,String> name;
	@FXML TableColumn<Entity,String> assignment;
	@FXML TableColumn<Entity,String> hasWep;
	
	@FXML ContextMenu menu1;
	@FXML MenuItem newGroup;
	@FXML MenuItem unGroup;
	@FXML MenuItem delGr;
	@FXML MenuItem add;
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
	private ObservableList<Entity> list = FXCollections.observableArrayList();
	
	@FXML public void sayHello() {
		System.out.println("Hello World!");
	}
	
	@FXML public void printStats() {
		ObservableList<Entity> selection = table.getSelectionModel().getSelectedItems();
		for(Entity it:selection){
			System.out.println(it.toString());
		}
		System.out.println();
	}

	@Override
	public void lost(){
		lost = true;
	}
	
	private synchronized void add(Entity m){
		list.add(m);
	}
	private synchronized void rm(Entity m){
		list.remove(m);
	}
	
	private synchronized void newGroup(String s){
		Group g = new Group(s);
		add(g);
	}
	
	public void updateList(ObservableList<Entity> e){
		list = e;
		table.setItems(list);
		table.refresh();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ig = new Game(this);
		TableColumn<Entity,Integer> cols[] = new TableColumn[NUM_SKILLS];
		for (int i = 0 ; i<cols.length ; i++) {
			cols[i] = new TableColumn<Entity, Integer>(SKILL_NAMES[i]);
			table.getColumns().add(cols[i]);
			cols[i].setCellValueFactory(new PropertyValueFactory<Entity,Integer>(SKILL_NAMES[i]));
		}

		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		name.setCellValueFactory(new PropertyValueFactory<Entity,String>("name"));
		assignment.setCellValueFactory(new PropertyValueFactory<Entity,String>("assignment"));
		hasWep.setCellValueFactory(new PropertyValueFactory<Entity, String>("weapon"));
		table.setItems(list);
		update();
	}
	
	private void putInGroup(Group g){
		ArrayList<Entity> a = new ArrayList<Entity>(table.getSelectionModel().getSelectedItems());
		a.stream().filter(e -> !e.isGroup()).forEach(e -> {e.setAsssignment(Assignment.None);rm(e); g.add((Member)e);});
		
	}


	@FXML public void checkMenuItems() {
		ArrayList<Entity> a = new ArrayList<Entity>(table.getSelectionModel().getSelectedItems());

//		//delete group
//		boolean del = a.size() > 0 && !a.parallelStream().anyMatch(e -> e.isGroup());//filter(e -> !e.isGroup()).map(e -> !e.isGroup()).reduce(false, (x,y) -> x||y);
//		delGr.setDisable(!del);
//
//
//		//add to group
//		boolean existing = a.size() > 0 && !a.parallelStream().anyMatch(e -> e.isGroup())//filter(e -> e.isGroup()).map(e -> e.isGroup()).reduce(false, (x,y) -> x||y)
//				&& list.parallelStream().anyMatch(e -> e.isGroup());//filter(e -> e.isGroup()).map(e -> e.isGroup()).reduce(false, (y,z) -> y||z);
//		add.setDisable(!existing);

		//arm
		long selected = a.parallelStream().filter(e -> !e.hasWeapon()).count();
		boolean enoughWep = selected <= Integer.parseInt(wep.getText());
		gvw.setDisable(!enoughWep);

	}


	@FXML public void unGroup() {
		ArrayList<Group> a = new ArrayList<Group>();
		table.getSelectionModel().getSelectedItems()
			.stream().filter(e -> e.isGroup())
				.forEach(e -> a.add((Group) e));
		
		a.stream().forEach(e -> {
			e.getAll().forEach(m -> {
				add(m);
			});
			rm(e);
		});
	}




	@FXML public void newGroup() throws IOException {
		Stage stage = new Stage();
		
		FXMLLoader l = new FXMLLoader(getClass().getResource("/guiparts/NewGroup.fxml"));
		
		l.setController(new NewGroupController(new Report<String>(){
			@Override
			public void tell(String text) {
				newGroup(text);
			}
		}));
		
		AnchorPane ac=l.load();
		
		stage.setScene(new Scene(ac));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(table.getScene().getWindow());
		stage.showAndWait();
	}


	@FXML public void addToGroup() throws IOException {
		Stage stage = new Stage();
		
		FXMLLoader l = new FXMLLoader(getClass().getResource("/guiparts/ExistingGroup.fxml"));
		
		ObservableList<Group> groupList = FXCollections.observableArrayList();
				
		list.stream().filter(e -> e.isGroup()).forEach(e -> groupList.add((Group)e));
		
		l.setController(new ExistingGroupController(new Report<Group>(){
			@Override
			public void tell(Group text) {
				putInGroup(text);
			}
		},groupList));
		
		AnchorPane ac=l.load();
		
		stage.setScene(new Scene(ac));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(table.getScene().getWindow());
		stage.showAndWait();
		
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
		ArrayList<Entity> a = new ArrayList<Entity>();
		table.getSelectionModel().getSelectedItems().stream().filter(e -> !e.hasWeapon()).forEach(e -> a.add(e));

		a.forEach(e -> e.arm());
		ig.addWep(-a.size());

		update();

	}

	@FXML
	public void tw(ActionEvent actionEvent) {
		ArrayList<Entity> a = new ArrayList<Entity>();
		table.getSelectionModel().getSelectedItems().stream().filter(e -> e.hasWeapon()).forEach(e -> a.add(e));

		a.forEach(e -> e.disArm());
		ig.addWep(a.size());

		update();

	}
}
