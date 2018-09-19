
/**
 * Класс Игрок
 */
public class Player extends Thread {
    String playerName;
    private Game game;

    Player(String name, Game game) {
        this.playerName = name;
        this.game = game;
    }

    @Override
    public void run() {
        while (!game.stopGame) {
            game.sendMessage(playerName, this);
        }
    }
}
