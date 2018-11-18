import java.util.ArrayList;
public class BalancedParens {
	private static ArrayList<String> out;
	private static int total;
	
	public static void generateParens(String str, int leftCount, int rightCount)
	{
        if (leftCount < total)
        {
        	generateParens(str + "(", leftCount + 1, rightCount);
        }
        if ((rightCount < total) && (rightCount < leftCount))
        {
        	generateParens(str + ")", leftCount, rightCount + 1);
        }
        else if (rightCount == total)
        {
        	out.add(str);
        }		
	}
	
	public static ArrayList <String> balancedparens (int n) {
		out = new ArrayList<String>(); 
		total = n;
		generateParens("", 0, 0);
		return out;
	}
}	