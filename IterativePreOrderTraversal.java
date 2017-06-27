package manish;

import java.util.Stack;

/* Pre Order traversal using stack */

public class IterativePreOrderTraversal {
	
	
	static void printPreOrder(TreeNode root) {
		
		Stack<TreeNode> s = new Stack<TreeNode>() ;
		
		s.add(root);
		
		while(!s.isEmpty()) {
			
			System.out.println(s.peek().val + " ");
			
			TreeNode node = s.pop();
			
			if(node.right != null){
				s.add(node.right);
			}
			
			if(node.left != null){
				s.add(node.left);
			}
			
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
		
		printPreOrder(root);
	}

}
