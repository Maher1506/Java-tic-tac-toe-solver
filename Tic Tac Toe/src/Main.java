public class Main {
    public static void main(String[] args) {
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
}
