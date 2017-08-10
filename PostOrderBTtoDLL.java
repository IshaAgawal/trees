

public class PostOrderBTtoDLL {
	
	static TreeNode postOrderBTtoDLLUtil(TreeNode root) {
		
		if(root == null)
			return null;
		
		TreeNode left = postOrderBTtoDLLUtil(root.left);
		
		TreeNode right = postOrderBTtoDLLUtil(root.right);
		
	    while(left != null && left.left != null)
	    	left = left.left;
	    
	    while(right != null && right.left != null)
	    	right = right.left; 
	    
	    if(left != null){
	    left.right = right;
	    left.left = null;
	    }
	    
	    if(right != null) {
	    right.left = left; 
	    right.right = root;
	    }
	    root.left = right;  
	    root.right = null;
	    return root;
	}
	
	static TreeNode postOrderBTtoDLL(TreeNode root) {
		
		root = postOrderBTtoDLLUtil(root);
		
		while(root != null && root.left != null)
			root = root.left;
		
		return root;
	}
	
	static void printConvertedTree(TreeNode node) {
		while (node != null) {
			System.out.println(node.val + " ");
			node = node.right;
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(9);

		root.right = new TreeNode(14);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(15);

		TreeNode convertedNode = postOrderBTtoDLL(root);

		printConvertedTree(convertedNode);
	}

}
