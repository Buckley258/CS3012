
public class LCA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode<Integer,Integer> tree = new TreeNode<Integer,Integer>();
		String result =tree.printTree();
		System.out.println(result);
		tree.insert(10, 10);
		result =tree.printTree();
		System.out.println(result);
		tree.insert(5, 5);
		tree.insert(15, 15);
		tree.insert(4, 4);
		tree.insert(2, 2);
		//tree.insert(12, 12);
		//tree.insert(20, 20);
	    result =tree.printTree();
		System.out.println(result);
		
	}

}
