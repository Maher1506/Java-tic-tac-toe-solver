public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("P1", 'X');
        Player p2 = new Player("P2", 'O');
        Grid grid = new Grid();

        Game game = new Game(grid, p1, p2);

        game.displayStats();
        grid.displayGrid();

        // DISPLAYS ALL AVAILABLE MOVES
        /*for (int[] move : grid.getAvailableMoves()) {
            for (int i = 0; i < 2; i++) {
                System.out.print(move[i] + ", ");
            }
            System.out.println();
        }*/

        // main game loop
        while (!game.isGameOver()) {
            // handle player 1's turn
            game.handlePlayerTurn(p1);
            grid.displayGrid();
            if (game.isGameOver()) { break; }

            // handle player 2's turn
            game.handlePlayerTurn(p2);
            grid.displayGrid();
        }
        
        game.displayFinalGameState();
    }
}
