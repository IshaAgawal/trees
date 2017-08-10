package manish;

import java.util.ArrayList;



public class XYNode {
	
	static ArrayList<TreeNode> result = new ArrayList<TreeNode>();
	
	static void printXY(TreeNode root, int x, int y, int x1, int y1) {  // x,y -> root coordinates
																			// x1, y1 -> coordinates to find
	
		if(root == null)
			return;
		
		
		printXY(root.left,x-1,y+1,x1,y1);  // visiting the left child
		
	  
		if(x == x1 && y == y1) {
			result.add(root);
			
		}
		printXY(root.right,x+1,y+1,x1,y1);  // visiting the right child
		
	}
	
	
	
public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(9);
		
		root.right = new TreeNode(14);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(15);
		
		printXY(root,0,0,0,2);
		
		for(TreeNode i : result) {
			System.out.println(i.val);
		}
		
	}

}
