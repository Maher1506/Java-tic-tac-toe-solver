public class Grid {
    private char[][] grid;

    public Grid() {
        grid = new char[3][3];
    }

    // methos to display the grid
    public void displayGrid() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char cell = grid[i][j];
                
                // account for an empty cell
                if (cell == '\0') {
                    System.out.print("   ");
                } else {
                    System.out.print(" " + cell + " ");
                }

                // to print the vertical lines
                if (j != 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            // to print the horizontal lines
            if (i != 2) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    // getters
    public char[][] getGrid() {
        return grid;
    }
}
