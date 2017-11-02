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
		tree.insert(3,3);
		tree.delete(3);
		assertEquals("((((()2())5())8(()9()))10(()12()))", tree.printTree());
		tree.insert(3, null);
		tree.delete(3);
		assertEquals("((((()2())5())8(()9()))10(()12()))", tree.printTree());
		tree.delete(2);
		tree.insert(2, null);
		tree.insert(3, null);
		tree.delete(5);
		tree.insert(null, null);
		assertEquals("((()8(()9()))10(()12()))", tree.printTree());
		//delete node that has a duplicate
		tree.insert(4, 4);
		tree.insert(4, 4);
		tree.insert(5, 5);
		tree.insert(3, 3);
		tree.delete(4);
		assertEquals("(((()3(()5()))8(()9()))10(()12()))", tree.printTree());
		
		
		
		
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
	
  
 DAG
	@Test
	public void DAG_LCA_test(){
		
		TreeNode<Integer,Integer> treeGraph = new TreeNode<Integer,Integer>();
		//test on an empty treenode
		assertNull(treeGraph.lowestCommonAncestor(20, 10));
		
		treeGraph.insert(20, 20);
		//test correct nodes on single tree/graph
		assertEquals(20,(int)treeGraph.lowestCommonAncestor(20, 20));
		//test no correct nodes on single node tree/graph
		assertNull(treeGraph.lowestCommonAncestor(15, 25));
		//test 1 correct node on single node tree/graph
		assertNull(treeGraph.lowestCommonAncestor(20, 15));
		
		treeGraph.insert(16, 16);
		treeGraph.insert(17, 17);
		treeGraph.insert(19, 19);
		treeGraph.insert(13, 13);
		treeGraph.insert(15, 15);
		treeGraph.insert(11, 11);
		treeGraph.insert(25, 25);
		treeGraph.insert(30, 30);
		
		//multiple tests on normal many node treeGraph
		assertEquals(16, (int)treeGraph.lowestCommonAncestor(11, 19));
		assertEquals(3, (int)treeGraph.lowestCommonAncestor(11, 15));
		assertEquals(20, (int)treeGraph.lowestCommonAncestor(30, 19));
		assertEquals(20, (int)treeGraph.lowestCommonAncestor(15, 30));
		assertEquals(20, (int)treeGraph.lowestCommonAncestor(16, 15));
		//if one of the nodes is the root, return root
		assertEquals(20, (int)treeGraph.lowestCommonAncestor(20, 19));
		
	}

	


}
