public class Grid {

    private char[][] grid;
    
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

    // methos to display the grid
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

    // to mark a cell in the grid
    public void markCell(int row, int column, char mark) {
        grid[row][column] = mark;
    }

    // to get the value of a specific cell
    public char getCell(int row, int column) {
        return grid[row][column];
    }
}
