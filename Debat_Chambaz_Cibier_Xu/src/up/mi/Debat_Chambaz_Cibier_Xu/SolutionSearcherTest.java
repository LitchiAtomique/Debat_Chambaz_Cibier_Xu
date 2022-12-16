package up.mi.Debat_Chambaz_Cibier_Xu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import up.mi.Debat_Chambaz_Cibier_Xu.SolutionSearcher;
class SolutionSearcherTest {

	@ParameterizedTest
	//@CsvFileSource(resources = "~/data/TestFile.txt", numLinesToSkip = 1)
	//@ValueSource(strings = "Helllo", "Hello2")
	@CsvSource({"Hello,1" ,"Hello2,2"})
	void testGetAdmissible(String first, int second) {
		assertEquals(second, 2);
		/*Solution[] res = SolutionSearcher.getAdmissible(debate);
		AssertEquals(excepteed, res);
		*/
		
		//fail("Not yet implemented");
	}

	@ParameterizedTest
	//@CsvFileSource(resources = "~/data/TestFile.txt", numLinesToSkip = 1)
	//@ValueSource(strings = "Helllo", "Hello2")
	@CsvSource({"Hello,1" ,"Hello2,2"})
	void testGetPreferred(String a, int s) {
		assertEquals(s, 2);
	}

}
