
public class MaximumSubarraySum {
	public static int sequence(int[] arr) {
	    int maxsum = 0; int curmaxsum = 0;
	    for(int i = 0; i<arr.length; i++){
	      curmaxsum += arr[i];
	      if (curmaxsum < 0) curmaxsum = 0;
	      if (curmaxsum > maxsum) maxsum = curmaxsum;
	    }
	    return maxsum;
	}
}
