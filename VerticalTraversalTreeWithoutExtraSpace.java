package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree */
 
 // class TreeNode2 { int val; TreeNode2 left; TreeNode2
 // right; TreeNode2(int x) { val = x; } } 
 


public class VerticalTraversalTreeWithoutExtraSpace {


	static void findMinMax(TreeNode2 node, int hd, NewPair p) {

		if (node == null)
			return;

		if (hd < p.min)
			p.min = hd;
		if (hd > p.max)
			p.max = hd;

		findMinMax(node.left, hd - 1, p);
		findMinMax(node.right, hd + 1, p);

	}
	
	public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode2 node) {
		
		NewPair p = new NewPair();

		findMinMax(node, 0, p);
		
		ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
		
		for(int i = p.min; i <= p.max; i++ ) {

		Queue<QueueNode> q = new LinkedList<QueueNode>();
		q.add(new QueueNode(node, 0));
		ArrayList<Integer> a = new ArrayList<Integer>();
		while (!q.isEmpty()) {

			QueueNode front = q.poll();
	 
			if(front.x == i) {
				a.add(front.node.val);
			}


			if (front != null && front.node != null && front.node.left != null) {

				q.add(new QueueNode((front.node).left, (front.x) - 1));
			}
			if (front != null && front.node != null && front.node.right != null) {

				q.add(new QueueNode((front.node).right, (front.x) + 1));
			}
		}
		rs.add(a);
		}
		
		for(ArrayList<Integer> al : rs) {
			for(Integer i : al)
				System.out.print(i + " ");
			System.out.println();
		}
		
		return rs;
	}
	
	public static void main(String[] args) {
		TreeNode2 root = new TreeNode2(6);
		root.left = new TreeNode2(3);
		root.left.left = new TreeNode2(2);
		root.left.right = new TreeNode2(5);
		
		root.right = new TreeNode2(7);
		root.right.left = new TreeNode2(8);
		root.right.right = new TreeNode2(9);
		
		
		
		
		verticalOrderTraversal(root);	
	}
}