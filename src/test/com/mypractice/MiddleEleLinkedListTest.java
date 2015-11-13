package test.com.mypractice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mypractice.MiddleEleLinkedList;

public class MiddleEleLinkedListTest {

	
	 MiddleEleLinkedList list;
	
	@Before 
    public void setup() throws Exception{
    	
    	list = new MiddleEleLinkedList();
    	list.addListValues(new String[] {"a","b","c"});	
    }
	
	
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testFindMiddleValueOnList() {
		assertEquals("b", list.findMiddleValueOnList());
		list.addListValue("d");
		assertEquals("c", list.findMiddleValueOnList());
		assertEquals("a", list.removeString());
		assertEquals("c", list.findMiddleValueOnList());
		assertEquals("b", list.removeString());
		assertEquals("c", list.removeString());
		assertEquals("d", list.findMiddleValueOnList());
		assertEquals("d", list.removeString());
		assertEquals("a", list.findMiddleValueOnList());
	}
	

}
