package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        QueryBuilder query = new QueryBuilder();

        Matcher m = query.playsIn("NYR")
                .hasAtLeast(5, "goals")
                .hasFewerThan(10, "goals").build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("");

        m = query.oneOf(
                query.playsIn("PHI")
                        .hasAtLeast(10, "assists")
                        .hasFewerThan(5, "goals").build(),
                query.playsIn("EDM")
                        .hasAtLeast(40, "points").build()
        ).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

    }

}
