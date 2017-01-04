package projectstest

import projects.AutoHob
import spock.lang.Specification
import spock.lang.Unroll

import static projects.Project.*
/**
 * Created by nichita on 04/01/17.
 */
class AutoHobSpec extends Specification {
    def "test getScCost"() {
        given:
        def i = new AutoHob();

        expect:
        i.scrap == HOB_SC
        i.weapons == HOB_WEP
        i.time == HOB_T
        i.buildLeft == HOB_T
    }

    @Unroll
    def "test advance"() {
        given:
        def i = new AutoHob();

        when:
        i.advance(n)

        then:
        i.buildLeft == HOB_T - n
        Finished.test(i) == (boolean)val

        where:
        n       |   val
        1       |   0
        HOB_T   |   1
        0       |   0
        TUR_T   |   1
    }
}
