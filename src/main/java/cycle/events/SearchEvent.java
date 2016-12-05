package cycle.events;

import cycle.Colony;
import entities.Member;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nichita on 03.12.2016.
 */
public class SearchEvent extends Event{
    public SearchEvent(){
        super(Probabilities.Certain);
    }

    private static ArrayList<Byte> find(Member m){
        ArrayList<Byte> res = new ArrayList<>();
        Random r = new Random();
        int rv;
        do{
            rv = r.nextInt(100);
            if(rv<2) {
                res.add((byte)3);
            }else
            if (rv<40){
                res.add((byte)2);
            }else
            if (rv<70){
                res.add((byte)1);
            }else
            if (rv<95){
                res.add((byte)0);
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
