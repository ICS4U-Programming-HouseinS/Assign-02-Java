// import necessary packages
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**

* This program finds the max run of a number.

* @author  Housein Shaib

* @version 1.0

* @since   2021-03-1 

* @code taken from https://www.geeksforgeeks.org/convert-a-string-to-a-list-of-characters-in-java/

*     https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/ 

*/

public class StringStuff {
  
  // Declaring ANSI_RESET so that we can reset the color
  public static final String ANSI_RESET = "\u001B[0m";
        
  // Declaring the color
  // Custom declaration
  public static final String ANSI_YELLOW = "\u001B[31m";

  public static int maxRun(String originalString) {
    int counterMax = 0;
    int counterCurrent = 0;
    originalString = originalString + " ";
    String[] arrString = originalString.split("");
    String currentStr = (arrString[0]);
    String tempStr = currentStr;
    for (int i = 0; i < arrString.length; i++) {
      currentStr = (arrString[i]);
      if (currentStr.equals(tempStr)) {
        counterCurrent = counterCurrent + 1;
      } else {
        if (counterCurrent > counterMax) {
          counterMax = counterCurrent;
        }
        counterCurrent = 1;
      }
      tempStr = currentStr;
    }
    return counterMax;
  }
  
  // Driver code
  public static void main(String[] args) throws Exception {
    List<String> listOfWords
        = new ArrayList<String>();
  
    // Get the String to be converted
    File myObj = new File("Text.txt");
    Scanner myReader = new Scanner(myObj);
    while (myReader.hasNextLine()) {
      String data = myReader.nextLine();
      listOfWords.add(data);
    }

    String[] arrayOfWords
    = listOfWords.toArray(new String[listOfWords.size()]);
        
    for (int i = 0; i < arrayOfWords.length; i++) {
      System.out.print(ANSI_YELLOW + "The max run is: " 
          + maxRun(arrayOfWords[i]) + "\n \n" + ANSI_RESET);
        

    }
  }
}