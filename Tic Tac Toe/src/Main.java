import java.util.Scanner;

import GameLogic.Game;
import Grid.Grid;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        //main game loop
        while (true) {
            Grid grid = new Grid();
            Game game = new Game(grid);

            game.displayStats();
            grid.displayGrid();

            // alternate turns while game is in progress
            while (!game.isGameOver()) {
                // handle player 1's turn
                game.getPlayer1().handleTurn();

                if (game.isGameOver()) { break; }

                // handle player 2's turn
                game.getPlayer2().handleTurn();
            }
            
            game.displayFinalGameState();

            String input = replay();
            if (!input.equals("1")) {
                break;
            }
        }
    }

    private static String replay() {
        System.out.println("Do you want to replay? ");
        System.out.println("To replay press 1 to exit press any other key: ");

        String input = sc.nextLine();
        return input;
    }
}
