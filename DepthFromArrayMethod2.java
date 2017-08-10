/* Depth of a tree from it's array representation, and given 0 is the root node 
Method 2 for solving the above problem, o(n^2) solution*/

package solution;

public class DepthFromArrayMethod2 {
	
	//static HashMap<Integer,Integer> depth 
	
	static int findDepthInGenericTree(int a[]) {
		
		if(a.length == 0)
			return 0;
		
		int max = -1, currD = -1,j;
		
		for(int i = 0; i < a.length; i++){
			
			j = i;
			 currD = 0;
			 
	//	if()
		 while(a[j] != -1) {
			 currD++;	
			 j = a[j];
			 
		 }
		 
		// depth[i] = currD;
			
		if(currD > max) {
			max = currD;
		}
		 
		}
	return max;	
		
	}
	public static void main(String[] args) {
		
		int a[] = {-1,0,1,6,6,0,0,2,7};
		
		findDepthInGenericTree(a);
	}

}
