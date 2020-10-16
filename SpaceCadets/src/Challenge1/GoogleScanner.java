package Challenge1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class GoogleScanner {

  URL url;

  public void getInput() throws IOException {
    System.out.println("Enter search term");
    Scanner sc = new Scanner(System.in);

    createUrl(sc.nextLine());

    getData();
  }

  private void createUrl(String search) throws MalformedURLException {
    search = search.replaceAll("\\s+", "+");
    url = new URL("https://www.google.com/search?q=" + search);
  }

  public void getData() throws IOException {

    URLConnection conn = url.openConnection();
    /*Creates a user agent. Without this, a 403 Forbidden Access error occurs from Google.*/
    conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
    conn.connect();

    BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream())); //Creates new buffered reader to get webpage data.

    String line;

    while((line=buffer.readLine()) != null){

      if(line.contains("class=\"yuRUbf\"")){ //Looks for HTML pattern in the file.
        int start = line.indexOf("class=\"yuRUbf\"") +24;
        int end = line.indexOf("\"",start);
        System.out.println(line.substring(start, end));
        break;
      }    }
  }
}




