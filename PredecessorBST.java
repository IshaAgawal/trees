
public class PredecessorBST {
	
	static TreeNode predecessor(TreeNode root, TreeNode node) {
		
	if(node.left != null) {
		TreeNode left = node.left;
		
		while(left != null && left.right != null) {
			left = left.right;
		}
		return left;
	}
		
	else {		
		TreeNode current = root; TreeNode parent = null;   // o(n) time
		
		while(current != node) {
			
		if(node.val > current.val) {
			parent = current;		
			current = current.right;
		}
		else {
			current = current.left;
		}
	}	
		return parent;
   }
}
	static TreeNode find(TreeNode root, int data) {   // o(n) time , comparing with each node of the tree
		
		if(root == null)
			return null;
		
		if(root.val == data)
			return root;
		
		if(root.val < data) 
			return find(root.right,data);
		else	
		return find(root.left, data);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(45);
		root.left.left = new TreeNode(30);
		root.left.right = new TreeNode(49);
		root.right = new TreeNode(70);
		root.right.left = new TreeNode(60);
		root.right.left.right = new TreeNode(65);
		root.right.right = new TreeNode(80);
		root.right.right.right = new TreeNode(90);
		
		TreeNode node = find(root, 90);
		
		TreeNode preNode = predecessor(root,node);
		
		System.out.println(preNode.val);
		
	}
}
