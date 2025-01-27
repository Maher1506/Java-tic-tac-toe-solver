import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    private String name;
    private char mark;
    private Grid grid;

    // for handling the player's input
    private int row;
    private int column;
    private Scanner sc = new Scanner(System.in);

    public Player(String name, char mark, Grid grid) {
        this.name = name;
        this.mark = mark;
        this.grid = grid;
    }

    // take the turn from the player 
    public void handleTurn() {
        System.out.println("Player " + name + "'s turn: (" + mark + ") ");
        takeInput();

        // handle if the cell chosen is already marked
        while (grid.getCell(row-1, column-1) != ' ') {
            System.out.println("THE CHOSEN CELL IS ALREADY MARKED");
            grid.displayGrid();
            takeInput();
        }

        // mark the chosen cell with the mark
        grid.markCell(row-1, column-1, mark);
        grid.displayGrid();
    }

    // saves the row and column the user inputs
    private void takeInput() {
        // take the row (X coordinate) for the chosen cell
        row = getValidInput("Enter row (1-3): ");
        // take the column (Y coordinate) for the chosen cell
        column = getValidInput("Enter column (1-3): ");
    }

    // gets the correct input for the row and column
    private int getValidInput(String prompt) {
        int input;
        while (true) {
            System.out.println(prompt);
            try {
                input = sc.nextInt();

                // handle if the row given is out of bounds
                if (input > Grid.GRID_SIZE || input < 1) {
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
        return input;
    }

    // to diplay player stats
    public void displayPlayer() {
        System.out.println("Name: " + name + " | Mark: " + mark);
    }

    // getters
    public String getName() {
        return name;
    }
    public char getMark() {
        return mark;
    }
    public Grid getGrid() {
        return grid;
    }

    // setters 
    public void setName(String newName) {
        name = newName;
    }
    public void setMark(char mark) {
        this.mark = mark;
    }
}
