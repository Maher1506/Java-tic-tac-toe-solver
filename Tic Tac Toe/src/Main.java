public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        Grid grid = new Grid();

        Game game = new Game(grid, p1, p2);

        grid.displayGrid();
        // main game loop
        while (!game.isGameOver()) {

        }
    }
}
