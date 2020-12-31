import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FamilyHirarchyTest {
	
	/*
	 * Requirement: The given string has pipe delimited nodes that represent family
	 * members in a family tree. Each node is a CSV with the values being
	 * &quot;parent_id, node_id, node_name&quot;. Write a method that takes an input
	 * string and return a single result that represents the data as a hierarchy
	 * (root, children, siblings, etc). Sample input:
	 * &quot;null,0,grandpa|0,1,son|0,2,daughter|1,3,grandkid|1,4,grandkid|2,5,
	 * grandkid|5,6,greatgrandkid&quot; • Solve it in any language that you prefer •
	 * Display the hierarchical result any way you prefer (as long as the
	 * parent/child connections are clear)
	 */
	@Test
	void nullStringReturnsException() {
		try {
			FamilyHirarchy.getHirarchy(null);
		} catch(Exception e) {
			assertEquals(null, e.getMessage());
		}
	}
	
	@Test
	void emptyStringReturnsNoForHirarchy() throws Exception {
		assertEquals("No", FamilyHirarchy.getHirarchy(""));
	}
	
	@Test
	void stringWithNoHirarchyReturnsRoot() throws Exception {
		assertEquals("|grandpa|", FamilyHirarchy.getHirarchy("null,0,grandpa"));
	}
	
	@Test
	void stringWith2ndHirarchyReturn2LevelHirarchy() throws Exception {
		assertEquals("|grandpa|" + "\n"
				+"|son"+"|daughter|", 
				FamilyHirarchy.getHirarchy("null,0,grandpa|0,1,son|0,2,daughter"));
	}
	
	@Test
	void stringWith3rdHirarchyReturn3LevelHirarchy() throws Exception {
		assertEquals("|grandpa|" + "\n"
				+"|son|daughter|" + "\n" 
				+ "|grandkid|grandkid|", 
				FamilyHirarchy.getHirarchy("null,0,grandpa|0,1,son|0,2,daughter|1,3,grandkid|1,4,grandkid"));
	}

	@Test
	void stringWithAnyHirarchyReturnHirarchy() throws Exception {
		assertEquals("|grandpa|" + "\n"
				+"|son|daughter|" + "\n" 
				+ "|grandkid|grandkid|grandkid|" +"\n"
				+ "|-|-|greatgrandkid|",
				FamilyHirarchy.getHirarchy(
				"null,0,grandpa|0,1,son|0,2,daughter|1,3,grandkid|1,4,grandkid|2,5," + 
						"grandkid|5,6,greatgrandkid"));
	}
}
