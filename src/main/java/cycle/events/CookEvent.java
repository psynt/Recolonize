package cycle.events;

import application.Functions;
import entities.Member;
import skills.XPRates;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nichita on 03.12.2016.
 */
public class CookEvent extends Event {
    public CookEvent(){
        super(Probabilities.Certain);
    }

    private static final String SKILL = "cook";

    private static int humanCook(Member m){
        int res=0;
        int cap = 10 + (m.getCook() / 10);
        Random r = new Random();
        do{
            res++;
            m.addXp(SKILL, XPRates.FOOD_COOKED);
        }while(res <= cap&& r.nextInt(100) < m.getCook());
        return res;
    }

    /**
     * cooks food
     * @param chefs people that do the cooking
     * @param avail amount of available food
     * @return amount of unc that was converted
     */
    public static int cook(ArrayList<Member> chefs, int avail){
        return Functions.min(avail, chefs.parallelStream().map(e -> humanCook(e)).reduce(0 ,(a, b) -> a+b));
    }

}
