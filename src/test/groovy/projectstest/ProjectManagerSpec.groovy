package projectstest

import projects.Project
import projects.ProjectManager
import spock.lang.Specification
import spock.lang.Unroll

import static projects.Project.HOB_T
import static projects.Project.TUR_T
/**
 * Created by nichita on 04/01/17.
 */
class ProjectManagerSpec extends Specification {
    def "test create"() {
        given:
        def x=new ProjectManager()

        when:
        3.times {
            x.create("Tur")
        }
        3.times {
            x.create("Hob")
        }
        x.create("Pantof")

        then:
        x.numProjects() == 6
    }

    @Unroll
    def "test numProjects"() {
        given:
        def x=new ProjectManager()

        when:
        n.times{
            x.create("Tur")
        }

        then:
        x.numProjects() == n

        where:
        n << [1,100,10,0,3,42]
    }

    def "test lucru"() {
        given:
        def x=new ProjectManager()

        when:
        3.times {
            x.create("Tur")
        }
        3.times {
            x.create("Hob")
        }
        x.lucru(3*TUR_T + 3*HOB_T)

        then:
        x.numProjects() == 0

    }

    def "test clean"(){
        given:
        Project pr = Mock()
        def x=new ProjectManager()

        when:
        x.projects.add(pr)
        x.lucru(42)

        then:
        x.numProjects() == 0
        1 * pr.advance(_)
        _ * pr.getBuildLeft()


    }

}
