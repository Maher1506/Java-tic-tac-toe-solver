package GameLogic;
import Grid.Grid;
import Players.Player;

public class Game {

    private Grid grid;
    private Player player1;
    private Player player2;

    // for finding the winner
    private Player winnerPlayer;
    
    public Game(Grid grid, Player p1, Player p2) {
        this.grid = grid;
        player1 = p1;
        player2 = p2;
    }

    // checks whether the game is finished
    public boolean isGameOver() {
        return grid.isGameWon() || grid.isFull();
    }

    // display the winner and loser or display if there is a tie
    public void displayFinalGameState() {
        System.out.println();

        if (grid.getWinnerMark() == 'X') {
            findWinnerPlayer();
            System.out.println("Player: " + winnerPlayer.getName() + " Won!");
        } else if (grid.getWinnerMark()  == 'O') {
            findWinnerPlayer();
            System.out.println("Player: " + winnerPlayer.getName() + " Won!");
        } else {
            System.out.println("Game is a Tie!");
        }
    }

    // method to find which player won from the winner mark
    private void findWinnerPlayer() {
        if (grid.getWinnerMark()  == player1.getMark()) {
            winnerPlayer = player1;
        } else {
            winnerPlayer = player2;
        }
    }

    // displays each player's name along with his/her mark at the start
    public void displayStats() {
        player1.displayPlayer();
        player2.displayPlayer();
    }
    
    // getters
    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
}
