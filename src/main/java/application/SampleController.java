package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entities.Entity;
import entities.Group;
import entities.Member;
import guiparts.ExistingGroupController;
import guiparts.NewGroupController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SampleController implements Initializable{

	@FXML TableView<Entity> table;
	@FXML TableColumn<Entity,String> name;
	@FXML TableColumn<Entity,Integer> search;
	@FXML TableColumn<Entity,Integer> cook;
	@FXML TableColumn<Entity,Integer> fight;
	
	@FXML ContextMenu menu1;
	@FXML MenuItem newGroup;

	
	private volatile long entityCount; //PK for entities
	
	public ObservableList<Entity> list = FXCollections.observableArrayList();
	
	
	@FXML MenuItem unGroup;
	@FXML MenuItem delGr;
	@FXML MenuItem add;
	
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
	
	private synchronized void add(Entity m){
		list.add(m);
	}
	private synchronized void rm(Entity m){
		list.remove(m);
	}
	
	
	
	private synchronized void newGuy(String s){
		Member m=new Member(entityCount++, s , 10);
		add(m);
	}
	
	private synchronized void newGroup(String s){
		Group g = new Group(entityCount++, s);
		add(g);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		newGuy("Bob");
		newGuy("John");
		newGuy("Amy");

		table.getSelectionModel().setSelectionMode(
		    SelectionMode.MULTIPLE
		);
		
		name.setCellValueFactory(new PropertyValueFactory<Entity,String>("name"));
		search.setCellValueFactory(new PropertyValueFactory<Entity,Integer>("search"));
		cook.setCellValueFactory(new PropertyValueFactory<Entity,Integer>("cook"));
		fight.setCellValueFactory(new PropertyValueFactory<Entity,Integer>("fight"));
		table.setItems(list);
		
	}
	
	private void putInGroup(Group g){
		ArrayList<Entity> a = new ArrayList<Entity>(table.getSelectionModel().getSelectedItems());
		a.stream().filter(e -> !e.isGroup()).forEach(e -> {rm(e); g.add((Member)e);});
		
	}


	@FXML public void checkMenuItems() {
		ArrayList<Entity> a = new ArrayList<Entity>(table.getSelectionModel().getSelectedItems());
		boolean del = a.size() > 0 && !a.parallelStream().filter(e -> !e.isGroup()).map(e -> !e.isGroup()).reduce(false, (x,y) -> x||y);
		delGr.setDisable(!del);
		
		boolean existing = a.size() > 0 && !a.parallelStream().filter(e -> e.isGroup()).map(e -> e.isGroup()).reduce(false, (x,y) -> x||y)
				&& list.parallelStream().filter(e -> e.isGroup()).map(e -> e.isGroup()).reduce(false, (y,z) -> y||z);
		add.setDisable(!existing);
		
	}


	@FXML public void unGroup() {
		ArrayList<Group> a = new ArrayList<Group>();
		table.getSelectionModel().getSelectedItems().stream().filter(e -> e.isGroup()).forEach(e -> a.add((Group) e));
		
		a.stream().forEach(e -> {
			e.getMembers().forEach(m -> {
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


	
}
