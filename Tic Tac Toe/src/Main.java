import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //mainMenu();

        Grid grid = new Grid();

        Player p1 = new Player("P1", 'X', grid);
        Player p2 = new Player("P2", 'O', grid);
        AIPlayer AI = new AIPlayer("AI", 'O', grid);

        Game game = new Game(grid, p1, AI);

        game.displayStats();
        grid.displayGrid();

        //main game loop (P v P)
        while (!game.isGameOver()) {
            // handle player 1's turn
            game.getPlayer1().handleTurn();

            if (game.isGameOver()) { break; }

            // handle player 2's turn
            game.getPlayer2().handleTurn();
        }
        
        game.displayFinalGameState();

        // DISPLAYS ALL AVAILABLE MOVES
        /*for (int[] move : grid.getAvailableMoves()) {
            for (int i = 0; i < 2; i++) {
                System.out.print(move[i] + ", ");
            }
            System.out.println();
        }*/
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
