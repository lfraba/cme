public class PingPongGame {
    private static final String message = "Test"; // Текст сообщения
    private static final int finalScore = 15; //Финальный счёт для игрока №1

    public static void main(String[] args){

        Game pingPongGame = new Game(message, finalScore);
        Player player1 = new Player("Player1", pingPongGame);
        Player player2 = new Player("Player2", pingPongGame);

        pingPongGame.register(player1);
        pingPongGame.register(player2);

        pingPongGame.play();
    }
}
