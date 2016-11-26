package skillstest;

import static org.junit.Assert.*
import static application.Constants.*

import org.junit.Test
import skills.MemberSkills
import skills.MemberSkillsFactory
import spock.lang.Specification

class MemberSkillsSpec extends Specification {

	def "Test number of skills"(){
		given:
		MemberSkills ms = MemberSkillsFactory.create(10);
		
		expect:
		ms.getSkillNum() == NUM_SKILLS;
	}

}
