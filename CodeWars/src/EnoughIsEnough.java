public class EnoughIsEnough {

	public static int[] deleteNth(int[] elements, int maxOccurrences) {
		
    int[] out = new int[elements.length];
    
    if ((maxOccurrences==0)||(elements.length==0)) return new int[] {};
    
    int extraOccur = 0; 
    for (int i = 0; i<elements.length; i++){
        int curOccur = 0; boolean append = true;
        for(int j = i - extraOccur - 1; j>=0; j--){
          if (out[j]==elements[i]) curOccur++;
          if (curOccur>=maxOccurrences) {
            extraOccur++;
            append = false;
            break;
          }
        }
          if (append) {
            out[i - extraOccur] = elements[i];
          }
    }
    
    int[] outt = new int[elements.length-extraOccur];
    for (int i = 0; i<elements.length-extraOccur; i++)  outt[i] = out[i];  //cutting array
    
		return outt;
	}

}