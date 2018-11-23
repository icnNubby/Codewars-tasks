// https://www.codewars.com/kata/last-digits-of-n-2-equals-equals-n/train/java
//works, but slow

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

class Sequence {

	int state;
	int found = 0;
	int max = 0;
	ArrayList<BigInteger> lst;

	Sequence(ArrayList<BigInteger> lst, int max, int state) {
		this.lst = lst;
		this.max = max;
		this.state = 5;
	}

	boolean check(BigInteger n) {
		String str = n.pow(2).toString();
		return (str.substring(str.length()-n.toString().length()).equals(n.toString()));
	}

	synchronized void seq5(BigInteger prev, int leadzeros) {
		try {
			while ((state != 6)&&(found <= max - 2)) wait();
		} catch (InterruptedException exc) {
			System.out.println(exc);			
		}

		for (int i = 9; i >= 0; i--) {
			StringBuilder outputBuffer = new StringBuilder();
			for (int j = 0; j < leadzeros; j++)   outputBuffer.append("0");

			BigInteger checker = new BigInteger(i + outputBuffer.toString() + prev.toString());
			if (check(checker)&&(found <= max - 2)) {
				if (i > 0) {
					if (checker.compareTo(lst.get(lst.size() - 1)) < 0) {
						lst.add(lst.size() - 1, checker);
					} else	{ 
						lst.add(checker); 
					}
					found++;
				}
				state = 5; notify();
				if (i == 0) seq5(checker, leadzeros + 1); else seq5(checker, 0);
				break;
			}
		}
	}

	synchronized public void seq6(BigInteger prev, int leadzeros) {
		try {
			while ((state != 5)&&(found <= max - 2)) wait();
		} catch (InterruptedException exc) {
			System.out.println(exc);			
		}

		for (int i = 9; i >= 0; i--) {
			StringBuilder outputBuffer = new StringBuilder();
			for (int j = 0; j < leadzeros; j++)   outputBuffer.append("0");

			BigInteger checker = new BigInteger(i + outputBuffer.toString() + prev.toString());
			if (check(checker)&&(found <= max - 2)) {
				if (i > 0) {
					if (checker.compareTo(lst.get(lst.size() - 1)) < 0) {
						lst.add(lst.size() - 1, checker);
					} else	{ 
						lst.add(checker); 
					}
					found++;
				}
				state = 6; notify();
				if (i == 0) seq6(checker, leadzeros + 1); else seq6(checker, 0);
				break;
			}
		}
	}

}

class Threads implements Runnable {
	Thread thrd;
	Sequence seq;
	int mode;

	Threads(Sequence s, int md) {
		seq = s;
		mode = md;
		thrd = new Thread(this);
		thrd.start();
	}

	@Override
	public void run() {
		if (mode == 6) seq.seq6(BigInteger.valueOf(mode), 0);
		if (mode == 5) seq.seq5(BigInteger.valueOf(mode), 0);
	}

}

public class GreenNumbersThreaded {

	static ArrayList<BigInteger> lst = new ArrayList<BigInteger>();


	public static BigInteger get(int n) {
		
		System.out.println(new Date(System.currentTimeMillis()).toString());
		Sequence s = new Sequence(lst, n, 5);
		lst.clear(); 
		lst.add(BigInteger.valueOf(1));
		lst.add(BigInteger.valueOf(5));
		lst.add(BigInteger.valueOf(6));
		Threads t1 = new Threads(s, 5);
		Threads t2 = new Threads(s, 6);

		try {
			t1.thrd.join();
			t2.thrd.join();
		}
		catch (InterruptedException exc) {
			System.out.println("main out");			
		}
		
		System.out.println(new Date(System.currentTimeMillis()).toString());
		return new BigInteger(lst.get(n-1).toString());
	}

	public static void main(String[] args) {
		System.out.println(get(5000).toString());
	}
}