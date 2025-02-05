package Grid;
import java.sql.Blob;
import java.util.ArrayList;

public class Grid {

    private char[][] grid;
    private char winnerMark;

    // ANSI color codes
    public static final String RED = "\033[0;31m";   
    public static final String BLUE = "\033[0;34m";   
    public static final String RESET = "\033[0m";  
    
    public static final int GRID_SIZE = 3;

    // default constructor
    public Grid() {
        grid = new char[GRID_SIZE][GRID_SIZE];

        // initialize grid with empty chars
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    // copy constructor 
    public Grid(Grid other) {
        grid = new char[GRID_SIZE][GRID_SIZE];
        winnerMark = other.winnerMark;

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = other.getCell(i, j);
            }
        }
    }

    // gets all the available (non marked) moves available
    public ArrayList<int[]> getAvailableMoves() {
        ArrayList<int[]> res = new ArrayList<>();

        // loop through the grid to find empty cells
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                // empty cell (available)
                if (grid[i][j] == ' ') {
                    // add the row and column of the cell to the arraylist
                    int[] move = {i, j};
                    res.add(move);
                }
            }
        }
        return res;
    }

    // method to display the grid
    public void displayGrid() {
        System.out.println();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                char cell = grid[i][j];
                
                if (cell == 'X') {
                    System.out.print(" " + RED + cell + RESET + " ");
                } else if (cell == 'O') {
                    System.out.print(" " + BLUE + cell + RESET + " ");
                } else {
                    System.out.print(" " + cell + " ");
                }

                // to print the vertical lines
                if (j != GRID_SIZE-1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            // to print the horizontal lines
            if (i != GRID_SIZE-1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    // checks whether the grid is full or not
    public boolean isFull() {
        // loop through the grid
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                // if just one empty cell is found return not full
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        // all cells are not empty
        return true;
    }

     // checks whether the game is won by any player
     public boolean isGameWon() {
        // check the rows and colums simultaneously
        for (int i = 0; i < GRID_SIZE; i++) {
            // check the ith row
            if (grid[i][0] == grid[i][1] && 
                grid[i][1] == grid[i][2] && 
                (grid[i][0] != ' ')) {
                
                winnerMark = grid[i][0];
                return true;
            }

            // check the ith column
            if (grid[0][i] == grid[1][i] && 
                grid[1][i] == grid[2][i] && 
                (grid[0][i] != ' ')) {
                
                winnerMark = grid[0][i];
                return true;
            }
        }

        // check for both diagonals
        if (grid[0][0] == grid[1][1] && 
            grid[1][1] == grid[2][2] && 
            (grid[0][0] != ' ')) {
            
            winnerMark = grid[0][0];
            return true;
        }
        if (grid[0][2] == grid[1][1] && 
            grid[1][1] == grid[2][0] && 
            (grid[0][2] != ' ')) {
            
            winnerMark = grid[0][2];
            return true;
        }

        // game is still ongoing
        return false;
    }

    // returns true if the grid reached the end of the game
    public boolean isTerminalState() {
        return isGameWon() || isFull();
    }

    // to mark a cell in the grid
    public void markCell(int row, int column, char mark) {
        grid[row][column] = mark;
    }

    // to get the value of a specific cell
    public char getCell(int row, int column) {
        return grid[row][column];
    }

    // getters
    public char getWinnerMark() {
        return winnerMark;
    }
}
