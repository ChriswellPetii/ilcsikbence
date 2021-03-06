import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println(translatedText("This is an example text. This another example text with more words in it."));
  }

  public static String translatedText(String text) {
    String[] array = text.split("[.]");
    String newText = "";

    for (int i = 0; i < array.length; i++) {
      newText += translateSentence(array[i]) + randomSayings() + " ";
    }

    newText = newText.substring(0, newText.length() - 1);

    return newText;
  }

  public static String translateSentence(String sentence) {
    if (sentence.substring(0, 1).equals(" ")) {
      sentence = sentence.substring(1);
    }

    String words[] = sentence.split(" ");
    String tempWords[] = new String[words.length];

    int oddOrEven;
    if (words.length % 2 == 0) {
      oddOrEven = 0;
    } else {
      oddOrEven = 1;
      tempWords[words.length - 1] = words[words.length - 1];
    }

    for (int i = 0; i < words.length - oddOrEven; i++) {
      if (i % 2 == 0)
        tempWords[i] = words[i + 1];
      if (i % 2 == 1)
        tempWords[i] = words[i - 1];
    }

    tempWords[0] = tempWords[0].substring(0,1).toUpperCase() + tempWords[0].substring(1);
    tempWords[1] = tempWords[1].toLowerCase();

    String newString = "";

    for (int i = 0; i < tempWords.length; i++) {
      newString += tempWords[i] + " ";
    }

    newString = newString.substring(0, newString.length() - 1) + ".";

    return newString;
  }

  public static String randomSayings() {
    List<String> sayings = Arrays.asList(" Arrgh.", " Uhmm.", " Hmm.", " Err..err.err.");
    int randomTimes = (int) (1 + Math.random() * 2);
    int randomSayingFirst = (int) (Math.random() * sayings.size());
    int randomSayingSecond = (int) (Math.random() * sayings.size());

    String randomSaying = "";

    for (int i = 0; i < randomTimes; i++) {
      if (randomTimes == 2) {
        randomSaying = sayings.get(randomSayingFirst) + sayings.get(randomSayingSecond);
      } else {
        randomSaying = sayings.get(randomSayingFirst);
      }
    }

    return randomSaying;
  }
}
