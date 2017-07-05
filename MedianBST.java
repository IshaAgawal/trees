import java.util.Stack;

/* Finding median in a BST
 * Two possible cases -> 
 * a) number of elements in BST is odd then return the middle element
 * b) number of elements in BST is even then return (mid1 + mid2)/2 
 *  */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	boolean visited = false;

	public TreeNode(int val) {

		this.val = val;
		this.visited = false;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right
				+ "]";
	}
}

public class MedianBST {

	static Stack<TreeNode> stack1 = new Stack<TreeNode>();
	static Stack<TreeNode> stack2 = new Stack<TreeNode>();

	static TreeNode curr1 = null;
	static TreeNode curr2 = null;

	static TreeNode ans1, ans2;

	private static int numOfElements(TreeNode root) { // Counting number of
														// elements in BST

		if (root == null)
			return 0;

		return 1 + numOfElements(root.left) + numOfElements(root.right);

	}

	static TreeNode inorder() { // returns elements one by one which will occur
								// in an inorder
		if (curr1 != null) {
			stack1.push(curr1);
			curr1 = curr1.left;
			inorder();
		} else if (!stack1.isEmpty()) {
			curr1 = stack1.pop();
			ans1 = curr1;
			curr1 = curr1.right;
		}
		return ans1;
	}

	static TreeNode reverseInorder() {

		if (curr2 != null) {
			stack2.push(curr2);
			curr2 = curr2.right;
			reverseInorder();
		} else {
			curr2 = stack2.pop();
			ans2 = curr2;
			curr2 = curr2.left;
		}
		return ans2;
	}

	private static void median(TreeNode root, int n) {

		curr1 = root;
		curr2 = root;

		TreeNode s1 = inorder(), s2 = reverseInorder();

		while (n > 0) {

			s1 = inorder();
			s2 = reverseInorder();
			n--;
		}
		System.out.println("Median is " + (s1.val + s2.val) / 2);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(9);

		root.right = new TreeNode(14);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(15);

		int n1 = numOfElements(root);

		median(root, (int) Math.ceil(n1 / 2)); // median for ODD number of
												// elements in the BST

		TreeNode root2 = new TreeNode(10);
		root2.left = new TreeNode(8);
		root2.left.left = new TreeNode(7);

		root2.right = new TreeNode(14);
		root2.right.left = new TreeNode(13);
		root2.right.right = new TreeNode(15);

		int n2 = numOfElements(root2);
		System.out.println((int) Math.ceil(n2 / 2));
		median(root2, (int) Math.ceil(n2 / 2)); // median for EVEN number of
												// elements in the BST

	}
}
