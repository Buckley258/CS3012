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
	
	@Test
	public void getTest() {
		
		TreeNode<Integer,Integer> tree = new TreeNode<Integer,Integer>();
		//empty treenode
		assertNull(tree.get(10));
		tree.insert(10, 10);
		tree.insert(5, 5);
		tree.insert(20, 20);
		tree.insert(15, 15);
		tree.insert(2, 2);
		//test for leaf in treenode
		assertEquals(5,(int)tree.get(5));
		//test for leaf not in treenode
		assertNull(tree.get(7));
		
		
	}
	
	@Test
	public void LCA_test() {
		
		TreeNode<Integer,Integer> tree = new TreeNode<Integer,Integer>();
		//test on an empty treenode
		assertNull(tree.lowestCommonAncestor(10, 15));
		
		tree.insert(10, 10);
		//test correct nodes on single tree
		assertEquals(10,(int)tree.lowestCommonAncestor(10, 10));
		//test no correct nodes on single node tree
		assertNull(tree.lowestCommonAncestor(15, 20));
		//test 1 correct node on single node tree
		assertNull(tree.lowestCommonAncestor(10, 15));
		
		tree.insert(6, 6);
		tree.insert(7, 7);
		tree.insert(9, 9);
		tree.insert(3, 3);
		tree.insert(5, 5);
		tree.insert(1, 1);
		tree.insert(15, 15);
		tree.insert(20, 20);
		
		//multiple tests on normal many node tree
		assertEquals(6, (int)tree.lowestCommonAncestor(1, 9));
		assertEquals(3, (int)tree.lowestCommonAncestor(1, 5));
		assertEquals(10, (int)tree.lowestCommonAncestor(20, 9));
		assertEquals(10, (int)tree.lowestCommonAncestor(5, 20));
		assertEquals(10, (int)tree.lowestCommonAncestor(6, 15));
		//if one of the nodes is the root, return root
		assertEquals(10, (int)tree.lowestCommonAncestor(10, 9));
		
		
	}
	
	


}
