import java.util.InputMismatchException;
import java.util.Scanner;

import GameLogic.Game;
import Grid.Grid;
import Players.AIPlayer;
import Players.HumanPlayer;

public class Main {
    public static void main(String[] args) {
        //mainMenu();

        Grid grid = new Grid();

        HumanPlayer p1 = new HumanPlayer("P1", 'X', grid);
        HumanPlayer p2 = new HumanPlayer("P2", 'O', grid);

        AIPlayer AI1 = new AIPlayer("AI", 'O', grid);
        AIPlayer AI2 = new AIPlayer("AI", 'X', grid);

        Game game = new Game(grid, AI2, AI1);

        game.displayStats();
        grid.displayGrid();

        //main game loop
        while (!game.isGameOver()) {
            // handle player 1's turn
            game.getPlayer1().handleTurn();

            if (game.isGameOver()) { break; }

            // handle player 2's turn
            game.getPlayer2().handleTurn();
        }
        
        game.displayFinalGameState();
    }

    // needs to be moved in the Game class constructor.
    // based on the mode, the game will either assign p2 to a new player or an AI
    private static void mainMenu() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("To play against an AI press 1 ");
        System.out.println("To play against another player press 2 ");

        Scanner sc = new Scanner(System.in);
        int input;
        while (true) { 
            try {
                input = sc.nextInt();

                if (input > 2 || input < 1) {
                    System.out.println("OUT OF BOUNDS");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {

            }
        }
    }
}
