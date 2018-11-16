import java.util.Collections;
import java.util.ArrayList;

public class NextBiggerNumberWithTheSameDigits {

    public static long nextBiggerNumber(long n)
    {
      
      if (n<10) return -1;
      
      long curDigit = 0; long prevDigit = n%10; int curPos = 0;
      long nTemp = n/10;
      long out = -1;
      boolean found  = false;
      ArrayList<Long> digitsBeforepos = new ArrayList<Long>();
      digitsBeforepos.add(prevDigit);
    
      while (nTemp>0) {
        curPos++;
        curDigit = (long) nTemp%10;
        if (curDigit<prevDigit) {
  
            out =  (nTemp/10)*(long) Math.pow(10, curPos+1);
            Collections.sort(digitsBeforepos);
            boolean foundSmallAfterPos = false;
            for (int i = 0; i < digitsBeforepos.size(); i++) {
              if (digitsBeforepos.get(i)>curDigit) {
                long tmpDigit = digitsBeforepos.get(i);
                digitsBeforepos.set(i,curDigit);
                curDigit = tmpDigit; 
                out += curDigit*(long) Math.pow(10, curPos);
                foundSmallAfterPos = true;
                break;
              }
            }
            
            if (!foundSmallAfterPos) {out += curDigit*(long) Math.pow(10, curPos); }
            
            Collections.sort(digitsBeforepos);
            for (int i = 0; i<curPos; i++) {
              out += digitsBeforepos.get(i)*(long)Math.pow(10, curPos-i-1);   
             }  
            found = true;
            break;
        }
        
        digitsBeforepos.add(curDigit);
        prevDigit = curDigit;
        nTemp/=10;
      }
      if (found) return out; else return -1;
    }
}
