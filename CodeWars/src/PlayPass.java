public class PlayPass {
	public static String playPass(String s, int n) {
	StringBuilder sb = new StringBuilder();
    n = n%26;
    for (int i = 0; i<s.length(); i++) {
      char sym = s.charAt(i);
      if ((sym>=65)&&(sym<=90)) { // letter
        char shifted = (char) ((sym - 64) + n);
        if (shifted > 26) shifted -= 26; //if we went too far outside of alphabet - we should start from the beginning (ex. Z+1 => A)
        shifted += 64;
        if (i%2!=0) shifted += 32; //downcase odd ones
        sb.append(shifted);
      } else
      if ((sym>=48)&&(sym<=57)) {// number
        int num = 9 - (sym - 48);
        sb.append(num);
      } else {
        sb.append(sym);
      }
    }
    return sb.reverse().toString();
	}
}