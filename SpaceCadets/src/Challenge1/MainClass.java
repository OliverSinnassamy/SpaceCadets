package Challenge1;


import java.io.IOException;
import java.util.Scanner;

public class MainClass {

  public static void main(String[] args) throws IOException {


    Scanner sc = new Scanner(System.in);
    System.out.println("Select program to run:\n1: Fetch Name from Email Id\n2: Fetch first URL from Google Search");
    String result = sc.nextLine();
    switch (result) {
      case "1":
        PageFetcher help = new PageFetcher();
          while(!help.complete){
            help.getInput();
          }
          break;
      case "2":
        GoogleScanner scanner = new GoogleScanner();
        scanner.getInput();
        break;
    }
  }
}
