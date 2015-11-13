package test.com.mypractice;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mypractice.LinkedList;

public class LinkedListTest  {

	static LinkedList list; 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		list = new LinkedList();
	}

	@Test
	public void getHeadTailTest(){
		assertEquals(null, list.getHead());
		assertEquals(null, list.getTail());
	}
	
	@Test
	public void testAddNode() {
	    list.addNode("data1");
	    assertEquals("data1", list.getHead().getData());
	    list.addNode("data2");
	    //assertEquals(null, list.removeNode("data1"));
	}

	
	@Test
	public void testRemoveNode() {
		
	}

}
