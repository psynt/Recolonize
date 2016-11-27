package cycle;

import static application.Constants.*;

import java.util.ArrayList;

import entities.Member;
import static entities.MemberFactory.*;

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
	
	/**
	 * cook food
	 * @param n number of people that cook food
	 */
	public void cook(int n){
		int unc_pending_cooking = min(n * CHEF_COOK,uncooked);
		uncooked-=unc_pending_cooking;
		rations+=unc_pending_cooking * UNC_RAT;
		
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
	
	
}
