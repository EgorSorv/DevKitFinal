package task;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Game {
    static Random random;
    static Map<Integer, Boolean> gameResults;
    static int doors;

    public static void initialGame(int gamesAmount) {
        random = new Random();
        gameResults = new HashMap<>();
        doors = 3;
        int win = 0;

        for (int i = 0; i < gamesAmount; i++)
            startGame(i);


        for (Map.Entry<Integer, Boolean> entry: gameResults.entrySet())
            if (Boolean.TRUE.equals(entry.getValue()))
                win++;

        System.out.println("Number of games won => " + win);
    }

    public static void startGame(int gameNum) {
        int winDoor = random.nextInt(doors);
        int chosenDoor = random.nextInt(doors);
        int emptyDoor = -1;
        int reselectedDoor = -1;

        for (int i = 0; i < doors; i++)
            if (i != winDoor && i != chosenDoor)
                emptyDoor = i;

        for (int i = 0; i < doors; i++)
            if (i != emptyDoor && i != chosenDoor)
                reselectedDoor = i;

        gameResults.put(gameNum, winDoor == reselectedDoor);
    }
}
