package projects;

/**
 * Created by nichita on 04/01/17.
 */
public class Turret implements Project {

    private int progress = 0;

    @Override
    public String getName() {
        return "Turret";
    }

    @Override
    public int getScrap() {
        return TUR_SC;
    }

    @Override
    public int getWeapons() {
        return TUR_WEP;
    }

    @Override
    public int getTime() {
        return TUR_T;
    }

    @Override
    public int getBuildLeft() {
        return TUR_T-progress;
    }

    @Override
    public void advance(int amount) {
        progress+=amount;
    }
}
