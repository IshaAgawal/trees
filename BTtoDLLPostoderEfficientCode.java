

/*Postorder conversion of a binary tree into Doubly linked list */

public class BTtoDLLPostoderEfficientCode {
	
	static TreeNode head = null;   // For storing head of the double link list
	static TreeNode prev = null; // initially previous pointer is null

	static TreeNode bTtoDLLUtil(TreeNode root) {

		if (root == null)
			return null;

		bTtoDLLUtil(root.left); // Left child will be after null
		bTtoDLLUtil(root.right);
		
		if (prev != null)
			prev.right = root;

		root.left = prev;
		root.right = null;
		
		prev = root;
		
		return prev;
	}

	static TreeNode bTtoDLLEfficient(TreeNode root) {
		root = bTtoDLLUtil(root);
		while(root.left != null)
			root = root.left;
		return root;
	}

	static void printConvertedTree(TreeNode node) {
		int i = 1;
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
		root.right.left.right = new TreeNode(11);
		root.right.right = new TreeNode(15);
		root.right.right.right = new TreeNode(16);  // check this case

		TreeNode convertedNode = bTtoDLLEfficient(root);

		printConvertedTree(convertedNode);
	}

	

}
