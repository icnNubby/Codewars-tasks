
public class EqualSidesOfAnArray {
	
	  public static int findEvenIndex(int[] arr) {
		    int out = -1;
		    long[] sums = new long[arr.length];
		    long cursum = 0;
		    for (int i = 0; i<arr.length; i++) {
		      sums[i] = cursum;
		      cursum+=arr[i];
		    }
		    cursum = 0;
		    for (int i = arr.length-1; i>=0; i--)
		    {
		      if (cursum == sums[i]) out = i;
		      cursum+=arr[i];
		    }
		    return out;
		  }
}
