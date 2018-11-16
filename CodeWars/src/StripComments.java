
public class StripComments {

	public static String stripComments(String text, String[] commentSymbols) {
		
		StringBuilder sb = new StringBuilder();
		String[] toStrings = text.split("\n");
   
		for(int i = 0; i < toStrings.length; i++){
    
			boolean commentedLine = false;
    
			for(int j = 0; j < commentSymbols.length; j++) {
				int ind = toStrings[i].indexOf(commentSymbols[j]);
				if (ind > -1) {
					sb.append(toStrings[i].substring(0, ind));
					commentedLine = true;
					
					while ((sb.lastIndexOf(" ") == (sb.length() - 1)) && (sb.length()>0) )
						sb.deleteCharAt(sb.length()-1);
        
				}
			}
      
			if (!commentedLine) {
				sb.append(toStrings[i]);
				while ((sb.lastIndexOf(" ") == (sb.length() - 1)) && (sb.length()>0) )
					sb.deleteCharAt(sb.length()-1);
			}
			if (i < toStrings.length - 1) sb.append("\n");
			
		}
		
		return sb.toString();
    
	}
	
}
