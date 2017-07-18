package lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DiffUtilTest {
	
	int[] smallArray;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		
	}
	
	@Before
	public void setUp() throws Exception{
		smallArray = new int[]{5,6,12};
		
	}
	
	@After
	public void tearDown() throws Exception{
		
	}

	@Test
	public void testFindSmallestDiff() {
		smallArray[0]=4;
		assertEquals(2, DiffUtil.findSmallestDiff(new int[]{7,20,4,2}));
	}
	
	 @Test(expected=NullPointerException.class)
	 public void check_null_array_throws_exception()
	 {
	      DiffUtil.findSmallestDiff(null);
	 }

	 @Test
	 public void check_base_case_empty_array()
	 {
	      assertEquals(-1,DiffUtil.findSmallestDiff( new int[]{}));
	 }
	 

}
