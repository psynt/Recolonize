package eventstest

import cycle.Colony
import cycle.events.SearchEvent
import entities.MemberFactory
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll


/**
 * Created by nichita on 03.12.2016.
 */
class SearchEventSpec extends Specification {

    @Unroll("Search party size #n")
    def "test find stuff"(){
        given:
        @Subject
        SearchEvent e = new SearchEvent();

        when:
        Colony c = e.findStuff(MemberFactory.gimmie(n));

        then:
        def z = c.members.size() + c.rations + c.uncooked + c.weapons
        z >= n

        where:
        n << [100,10,0,1]
    }


}