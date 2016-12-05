package skillstest

import skills.MemberSkillsFactory
import skills.Skill
import spock.lang.Specification

import static application.Constants.NUM_SKILLS

class MemberSkillsSpec extends Specification {

	def "Test number of skills"(){
		given:
		HashMap<String,Skill> ms = MemberSkillsFactory.create(10);
		
		expect:
		ms.size() == NUM_SKILLS;
	}

}
