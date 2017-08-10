
package solution;

import java.util.ArrayList;
import java.util.HashMap;

public class DepthFromArray {
	
	static HashMap<Integer,ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>();
	
	static int findDepth(int n) {
		
	if(hm.get(n) == null)
		return 0;
	
	ArrayList<Integer> alist = hm.get(n);
	
	int max = 0;
	
	for(Integer i : alist) {
		
		int depth = findDepth(i);
		
		if(depth > max)
			max = depth;
	}
	return max+1;
}
	
	public static void main(String[] args) {
		
		int a[] = {-1,0,1,6,6, 0,0,2, 7};
		
		for (int i = 0; i < a.length; i++) {
			if(hm.get(a[i]) == null) {
				ArrayList<Integer> alist = new ArrayList<Integer>();
				alist.add(i);
				hm.put(a[i], alist);
			}
			else {
				hm.get(a[i]).add(i);
			}
		}
		System.out.println(findDepth(0));
	}
	
	
}

