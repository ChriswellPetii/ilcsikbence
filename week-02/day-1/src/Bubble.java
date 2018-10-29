import java.util.*;

public class Bubble {
  public static void main(String[] args) {
    //  Create a function that takes a list of numbers as parameter
    //  Returns a list where the elements are sorted in ascending numerical order
    //  Make a second boolean parameter, if it's `true` sort that list descending

    //  Example:
    System.out.println(bubble(new int[] {34, 12, 24, 9, 5}));
    //  should print [5, 9, 12, 24, 34]
    System.out.println(advancedBubble(new int[] {34, 12, 24, 9, 5}, true));
    //  should print [34, 24, 12, 9, 5]


  }

  public static List<Integer> bubble(int[] numbers) {
    Arrays.sort(numbers);
    ArrayList<Integer> integers = new ArrayList<>();
    for (int i : numbers) {
      integers.add(i);
    }
    return integers;
  }

  public static List<Integer> advancedBubble(int[] numbers, boolean isTrue) {
    if (isTrue) {
      ArrayList<Integer> integers = new ArrayList<>();
      for (int i : numbers) {
        integers.add(i);
      }

      integers.sort(Comparator.reverseOrder());
      return integers;
    } else {
      return bubble(numbers);
    }
  }
}