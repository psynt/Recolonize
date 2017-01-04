package entities;

import collections.NameDispenser;

import java.util.ArrayList;

public class MemberFactory {

	public static Member gimmie(){
		return new Member(NameDispenser.next(), 3);
	}

	public static ArrayList<Member> gimmie(int n){
		ArrayList<Member> m = new ArrayList<Member>(n);
		for(int i = 0 ; i < n ; i++){
			m.add(gimmie());
		}
		return m;
	}
}
