import java.util.ArrayList;

public class TwiceLinear {
	
    public static int knuth(int n, ArrayList<Integer> a)
    {
      if (n==0) return 1;
   
      int top = a.size() - 1; int bot = 0; int mid;
   
   	  while ((top - bot) > 1) {
   		  mid = bot + ((top - bot) >> 1);
   		  if (a.get(mid) > n) top = mid;
   		  else bot = mid;
   	  }
  
      return  a.get(top);
    }
    
    public static int dblLinear (int n) {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	arr.add(1);
    	int ai = 1;
    	

    	for (int i = 1; i <= n; i++) {
    		ai = 1 + Math.min( 2 * knuth( (int)(Math.floor((ai-1)/2)), arr), 
 	  			   				3 * knuth( (int)(Math.floor((ai-1))/3), arr));
    		
    		arr.add(i, ai);
    	}
         return ai;
    }
   
}
