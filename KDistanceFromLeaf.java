public class KDistanceFromLeaf {
	
	static void kdistanceUtil(TreeNode node, int path[] , boolean visited[] , int i , int k) {
		
		if(node == null)
			return ;
		
 		path[i] = node.val;
		visited[i] = false;
		i++;
		
		if(node.left == null && node.right == null) {
			
			if(i-k-1 >= 0 && !visited[i-k-1]) {
				System.out.print(path[i-k-1]+ " ");
				visited[i-k-1] = true;
			}
		}
		kdistanceUtil(node.left, path,visited,i,k);  // if i = 1, this value of i is passed
		kdistanceUtil(node.right, path,visited,i,k);  // same value of i is passed here, not the updated one, stack maintains the values of the variables
	}
	
	static void kdistance(TreeNode node, int k) {
		
		boolean visited[] = new boolean[1000];
		int path[] = new int[1000];
		
		kdistanceUtil(node,path,visited,0,k);
	}
	
  public static void main(String[] args) {
	
	  
	  TreeNode t = new TreeNode(1);
	  t.left = new TreeNode(2);
	  t.left.left = new TreeNode(4);
	  t.left.right = new TreeNode(5);
	  
	  t.right = new TreeNode(3);
	  t.right.left = new TreeNode(6);
	  t.right.right = new TreeNode(7);
	  t.right.left.right = new TreeNode(8);
	  
	  kdistance(t,2);
}

}