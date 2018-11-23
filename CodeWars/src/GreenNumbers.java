import java.math.BigInteger;

public class GreenNumbers {
	static long count = 0;



	public static BigInteger get(int n) {

		int found = 0;
		int leadzeros5 = 0; 
		int max = n - 3;
		BigInteger tmp1 = BigInteger.valueOf(5);
		BigInteger tmp2 = BigInteger.valueOf(6);
		BigInteger swap = BigInteger.valueOf(0);
		BigInteger prev5 = BigInteger.valueOf(5);
		BigInteger prev6 = BigInteger.valueOf(6);



		if (n==1) return BigInteger.valueOf(1);
		if (n==2) return BigInteger.valueOf(5);
		if (n==3) return BigInteger.valueOf(6);
		BigInteger Storage = BigInteger.TEN.pow(prev5.toString().length() + leadzeros5);
		BigInteger checker = new BigInteger("0");
		while (found <= max) {
			
			
			long cur = System.currentTimeMillis();

			Storage = Storage.multiply(BigInteger.TEN);
			checker = (prev5.multiply(prev5).multiply(BigInteger.valueOf(3))).subtract((prev5.pow(3).multiply(BigInteger.valueOf(2))));
			checker = checker.mod(Storage);
			
			count += (System.currentTimeMillis() - cur);
			
			if (found <= n) {
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


			if (found == max + 1) return tmp1;
			
			cur = System.currentTimeMillis();
			checker = (Storage).subtract(prev5).add(BigInteger.ONE);

			count += (System.currentTimeMillis() - cur);

			if (found <= n) {
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
			if (found == max + 1) return tmp1;
		}
		return tmp2;
	}

	public static void main(String[] args) {
		long cur = System.currentTimeMillis();
		System.out.println(get(5000).toString());
		System.out.println(System.currentTimeMillis() - cur);
		System.out.println(count);
	}
}
