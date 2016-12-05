package entitiestest;

import static entities.MemberFactory.*
import static org.junit.Assert.*

import collections.NameDispenser
import spock.lang.Specification
import spock.lang.Unroll

class MemberFactorySpec extends Specification {
	
	@Unroll
	def "test gimmie #n"() {
		
		expect:
		gimmie(n).size == n;
		
		where:
		n << [0,1,100,10];
		
	}

}
