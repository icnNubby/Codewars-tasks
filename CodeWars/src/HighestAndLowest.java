/**
 * <a href="https://www.codewars.com/kata/554b4ac871d6813a03000035/train/java"> Cata here. </a>
 * @author Nubby
 *
 */
public class HighestAndLowest {
	public static String HighAndLow(String numbers) {
		Integer max = Integer.MIN_VALUE;
		Integer min = Integer.MAX_VALUE;
		for (String s : numbers.split(" ")) {
			max = Math.max(Integer.parseInt(s), max);
			min = Math.min(Integer.parseInt(s), min);
		}
		return max.toString() + " " + min.toString();
	}

}
