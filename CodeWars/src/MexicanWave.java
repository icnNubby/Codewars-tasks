	public class MexicanWave {

	    public static String[] wave(String str) {
	    
	        
	        int countspaces = 0;
	        int currspaces = 0;
	        char tmp = 0;
	        for (int i = 0; i<str.length(); i++) countspaces += (str.charAt(i)==' ') ? 1: 0;
	        String[] out = new String[str.length()-countspaces]; // to allocate less memory incase of huge amount of spaces
	        StringBuilder strb = new StringBuilder(str);
	          
	        for (int i = 0; i<str.length()-countspaces; i++){
	          while (strb.charAt(i + currspaces)==' ') currspaces++;           
	          tmp = strb.charAt(i + currspaces);
	          strb.setCharAt(i + currspaces, (char) (tmp-32)); //convert symbol to UPPERCASE
	          out[i] = strb.toString();
	          strb.setCharAt(i + currspaces, tmp);            
	        } 
	         
	        return out;
	    }
	    
	}
