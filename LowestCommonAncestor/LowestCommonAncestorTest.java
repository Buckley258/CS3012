import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {

	@Test
	public void printTreeTest() {
		
		//test empty tree
		TreeNode<Integer, Integer> tree = new TreeNode<Integer, Integer>();
		assertEquals( "()", tree.printTree());
		//test 1 node tree
		tree.insert(10, 10);
		assertEquals( "(()10())", tree.printTree());
		//test normal tree
		tree.insert(5, 5);
		tree.insert(15, 15);
		tree.insert(4, 4);
		tree.insert(2, 2);
		assertEquals( "((((()2())4())5())10(()15()))", tree.printTree());
		
		
	}
	
	@Test
	public void deleteTest() {
		
		TreeNode<Integer,Integer> tree = new TreeNode<Integer,Integer>();
		//empty treenode
		tree.delete(10);
		assertEquals("()",tree.printTree());
		tree.insert(10, 10);
		tree.insert(8, 8);
		tree.insert(15,15);
		tree.insert(9,9);
		tree.insert(5,5);
		tree.insert(20,20);
		tree.insert(2,2);
		tree.insert(6,6);
		tree.insert(12, 12);
		//delete a leaf from the tree
		tree.delete(20);
		assertEquals("((((()2())5(()6()))8(()9()))10((()12())15()))",tree.printTree());
		//delete leaf not in tree
		tree.delete(21);
		assertEquals("((((()2())5(()6()))8(()9()))10((()12())15()))",tree.printTree());
		//delete leaf with a left node
		tree.delete(15);
		assertEquals("((((()2())5(()6()))8(()9()))10(()12()))",tree.printTree());
		//delete leaf with a right node
		tree.delete(6);
		assertEquals("((((()2())5())8(()9()))10(()12()))",tree.printTree());
		
		
	}
	
	
	


}
