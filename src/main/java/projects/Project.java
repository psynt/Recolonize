package projects;

import java.util.function.Predicate;

/**
 * Created by nichita on 04/01/17.
 */
public interface Project {

    //build times
    int HOB_T = 2;
    int TUR_T = 5;

    //build costs - SCRAP
    int HOB_SC = 5;
    int TUR_SC = 10;

    //build costs - WEAPONS
    int HOB_WEP = 0;
    int TUR_WEP = 1;

    String getName();
    int getScrap();
    int getWeapons();
    int getTime();
    int getBuildLeft();
    void advance(int amount);

    Predicate<Project> Finished = e -> e.getBuildLeft()<=0;

}
