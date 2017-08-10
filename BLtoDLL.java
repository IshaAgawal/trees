public class BLtoDLL {

	static TreeNode bTtoDLLUtil(TreeNode root) {

		if (root == null)
			return null;

		TreeNode left = bTtoDLLUtil(root.left);  // converting left subtree to DLL

		while (left != null && left.right != null)  // finding the right most node of DLL formed
		left = left.right;

		if (left != null)
			left.right = root;

		root.left = left;

		TreeNode right = bTtoDLLUtil(root.right);

		while (right != null && right.left != null)
		right = right.left;

		if (right != null)
			right.left = root;

		root.right = right;

		return root;

	}

	static TreeNode bTtoDLL(TreeNode root) {
		
		root = bTtoDLLUtil(root);
		
		while(root.left != null)
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
		root.right.left.right = new TreeNode(16);

		TreeNode convertedNode = bTtoDLL(root);

		printConvertedTree(convertedNode);
	}
}
