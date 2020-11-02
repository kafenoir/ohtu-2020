package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzermann", "DUM", 0, 0));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {

        stats = new Statistics(readerStub);
    }

    @Test
    public void searchReturnsCorrectPlayerIfExists() {

        Player yzerman = stats.search("Yzerman");

        assertEquals("Yzerman", yzerman.getName());
        assertEquals("DET", yzerman.getTeam());
        assertEquals(42 + 56, yzerman.getPoints());
    }

    @Test
    public void searchReturnsNullIfNotExists() {

        Player fedorov = stats.search("Fedorov");

        assertEquals(fedorov, null);
    }

    @Test
    public void teamReturnsCorrectPlayers() {

        List<Player> oilers = stats.team("EDM");

        assertEquals("Semenko", oilers.get(0).getName());
        assertEquals("Kurri", oilers.get(1).getName());
        assertEquals("Gretzky", oilers.get(2).getName());

    }

    @Test
    public void teamReturnsEmptyListIfNotExists() {

        List<Player> avalanche = stats.team("COL");

        assertTrue(avalanche.isEmpty());
    }

    @Test
    public void topScorersReturnCorrectList() {

        List<Player> topScorers = stats.topScorers(3);

        assertEquals(3, topScorers.size());
        assertEquals("Gretzky", topScorers.get(0).getName());
        assertEquals("Lemieux", topScorers.get(1).getName());
        assertEquals("Yzerman", topScorers.get(2).getName());
    }

    @Test
    public void topScorersReturnsEmptyListWithZeroAndNegative() {

        List<Player> topScorersZero = stats.topScorers(0);
        List<Player> topScorersNegative = stats.topScorers(-1);

        assertTrue(topScorersZero.isEmpty());
        assertTrue(topScorersNegative.isEmpty());
    }

}
