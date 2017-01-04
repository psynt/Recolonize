package cycle.events;

import cycle.Colony;
import entities.Member;
import skills.XPRates;

import java.util.ArrayList;
import java.util.Random;

import static application.Constants.*;

/**
 * Created by nichita on 03.12.2016.
 */
public class SearchEvent extends Event{
    public SearchEvent(){
        super(Probabilities.Certain);
    }

    private static final String SKILL = "search";

    private static int[] find(Member m){
        int[] res = new int[POS_FINDS];
        Random r = new Random();
        int rv;
        do{
            //add possibility to find an enemy and roll your fight against his.
            rv = r.nextInt(100);
            if(rv<4) {  //survivor
                res[3]++;
                m.addXp(SKILL, XPRates.SURV_FOUND);
            }else
            if (rv<7){ //weapon
                res[2]++;
                m.addXp(SKILL, XPRates.WEP_FOUND);
            }else
            if (rv<45){ //unc
                res[1]++;
                m.addXp(SKILL, XPRates.UNC_FOUND);
            }else
            if (rv<55){ //food
                res[0]++;
                m.addXp(SKILL, XPRates.RAT_FOUND);
            }
        }while(r.nextInt(100) < m.getSearch());
        return res;
    }

    public static Colony findStuff(ArrayList<Member> m){

        //rat,unc,wep,mem
        int[] finds = m.parallelStream().map(e -> find(e)).reduce(identity.apply(POS_FINDS),(a,b) -> addArrays.apply(a,b));

        return new Colony(finds[0],finds[1],finds[2],finds[3]);

    }

}
