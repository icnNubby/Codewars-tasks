
public class NumberOfProperFractionsWithDenominatorD {

	  public static long properFractions(long n) {
	    
	    //Simple solution for Euler's function.
	    //Not using factorisation optimisations.
	    
	    long count = 1; 
	    long tmp = 1;
	    
	    if (n == 1) return 0; // its actually wrong for Euler's function;
	    
	    for (long i = 2; i <= (long) Math.sqrt(n); i++) {
	      tmp = 1;
	      if (n % i == 0) {
	        n /= i;
	        while (n % i == 0) {
	          n /= i;
	          tmp *= i;
	        }
	        count *= tmp * (i - 1);
	      }
	    }
	    if (n != 1) {
	      count *= (n - 1);
	    }
	    return count;
	  }
}
