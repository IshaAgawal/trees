package solution;

/* Depth of a tree from it's array representation, and given 0 is the root node 
Method 3 for solving the above problem using memorization to improve on the complexity */

import java.util.HashMap;

public class DepthFromArrayMethod3 {
	
	static HashMap<Integer,Integer> depth = new HashMap<Integer,Integer>();  // depth for storing the depths
	// of a node
	
	static int findDepthInGenericTree(int a[]) {
		
		if(a.length == 0)
			return 0;
		
		int max = -1, currD = -1,j;
		
		for(int i = 0; i < a.length; i++){
			
			j = i;
			 currD = 0;
	
		 while(a[j] != -1 ) {    // This condition to reach to parent node
			 
				if(depth.get(j) != null) {
					currD += depth.get(j);
					break;
				}
			 currD++;	
			 j = a[j];
		 }
		 
		 depth.put(i, currD);  
		 if(currD > max) {
				max = currD;
			}
	} 
		// depth[i] = currD;
	return max;	
	}
	
	public static void main(String[] args) {
		
		int a[] = {-1,0,1,6,6,0,0,2,7};
		
		findDepthInGenericTree(a);
	}

}
