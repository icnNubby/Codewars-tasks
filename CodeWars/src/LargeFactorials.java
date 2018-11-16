
public class LargeFactorials {
	
	  public static String multiply(String str, int num) {
		    
		    //multiplies string str*num
		    
		    if (str == "") return "";
		    long stored = 0; long tmp;
		    StringBuilder out = new StringBuilder("");
		    int len = str.length();
		    int[] digits = new int[len];
		    
		    for (int i = 0; i < (len); i++ ){
		      digits[i] = Character.getNumericValue(str.charAt(i));
		    } //convert string to array of digits
		    
		    for (int j = len - 1; j >= 0; j-- ) {
		      // multiply every digit to our 'num', result's lowest digit goes to output,
		      // other part is stored for further equations
		      tmp = stored + digits[j]*num;
		      int curdigit = (int) tmp%10;
		      out.append(curdigit);
		      stored = tmp/10;
		    }
		    
		    while (stored != 0)   { //if we still have something to push out, we'll do it
		      out.append(stored%10);
		      stored/=10;
		    }
		    
		    return out.reverse().toString();
		  }
		  
		  public static String Factorial(int n) {
		     
		    if (n < 0) return "";
		  
		    StringBuilder str = new StringBuilder("1");
		    for (int i = 2; i<=n; i++) {

		      StringBuilder tempstr = new StringBuilder(multiply(str.toString(), i));
		      str.delete(0,str.length());
		      str.append(tempstr.toString());

		    }
		    return str.toString();
		  }

}
