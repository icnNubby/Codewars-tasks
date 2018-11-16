import java.util.Formatter;

public class CreatePhoneNumber {
  public static String createPhoneNumber(int[] numbers) {
    // Your code here!
    Formatter f = new Formatter();
    f.format("(%d%d%d) %d%d%d-%d%d%d%d", 
                            numbers[0],numbers[1],numbers[2],
                            numbers[3],numbers[4],numbers[5],
                            numbers[6],numbers[7],numbers[8],numbers[9]);
    return f.toString();
    
  }
}