import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private Grid grid;
    private Player player1;
    private Player player2;

    // for finding the winner
    private char winnerMark;
    private Player winnerPlayer;

    // for handling the player's input
    private int row;
    private int column;

    private Scanner sc = new Scanner(System.in);
    
    public Game(Grid grid, Player p1, Player p2) {
        this.grid = grid;
        player1 = p1;
        player2 = p2;
    }

    // take the turn from the player 
    public void handlePlayerTurn(Player p) {
        System.out.println("Player " + p.getName() + "'s turn: (" + p.getMark() + ") ");
        takeInput();

        // handle if the cell chosen is already marked
        while (grid.getCell(row-1, column-1) != ' ') {
            System.out.println("THE CHOSEN CELL IS ALREADY MARKED");
            grid.displayGrid();
            takeInput();
        }

        // mark the chosen cell with the mark
        grid.markCell(row-1, column-1, p.getMark());
        grid.displayGrid();
    }

    // check whether the given inputs are correct or not
    private void takeInput() {
        // take the row (X coordinate) for the chosen cell
        while (true) {
            System.out.println("Enter row (1-3): ");
            try {
                row = sc.nextInt();

                // handle if the row given is out of bounds
                if (row > Grid.GRID_SIZE || row < 1) {
                    System.out.println("OUT OF BOUNDS");
                } 
                // correct input
                else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("INCORRECT INPUT (ENTER INTEGER)");
                sc.nextLine(); // clear buffer for next input
            }
        }

        // take the column (Y coordinate) for the chosen cell
        while (true) {
            System.out.println("Enter column (1-3): ");
            try {
                column = sc.nextInt();

                // handle out of bounds input
                if (column > Grid.GRID_SIZE || column < 1) {
                    System.out.println("OUT OF BOUNDS");
                }  
                // correct input
                else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("INCORRECT INPUT (ENTER INTEGER)");
                sc.nextLine(); // clear buffer for next input
            }
        }
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
}
