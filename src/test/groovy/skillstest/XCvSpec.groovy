package skillstest

import skills.XCv
import skills.XpCurve
import spock.lang.Specification
import spock.lang.Unroll


/**
 * Created by nichita on 12.12.2016.
 */
class XCvSpec extends Specification {

    @Unroll
    def "Cube: Test xp -> level"(){
        given:
        XpCurve xpc=XCv.apply();

        expect:
        xpc.getLevel(n*n*n) == n

        where:
        n << [1,1000,10,42]

    }

    @Unroll
    def "Cube: Test level -> xp"(){
        given:
        XpCurve xpc=XCv.apply();

        expect:
        xpc.xpForLevel(n) == n*n*n

        where:
        n << [1,1000,10,42]

    }
}