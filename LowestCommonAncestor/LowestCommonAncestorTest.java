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
		
		
		
	}
	
	
	


}
