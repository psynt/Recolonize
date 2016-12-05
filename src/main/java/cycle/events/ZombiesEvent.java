package cycle.events;

import entities.Member;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nichita on 03.12.2016.
 */
public class ZombiesEvent extends Event {

    public ZombiesEvent(){
        super(Probabilities.Certain);
    }

    /**
     * Kills zombies in the name of m
     * @param m Member that is doing the killing
     * @return number of zombies deaded by Mr. m
     */
    private static int killZombies(Member m){
        int div = m.hasWeapon()?2:1;
        int res=0;
        int cap = 40 + (m.getFight() / 10);
        Random r = new Random();
        do{
            res++;
        }while(res <= cap&& r.nextInt()/div < m.getFight());
        return res;
    }

    /**
     * generates Zombiebiebiebies
     * @param day current day
     * @return number of zombies generated
     */
    public static int generateZombies(int day){
        int zombies = 3 + day/2 + (int)(Math.random()*day);
        return zombies;
    }

    /**
     *
     * @param zombies number of zombies to be killed
     * @param warriors array of members that take part in the massacre
     * @return number of zombies that survive the attack
     *  i.e.
     *      - <0 if colony survives
     *      - =0 if colony barely makes it
     *      - >0 if zombies break in
     */
    public static int killManyZombies(int zombies, ArrayList<Member> warriors){
        int zombiecasualties = warriors.parallelStream().map(e -> killZombies(e)).reduce(0,(a,b) -> a+b);
        return zombies - zombiecasualties;
    }

}
