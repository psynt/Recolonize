package cycle.events;

import application.Constants;
import application.Functions;
import entities.Member;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nichita on 03.12.2016.
 */
public class CookEvent extends Event {
    public CookEvent(){
        super(Probabilities.Certain);
    }


    private int humanCook(Member m){
        int res=0;
        int cap = 10 + (m.getCook() / 10);
        Random r = new Random();
        do{
            res++;
        }while(res <= cap&& r.nextInt() < m.getCook());
        return res;
    }

    /**
     * cooks food
     * @param chefs people that do the cooking
     * @param avail amount of available food
     * @return amount of food cooked by chefs
     */
    public int cook(ArrayList<Member> chefs, int avail){
        return Constants.UNC_RAT * Functions.min(avail, chefs.parallelStream().map(e -> humanCook(e)).reduce(0 ,(a, b) -> a+b));
    }

}