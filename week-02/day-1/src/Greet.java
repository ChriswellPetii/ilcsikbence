import java.util.Scanner;

public class Greet {
  public static void main(String[] args) {

    String al = "Greenfox";

    System.out.println(greet(al));

  }

  public static String greet(String al) {
    String greet = "Greetings, " + al;
    return greet;
  }


}
