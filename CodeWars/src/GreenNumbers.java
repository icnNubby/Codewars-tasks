// https://www.codewars.com/kata/last-digits-of-n-2-equals-equals-n/train/java
// tests uses one and same object for getting green numbers, so lets prebuild array of greenies up to the declared limit (5000).
// after that we simply get needed by index, and ye, we need some space.

import java.math.BigInteger;
import java.util.ArrayList;

public class GreenNumbers {
	
	static ArrayList<BigInteger> prebuild = new ArrayList<BigInteger>();
	static boolean builded = false;

	public static boolean build () {

		int found = 0;
		int leadzeros5 = 0; 
		int max = 5001 - 3; //5001 to get at least 5000 - 3 pre setted values {'1', '5', '6'}
		BigInteger tmp1 = BigInteger.valueOf(5);
		BigInteger tmp2 = BigInteger.valueOf(6);
		BigInteger swap = BigInteger.valueOf(0);
		BigInteger prev5 = BigInteger.valueOf(5);
		BigInteger prev6 = BigInteger.valueOf(6);



		prebuild.add(BigInteger.valueOf(1));
		prebuild.add(BigInteger.valueOf(5));
		prebuild.add(BigInteger.valueOf(6));
		BigInteger storage = BigInteger.TEN.pow(prev5.toString().length() + leadzeros5);
		BigInteger checker = new BigInteger("0");
		BigInteger prev5Pow2 = new BigInteger("0");
		BigInteger three = new BigInteger("3");
		BigInteger two = new BigInteger("2");
		while (found <= max) {
			
			//visit wiki to get it (automorph) (its recursive for any n -> (3*n*n - 2*n*n*n) mod 10^(2*k) where k is amount of digits in n)
			storage = storage.multiply(BigInteger.TEN);
			prev5Pow2 = prev5.multiply(prev5);
			checker = prev5.multiply(two);
			checker = three.subtract(checker);
			checker = prev5Pow2.multiply(checker);
			checker = checker.mod(storage);


			if (found <= 5000) {
				if (checker.compareTo(prev5)>0) {
					prev5 = checker;
					tmp1 = tmp2;
					tmp2 = checker;
					leadzeros5 = 0;
					if (tmp1.compareTo(tmp2) > 0) { //reorder
						swap = tmp1;
						tmp1 = tmp2;
						tmp2 = swap;
					}
					found++;
				} else {
					leadzeros5++;
				}
			}	


			if (found == max + 1) return true;
			
			//same wiki page
			checker = (storage).subtract(prev5).add(BigInteger.ONE);

			if (found <= 5000) {
				if (checker.compareTo(prev6) > 0) {
					prev6 = checker;
					tmp1 = tmp2;
					tmp2 = checker;
					if (tmp1.compareTo(tmp2) > 0) { //reorder
						swap = tmp1;
						tmp1 = tmp2;
						tmp2 = swap;
					}
					found++;
				}

			}

			if (!prebuild.contains(tmp1)) prebuild.add(tmp1);
			if (!prebuild.contains(tmp2)) prebuild.add(tmp2);

			if (found == max + 1) return true;
		}	
		return true;
	}


	public static BigInteger get(int n) {
		if (!builded) builded = build();
		return prebuild.get(n - 1);
	}
	
	/*
	public static void main(String[] args) {
		long cur = System.currentTimeMillis();
		build();
		System.out.println(get(100).toString());
		for (int i = 0; i < 30; i ++) System.out.println(prebuild.get(i).toString());
		System.out.println(System.currentTimeMillis() - cur);
		System.out.println(count);
	}
	*/
}
