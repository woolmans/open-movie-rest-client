import java.util.Scanner;
import java.net.http.*;
import java.net.*;
import java.util.HashMap;
import java.util.*;
import java.io.*;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {

    public static void main(String... args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome \nThis is the Open Movie Database Client.");
        System.out.println("Which movie would you like to search?");
        String str = sc.nextLine();
        System.out.println(str);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.omdbapi.com/?t=" + str.replace(" ", "+") + "&apikey=c9e56fb9"))
                .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
