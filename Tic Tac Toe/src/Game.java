public class Game {

    private Grid grid;
    private Player player1;
    private Player player2;
    
    public Game(Grid grid, Player p1, Player p2) {
        this.grid = grid;
        player1 = p1;
        player2 = p2;
    }

    // take the turn from the player 
    public void takeTurn(Player p) {
        System.out.println();
    }

    // checks whether the game is finished
    public boolean isGameOver() {
        return false;
    }

    // displays each player's name along with his/her mark at the start
    public void displayStats() {
        player1.displayPlayer();
        player2.displayPlayer();
    }
}
