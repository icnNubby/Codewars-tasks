import java.util.ArrayList;
public class sumOfDividedClass {
	public static String sumOfDivided(int[] l) {

		int maxAbs = l[0];
		int[] lCutted = new int[l.length];
		for (int i = 0; i < l.length; i++) {
			maxAbs = Math.max(maxAbs, Math.abs(l[i]));
			lCutted[i] = l[i];
		}
		

		ArrayList<Integer> pr = new ArrayList<Integer>();
		long[] lp = new long[maxAbs + 1];
		for(int i = 0; i < lp.length; i++) lp[i] = 0;

		StringBuilder sb = new StringBuilder();

		for (int i = 2; i <= maxAbs; i++) {
			if (lp[i] == 0) {
				lp[i] = i;
				pr.add(i);
				
				int curSum = 0;
				boolean changed = false;
				for (int k = 0; k < l.length; k++) {
					if (l[k]%pr.get(pr.size()-1) == 0) changed = true;
					curSum += ((l[k]%pr.get(pr.size()-1)) == 0) ? l[k] : 0;
				}
				if (changed) sb.append("(" + pr.get(pr.size()-1) + " "  + curSum + ")");
				
				maxAbs = 0;
				for (int k = 0; k < lCutted.length; k++) {
					while ((lCutted[k]%pr.get(pr.size()-1))==0) {lCutted[k] /= pr.get(pr.size()-1);}
					maxAbs = Math.max(maxAbs, Math.abs(lCutted[k]));
				}
				
				
			}
			
			for (int j = 0; j < pr.size(); j++) {
				if ((pr.get(j) <= lp[i])&&((long) i*pr.get(j) <= (long) maxAbs )) {
					lp[pr.get(j)*i] = pr.get(j);
				}


			}

		}

		return sb.toString();
	}

	public static void main(String[] args) {
		int[] lst = new int[] {12,15};
		System.out.println(sumOfDividedClass.sumOfDivided(lst));
	}
}
