package projectstest

import projects.Turret
import spock.lang.Specification
import spock.lang.Unroll

import static projects.Project.*

/**
 * Created by nichita on 04/01/17.
 */
class TurretSpec extends Specification {

    def "test getScCost"() {
        given:
        def i = new Turret();

        expect:
        i.scrap == TUR_SC
        i.weapons == TUR_WEP
        i.time == TUR_T
        i.buildLeft == TUR_T
    }

    @Unroll
    def "test advance"() {
        given:
        def i = new Turret();

        when:
        i.advance(n)

        then:
        i.buildLeft == TUR_T - n
        Finished.test(i) == (boolean)val

        where:
        n       |   val
        1       |   0
        2       |   0
        0       |   0
        TUR_T   |   1
    }

}
