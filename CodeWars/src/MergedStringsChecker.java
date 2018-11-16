
public class MergedStringsChecker {

    public static boolean isMerge(String s, String part1, String part2) {

      StringBuilder sb_s = new StringBuilder(s);
      StringBuilder sb_part1 = new StringBuilder(part1);
      StringBuilder sb_part2 = new StringBuilder(part2);
      
      if (sb_s.length() != (sb_part1.length()+sb_part2.length())) return false;
      if ((sb_s.length() == 0)&(sb_part1.length()==0)&(sb_part1.length()==0)) return true;
      int fulllength = sb_s.length();
      
      for (int i = 0; i<fulllength; i++) {
        
        int l1 = sb_part1.length();
        int l2 = sb_part2.length();        
        
        char ch = sb_s.charAt(0);
        char ch1 = l1==0 ? 0: sb_part1.charAt(0); 
        char ch2 = l2==0 ? 0: sb_part2.charAt(0); 

 
        if ((ch1 == ch)&&(ch2 == ch)) {
        
        //  We have 2 cases now, if we go by cutting first substring, or second. We have to go both ways and figure out, can it work
        //  Input can be configured in a way to overload our algo.
        //  Ex: aabbccddeeffggii ?= abcdefgi + abcdefgi, etc. 
        //  It might make us run out of memory, so this method is not great.

        sb_part1.deleteCharAt(0);
          sb_s.deleteCharAt(0);
          
          if (isMerge(sb_s.toString(), sb_part1.toString(), sb_part2.toString())) return true; else
          
          {
            sb_part1.insert(0,ch1);
            sb_part2.deleteCharAt(0);
            
            if (isMerge(sb_s.toString(), sb_part1.toString(), sb_part2.toString())) return true; else
            return false;
          }
          
        }
        
        if ((l1>0)&&(ch == ch1)) {
          sb_part1.deleteCharAt(0);
          sb_s.deleteCharAt(0);
        } else if ((l2>0)&&(ch == ch2))  {
          sb_part2.deleteCharAt(0);
          sb_s.deleteCharAt(0);          
        } else return false;
         
      }
      
      return true;
      
      
    }

}
