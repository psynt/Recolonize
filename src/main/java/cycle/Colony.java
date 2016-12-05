package cycle;

import application.Functions;
import cycle.events.Probabilities;
import entities.Member;

import java.util.ArrayList;
import java.util.Collections;

import static application.Constants.*;
import static entities.MemberFactory.gimmie;

public class Colony {
	private ArrayList<Member> members = new ArrayList<Member>();
	private int rations;
	private int uncooked;
	private int weapons;
	// need to add cookbots, turrets and radio
	
	public Colony(int rations,int uncooked,int weapons,int numberOfPeople){
		this.rations = rations;
		this.weapons = weapons;
		this.uncooked = uncooked;
		members.addAll(gimmie(numberOfPeople));
	}
	public Colony(){
		this(INIT_RATIONS,INIT_UNC,INIT_WEAPONS,INIT_SURV);
	}
	
	public void merge(Colony c2){
		weapons+=c2.weapons;
		rations+=c2.rations;
		uncooked+=c2.uncooked;
		members.addAll(c2.members);
	}

	public void addUncooked(int unc){
		this.uncooked += unc;
	}
	public void addRations(int rat){
		this.rations += rat;
	}
	public void addWeapons(int wep){
		this.weapons += wep;
	}

	public ArrayList<Member> kill(int n){

		ArrayList<Member> deaths = new ArrayList<>();
		Collections.shuffle(members);
		for (int i = Functions.min(members.size(),n)-1 ; i>=0 ; i--) {
			if( ((int)(Math.random()*100)) >= Probabilities.veryLow.getProbability() ) {
				deaths.add(members.get(i));
				members.remove(i);
			}

		}

		return deaths;

	}

	private int min(int a, int b){
		return a>b?b:a;
	}
	
	public ArrayList<Member> getMembers(){
		return members;
	}
	public void findSomeone(){
		members.add(gimmie());
	}
	
	public void updateMembers(ArrayList<Member> updatedList){
		members = updatedList;
	}
	
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
	
	public int getSurvivors() {
		return members.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(rations + " rations\n" +
				weapons + " weapons\n" +
				uncooked + " unc\n" +
				members.size() + " survivors:\n");

		members.forEach(e -> sb.append(e.getName()));
		sb.append("\n");

		return sb.toString();
	}
}
