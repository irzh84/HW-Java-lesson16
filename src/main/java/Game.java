import java.util.HashMap;

public class Game {
    private HashMap<Integer, Player> playersList = new HashMap<>();

    public Player register(Player player) {
        playersList.put(player.getId(), player);
        return player;
    }

    public Player findByName(String name) {
        for (Integer key : playersList.keySet()) {
            Player player = playersList.get(key);
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован!");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован!");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}