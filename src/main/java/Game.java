import java.util.*;

/**
 * Класс игра
 */

class Game {
    private static Message message;
    private int finalScore;
    boolean stopGame;
    private ArrayList<Player> playersList;

    Game(String mes, int finalScore) {
        this.finalScore = finalScore;
        message = new Message(mes);
    }

    void sendMessage(String name, Player player) {
        synchronized (this) {
            ++message.counter;
            System.out.println(
                    String.format("%s: Сообщение: %s, Подача: %d", name, message.message, message.counter)
            );
            if (player.playerName.equals(playersList.get(0).playerName) && message.counter >= finalScore) {
                stopGame = true;
                for(Player participan: playersList){
                    participan.interrupt();
                }
            }
            try {
                this.notify();
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("Игра закончена.");
            }
        }
    }

    void register(Player player) {
        if (playersList == null) {
            playersList = new ArrayList<Player>();
        }
        playersList.add(player);
        System.out.println(String.format("Зарегистрирован игрок №: %d", playersList.size()));
    }

    void play() {
        for (Player player : playersList) {
            player.start();
        }
    }
}
