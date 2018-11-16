import java.util.Arrays;


public class SupermarketQueue {
	
	    public static int solveSuperMarketQueue(int[] customers, int n) {
	      int[] ques = new int[n];
	      for (int i = 0; i < n; i++) ques[i] = 0; // initialise queue;
	      for (int i = 0; i < customers.length; i++) {
	        ques[0] += customers[i];
	        Arrays.sort(ques);
	      }
	      return ques[n-1];
	    }
	    
}
