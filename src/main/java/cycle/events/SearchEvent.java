package cycle.events;

import cycle.Colony;
import entities.Member;
import skills.XPRates;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nichita on 03.12.2016.
 */
public class SearchEvent extends Event{
    public SearchEvent(){
        super(Probabilities.Certain);
    }

    private static final String SKILL = "search";

    private static ArrayList<Byte> find(Member m){
        ArrayList<Byte> res = new ArrayList<>();
        Random r = new Random();
        int rv;
        do{
            //add possibility to find an enemy and roll your fight againt his.
            rv = r.nextInt(100);
            if(rv<2) {  //survivor
                res.add((byte)3);
                m.addXp(SKILL, XPRates.SURV_FOUND);
            }else
            if (rv<10){ //weapon
                res.add((byte)2);
                m.addXp(SKILL, XPRates.WEP_FOUND);
            }else
            if (rv<40){ //unc
                res.add((byte)1);
                m.addXp(SKILL, XPRates.UNC_FOUND);
            }else
            if (rv<50){ //food
                res.add((byte)0);
                m.addXp(SKILL, XPRates.RAT_FOUND);
            }
        }while(r.nextInt() < m.getSearch());
        return res;
    }

    public static Colony findStuff(ArrayList<Member> m){

        //rat,unc,wep,mem
        int[] finds = new int[4];

        m.parallelStream().map(e -> find(e)).forEach(e -> e.parallelStream().forEach(b -> finds[b]++));

        return new Colony(finds[0],finds[1],finds[2],finds[3]);

    }

}
