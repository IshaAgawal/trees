
/*Inorder conversion of a binary tree into Doubly linked list */
public class BTtoDLLInorderEfficientCode {

	static TreeNode head = null;   // For storing head of the double link list
	static TreeNode prev = null; // initially previous pointer is null

	static TreeNode bTtoDLLUtil(TreeNode root) {

		if (root == null)
			return null;

		bTtoDLLUtil(root.left); // Left child will be after null
		
		if(prev == null)
			head = root; // This is going to be the head of the double linklist

		if (prev != null)
			prev.right = root;

		root.left = prev;
		prev = root;
		
		bTtoDLLUtil(root.right);
		
		return prev;
	}

	static TreeNode bTtoDLLEfficient(TreeNode root) {
		bTtoDLLUtil(root);
		return head;
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
		root.right.right.right = new TreeNode(16);

		TreeNode convertedNode = bTtoDLLEfficient(root);

		printConvertedTree(convertedNode);
	}
}
