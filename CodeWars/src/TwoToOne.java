//https://www.codewars.com/kata/5656b6906de340bd1b0000ac/train/java

public class TwoToOne {
    
    public static String longest (String s1, String s2) {
    	String s = s1 + s2;
    	return s.chars().distinct().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
