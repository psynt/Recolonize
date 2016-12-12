package skillstest

import skills.Skill
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by nichita on 12.12.2016.
 */
class SkillSpec extends Specification {

    @Unroll
    def "Test gaining xp"(){
        given:
        def s = new Skill("Test",(int)init);

        when:
        s.gainXp(n)

        then:
        s.getXp() == exp

        where:
        init    |n    || exp
        0       |0    || 0
        1       |1    || 2
        1000    |1000 || 2000
        1e6     |1000 || 1e6
        (1e6)-3 |10   || 1e6
    }
}