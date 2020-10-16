package Challenge1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class PageFetcher {

  Boolean complete = false;

  Scanner sc = new Scanner(System.in);
  URL url;

  public void getInput() throws IOException {
    System.out.println("Enter person code:");

    String result = sc.next();
    createURL(result);
    getData();
  }

  private void createURL(String input) throws MalformedURLException {
    url = new URL("https://www.ecs.soton.ac.uk/people/" + input);
  }


   private void getData() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
    String line;
    int counter = 0;
    while ((line = reader.readLine()) != null && counter != 7) {
      counter++;
    }
    if (counter == 7) {
      StringBuilder builder = new StringBuilder();
      String newLine = line.substring(11);
      char[] start = new char[line.length()];
      for (int i = 0; i < newLine.length(); i++) {
        start[i] = newLine.charAt(i);
      }
      for (char c : start) {
        if (c == '|') {
          break;
        } else {
          builder.append(c);
        }
      }
      if (builder.toString().equals("People ")) {
        System.out.println("User not found, please enter a different code.");
        complete = false;
      } else {
        System.out.println(builder);
        reader.close();
        complete = true;
      }
    }
  }

}
