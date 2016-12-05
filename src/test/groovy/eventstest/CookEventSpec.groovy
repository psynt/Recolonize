package eventstest

import cycle.events.CookEvent
import entities.MemberFactory
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll
/**
 * Created by nichita on 03.12.2016.
 */
class CookEventSpec extends Specification {

    @Unroll("#guys guys cooking #food food")
    def "test that cook doesnt cook more than the available amount of food"(){

        given:
        @Subject
        CookEvent e = new CookEvent();

        when:
        def z = CookEvent.cook(MemberFactory.gimmie(guys),food);

        then:
        z <= food;

        where:
        guys    ||  food
        0       ||  0
        1       ||  1
        100     ||  10
        10      ||  100

    }
}