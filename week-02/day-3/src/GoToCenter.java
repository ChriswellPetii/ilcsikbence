import javax.swing.*;

import java.awt.*;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GoToCenter {
  public static void mainDraw(Graphics graphics) {
    // Create a line drawing function that takes 2 parameters:
    // The x and y coordinates of the line's starting point
    // and draws a line from that point to the center of the canvas.
    // Draw 3 lines with that function. Use loop for that.

    int height = HEIGHT/2;
    int width = WIDTH/2;

//    Scanner scanner = new Scanner(System.in);
    int userInput1 = 0;
    int userInput2 = 0;
    int userInput3 = 10;

    int newArray[] = drawLinesToCenter(userInput1, userInput2, userInput3);
    System.out.println(newArray[0] + " and " + newArray[1]);

    graphics.drawLine(newArray[0], newArray[1], width, height);

  }

  public static int[] drawLinesToCenter(int userInput1, int userInput2, int userInput3){

    for (int i = 0; i < 3; i++) {
      userInput1 =+ userInput3;
      userInput2 =+ userInput3;

      return new int[]{userInput1};
    }

    return new int[]{userInput1, userInput2};
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 343;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(WIDTH, HEIGHT));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}