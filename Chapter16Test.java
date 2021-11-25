import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import java.lang.*;
/**
 * JUnit Tests for Chapter 16
 */

public class Chapter16Test {

	/**
	 * Reset the base data structures just in case
	 */
	@BeforeEach 
	void reset(){
		return;
	}
	
	/**
	 * An empty JUnit test case
	 */
	@Test 
	public void testExample(){		
		assertTrue(true);
	}
	/**
	 * Test cases for push and pop
	 */
	@Test 
	public void pushPop() {
		LinkedIntList s = new LinkedIntList();
		assertEquals(0, s.size());
		s.push(1);
        assertEquals(1, s.size());
        s.push(2);
        assertEquals(2, s.size());
        assertEquals(2, s.pop());
        assertEquals(1, s.pop());
        assertEquals(0, s.size());
	}
	/**
	 * Test cases for the stutter method
	 */
	
	@Test 
	public void stut(){
	LinkedIntList list1 = new LinkedIntList();
	LinkedIntList list2 = new LinkedIntList();
	list1.add(1);
	list1.add(1);
	list1.add(2);
	list1.add(2);
	list1.add(3);
	list1.add(3);
	list2.add(1);
	list2.add(2);
	list2.add(3);
	list2.stutter();
	assertEquals(list1, list2);
	}
	/**
	 * Test cases for the double list method
	 */
	@Test 
	public void dublist(){
	LinkedIntList list3 = new LinkedIntList();
	LinkedIntList list4 = new LinkedIntList();	
	list3.add(1);
	list3.add(2);
	list3.add(3);
	list3.add(4);
	list3.add(1);
	list3.add(2);
	list3.add(3);
	list3.add(4);
	list4.add(1);
	list4.add(2);
	list4.add(3);
	list4.add(4);
	list4.doubleList();
	assertEquals(list3, list4);
	}
	/**
	 * Test cases for the equals method
	 */
	@Test
	public void eq(){
	LinkedIntList list5 = new LinkedIntList();
	LinkedIntList list6 = new LinkedIntList();	
	list5.add(1);
	list5.add(2);
	list5.add(3);
	list5.add(4);
	list6.add(1);
	list6.add(2);
	list6.add(3);
	list6.add(4);
	assertTrue(list5.equals(list6));
	list6.add(5);
	assertFalse(list5.equals(list6));
	}

}
	
	
