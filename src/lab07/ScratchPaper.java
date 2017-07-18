package lab07;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScratchPaper {

	@Test
	public void simpleLinkedListTest() {
		BiNode one   = new BiNode(1);
		BiNode two   = new BiNode(2);
		BiNode three = new BiNode(3);
		one.right = two;
		two.right = three;
		three.right = one;
		
		assertTrue(BiNode.hasCycle(one));
	}
	
	@Test
	public void bigCycle(){
		
		BiNode one   = new BiNode(1);
		BiNode two   = new BiNode(2);
		BiNode three = new BiNode(3);
		BiNode four = new BiNode(4);
		BiNode five = new BiNode(5);
		one.right = two;
		one.left = four;
		two.right = three;
		three.right = one;
		three.left = five;
		
		assertTrue(BiNode.hasCycle(one));
		
	}
	
	@Test
	public void simpleBinaryTreeTest() {
		BiNode one   = new BiNode(1);
		BiNode two   = new BiNode(2);
		BiNode three = new BiNode(3);
		
		two.left = one;
		two.right = three;
		
		assertEquals("132", BiNode.postOrderTraversal(two));
	}
	
	@Test
	public void biggerTree() {
		BiNode one   = new BiNode(1);
		BiNode two   = new BiNode(2);
		BiNode three = new BiNode(3);
		BiNode four = new BiNode(4);
		two.left = one;
		two.right = three;
		three.right = four;
			
		assertEquals("1432", BiNode.postOrderTraversal(two));
	}

}
