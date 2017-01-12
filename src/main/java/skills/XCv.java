package skills;

import org.jetbrains.annotations.Contract;

/**
 * Created by nichita on 12/01/17.
 */
public class XCv {

    private static class Thou implements XpCurve {
        @Override
        public int getLevel(int xp) {
            return xp/1000;
        }

        @Override
        public int xpForLevel(int level) {
            return level*1000;
        }
    }

    private static class Cube implements XpCurve {
        @Override
        public int getLevel(int xp) {
            return (int)Math.cbrt(xp);
        }

        @Override
        public int xpForLevel(int level) {
            return level * level * level;
        }
    }

    // the factory method
    @Contract(" -> !null")
    public static XpCurve apply(){
        return new Cube();

    }
}
