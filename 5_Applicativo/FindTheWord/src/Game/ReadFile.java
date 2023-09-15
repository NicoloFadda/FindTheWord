package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author nicolo.fadda
 */
public class ReadFile {
    public static void main(String[] args) {  
    try {
      File userFile = new File("filename.txt");
      Scanner myReader = new Scanner(userFile);  
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    } 
  } 
}
