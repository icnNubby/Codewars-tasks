public class IntTriangles {
    public static int giveTriang(int per) {
    // your code
    int a = (int) (per / 2);
    int b = (int) (per / 2);
		int counter = 0;
    if (a == 0) return 0;
    	else {
    		while (b > 0) {
          a = (int) (per / 2);
          while (a > 0) {
            double c = Math.sqrt(a*a + b*b + a*b);
    			  if ((b + a + c <= per) && ((int) c == c)) counter++;
    			  a--;
          }
          b--;
    		}
    	}
        return (int) counter/2 ;
    }
}