package Players;

import java.util.InputMismatchException;
import java.util.Scanner;

import Grid.Grid;

public class HumanPlayer extends Player {

    // for handling the player's input
    private int row;
    private int column;
    private Scanner sc = new Scanner(System.in);

    public HumanPlayer(String name, char mark, Grid grid) {
        super(name, mark, grid);
    }

    // take the turn from the player 
    @Override
    public void handleTurn() {
        System.out.println("Player " + getName() + "'s turn: (" + getMark() + ") ");
        takeInput();

        // handle if the cell chosen is already marked
        while (getGrid().getCell(row-1, column-1) != ' ') {
            System.out.println("THE CHOSEN CELL IS ALREADY MARKED");
            getGrid().displayGrid();
            takeInput();
        }

        // mark the chosen cell with the mark
        getGrid().markCell(row-1, column-1, getMark());
        getGrid().displayGrid();
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
}
