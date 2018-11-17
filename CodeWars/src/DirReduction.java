import java.util.ArrayList;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {

        ArrayList<String> out = new ArrayList<String>();
        if (arr.length == 0) return new String[] {};
        int curpos = 0;
        out.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
          String cur = arr[i];
          if ((i - curpos - 1) < 0) { 
                out.add(arr[i]); 
              }
          else if 
             (((out.get(i - 1 - curpos) == "NORTH")&&(cur == "SOUTH")) ||
              ((out.get(i - 1 - curpos) == "SOUTH")&&(cur == "NORTH")) ||
              ((out.get(i - 1 - curpos) == "WEST")&&(cur == "EAST")) ||
              ((out.get(i - 1 - curpos) == "EAST")&&(cur == "WEST")))
              {
                out.remove(i - 1 - curpos);
                curpos+=2;
              }
          else {
            out.add(arr[i]);  
          }
        }
        
        String[] outarr = new String[out.size()];
        out.toArray(outarr);
        return outarr;
        
    }
}

