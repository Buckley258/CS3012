
public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int lca(TreeNode a, int val1, int val2) {
	        
	        a = findLCA(a, val1, val2);
	        if(a == null)
	            return -1;
	        return a.val;
	        
	    }

	    public TreeNode findLCA(TreeNode node, int val1, int val2){
	        if( node == null)
	            return null;
	        if(node.val == val1 || node.val == val2)
	            return node;
	        
	        TreeNode leftLCA = findLCA(node.left, val1, val2);
	        TreeNode rightLCA = findLCA(node.right, val1, val2);
	        
	        if(leftLCA != null && rightLCA != null)
	            return node;
	        
	        return (leftLCA != null)? leftLCA: rightLCA;
	          
	    }

}
