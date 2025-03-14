import java.util.Scanner;

import GameLogic.Game;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        gameLoop();
    }

    private static void gameLoop() {
        //main game loop
        while (true) {
            Game game = new Game();

            game.displayStats();
            game.getGrid().displayGrid();

            // alternate turns while game is in progress
            while (!game.isGameOver()) {
                if (game.isPlayerOneStarting()) {
                    // handle player 1's turn
                    game.getPlayer1().handleTurn();

                    if (game.isGameOver()) { break; }

                    // handle player 2's turn
                    game.getPlayer2().handleTurn();
                } else {
                    // handle player 2's turn
                    game.getPlayer2().handleTurn();

                    if (game.isGameOver()) { break; }

                    // handle player 1's turn
                    game.getPlayer1().handleTurn();
                }
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
