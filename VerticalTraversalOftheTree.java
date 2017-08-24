/**
 * Definition for binary tree 
 */
  class TreeNode { int val; TreeNode left; TreeNode
  right; TreeNode(int x) { val = x; } }
 

class QueueNode {

	TreeNode node;
	int x;

	QueueNode(TreeNode node2, int x2) {
		this.node = node2;
		this.x = x2;
	}
}

class NewPair {
	int min, max;

	NewPair() {
		min = 0;
		max = 0;
	}
}

public class Solution {

	static void findMinMax(TreeNode node, int hd, NewPair p) {

		if (node == null)
			return;

		if (hd < p.min)
			p.min = hd;
		if (hd > p.max)
			p.max = hd;

		findMinMax(node.left, hd - 1, p);
		findMinMax(node.right, hd + 1, p);

	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode node) {

		Queue<QueueNode> q = new LinkedList<QueueNode>();

		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();

		q.add(new QueueNode(node, 0));

		while (!q.isEmpty()) {

			QueueNode front = q.poll();
			ArrayList<Integer> a = new ArrayList<Integer>();

			if (hm.get(front.x) == null) {

				if (front != null && front.node != null) {
					a.add((front.node).val);
					hm.put((front.x), a);
				}
			} else {
				a = hm.get(front.x);
				a.add((front.node).val);
				hm.put(front.x, a);
			}

			if (front != null && front.node != null && front.node.left != null) {

				q.add(new QueueNode((front.node).left, (front.x) - 1));
			}
			if (front != null && front.node != null && front.node.right != null) {

				q.add(new QueueNode((front.node).right, (front.x) + 1));
			}
		}
		NewPair p = new NewPair();

		findMinMax(node, 0, p);

		ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();

		for (int i = p.min; i <= p.max; i++) {

			if (hm.get(i) != null)
				rs.add(hm.get(i));
		}
		return rs;
	}
}
