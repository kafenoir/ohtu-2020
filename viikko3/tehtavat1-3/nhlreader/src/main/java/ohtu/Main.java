package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        LocalDateTime dateTime = LocalDateTime.now();

        String dateString = dateTime.getDayOfWeek() + " "
                + dateTime.getMonth() + " " + dateTime.getDayOfMonth()
                + " " + dateTime.getYear() + " " + dateTime.toLocalTime();
        
        Arrays.sort(players, Collections.reverseOrder());
        System.out.println("Players from FIN, " + dateString + "\n");
        for (Player player : players) {

            if (player.getNationality().equals("FIN")) {
                System.out.println(player);
            }
        }
    }

}
