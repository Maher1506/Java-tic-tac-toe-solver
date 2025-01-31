package Grid;
import java.util.ArrayList;

public class Grid {

    private char[][] grid;
    private char winnerMark;
    
    public static final int GRID_SIZE = 3;

    public Grid() {
        grid = new char[GRID_SIZE][GRID_SIZE];

        // initialize grid with empty chars
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = ' ';
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
                
                System.out.print(" " + cell + " ");

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
     public boolean isTerminalState() {
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
