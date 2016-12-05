package skillstest

import skills.MemberSkills
import skills.MemberSkillsFactory
import spock.lang.Specification

import static application.Constants.NUM_SKILLS

class MemberSkillsSpec extends Specification {

	def "Test number of skills"(){
		given:
		MemberSkills ms = MemberSkillsFactory.create(10);
		
		expect:
		ms.getSkillNum() == NUM_SKILLS;
	}

}
