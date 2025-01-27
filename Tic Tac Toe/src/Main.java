public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();

        Player p1 = new Player("P1", 'X');
        Player p2 = new Player("P2", 'O');
        AIPlayer AI = new AIPlayer("AI", 'O', grid);

        Game game = new Game(grid, p1, AI);

        game.displayStats();
        grid.displayGrid();

        // DISPLAYS ALL AVAILABLE MOVES
        /*for (int[] move : grid.getAvailableMoves()) {
            for (int i = 0; i < 2; i++) {
                System.out.print(move[i] + ", ");
            }
            System.out.println();
        }*/

        // main game loop (P v P)
        // while (!game.isGameOver()) {
        //     // handle player 1's turn
        //     game.handlePlayerTurn(p1);
        //     grid.displayGrid();

        //     if (game.isGameOver()) { break; }

        //     // handle player 2's turn
        //     game.handlePlayerTurn(p2);
        //     grid.displayGrid();
        // }

        while (!game.isGameOver()) {
            // handle player 1's turn
            game.handlePlayerTurn(p1);
            
            if (game.isGameOver()) { break; }

            // handle player 2's turn
            AI.chooseRndMove();
        }
        
        game.displayFinalGameState();
    }
}
