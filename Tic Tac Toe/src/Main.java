import GameLogic.Game;
import Grid.Grid;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        Game game = new Game(grid);

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
}
