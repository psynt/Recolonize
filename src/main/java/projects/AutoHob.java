package projects;

/**
 * Created by nichita on 04/01/17.
 */
public class AutoHob implements Project {
    private int progress=0;

    @Override
    public String getName() {
        return "CookBot";
    }

    @Override
    public int getScrap() {
        return HOB_SC;
    }

    @Override
    public int getWeapons() {
        return HOB_WEP;
    }

    @Override
    public int getTime() {
        return HOB_T;
    }

    @Override
    public int getBuildLeft() {
        return HOB_T-progress;
    }

    @Override
    public void advance(int amount) {
        progress+=amount;
    }

}
