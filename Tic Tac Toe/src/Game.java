import Grid.Grid;
import Players.Player;

public class Game {

    private Grid grid;
    private Player player1;
    private Player player2;

    // for finding the winner
    private char winnerMark;
    private Player winnerPlayer;
    
    public Game(Grid grid, Player p1, Player p2) {
        this.grid = grid;
        player1 = p1;
        player2 = p2;
    }

    // checks whether the game is finished
    public boolean isGameOver() {
        return isGameWon() || grid.isFull();
    }

    // checks whether the game is won by any player
    private boolean isGameWon() {
        // check the rows and colums simultaneously
        for (int i = 0; i < Grid.GRID_SIZE; i++) {
            // check the ith row
            if (grid.getCell(i, 0) == grid.getCell(i, 1) && 
                grid.getCell(i, 1) ==grid.getCell(i, 2) && 
                (grid.getCell(i, 0) != ' ')) {
                
                winnerMark = grid.getCell(i, 0);
                return true;
            }

            // check the ith column
            if (grid.getCell(0, i) == grid.getCell(1, i) && 
                grid.getCell(1, i) == grid.getCell(2, i) && 
                (grid.getCell(0, i) != ' ')) {
                
                winnerMark = grid.getCell(0, i);
                return true;
            }
        }

        // check for both diagonals
        if (grid.getCell(0, 0) == grid.getCell(1, 1) && 
            grid.getCell(1, 1) == grid.getCell(2, 2) && 
            (grid.getCell(0, 0) != ' ')) {
            
            winnerMark = grid.getCell(0, 0);
            return true;
        }
        if (grid.getCell(0, 2) == grid.getCell(1, 1) && 
            grid.getCell(1, 1) == grid.getCell(2, 0) && 
            (grid.getCell(0, 2) != ' ')) {
            
            winnerMark = grid.getCell(0, 2);
            return true;
        }

        // game is still ongoing
        return false;
    }

    // display the winner and loser or display if there is a tie
    public void displayFinalGameState() {
        System.out.println();

        if (winnerMark == 'X') {
            findWinnerPlayer();
            System.out.println("Player: " + winnerPlayer.getName() + " Won!");
        } else if (winnerMark == 'O') {
            findWinnerPlayer();
            System.out.println("Player: " + winnerPlayer.getName() + " Won!");
        } else {
            System.out.println("Game is a Tie!");
        }
    }

    // method to find which player won from the winner mark
    private void findWinnerPlayer() {
        if (winnerMark == player1.getMark()) {
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
