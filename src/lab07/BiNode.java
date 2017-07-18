package lab07;

/**
 * 
 * @author Chloe Josien I will not discuss this code until Tuesday, March 7th.
 *
 */
public class BiNode {
	BiNode right;
	BiNode left;
	int data;

	// An explicit default constructor
	public BiNode() {
	}

	// A convenience constructor to construct a node with certain data
	public BiNode(int data) {
		this.data = data;
	}

	/**
	 * Given the head of a doubly linked list, find out whether or not the list
	 * contains a cycle.
	 * 
	 * A list is constructed by linking the right fields. Don't bother with
	 * traversing backwards using 'left'.
	 * 
	 * @param head
	 *            - Head of the linked list
	 * @return whether or not the list has a cycle in it. 1 -> 2 -> 3 -> NULL
	 *         returns false
	 * 
	 *         1 -> 2 -> 3 returns true ^---------'
	 */
	public static boolean hasCycle(BiNode head) {
		BiNode fast = head.right;
		BiNode slow = head;

		while (fast.right != null) {
			fast = fast.right;
			if (fast.equals(slow)) {
				return true;
			}
			fast = fast.right;
			slow = slow.right;
		}
		return false;
	}

	/**
	 * What's this? The BiNode works in a Binary Tree as well! Given the root
	 * node of a Binary Tree, can you print return a String comprised of the
	 * tree's data in post order? C / \ A T
	 * 
	 * @return A string representation of an POST ORDER traversal. The example
	 *         string would return "ATC". An empty tree returns an empty string.
	 */
	public static String postOrderTraversal(BiNode root) {
		String tree ="";
		
		tree = helper(root, tree);
		
		return tree;
	}

	public static String helper(BiNode root, String tree){
		
		if(root==null){
			return tree;
		}
		else{
			tree = helper(root.left,tree);
			
			tree= helper(root.right, tree);
		}
		tree += root.data;
		return tree;
	}
	
	@Override
	public String toString() {
		return String.valueOf(data);
	}
}