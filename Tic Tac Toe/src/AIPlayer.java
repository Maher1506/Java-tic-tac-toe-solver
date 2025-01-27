import java.util.ArrayList;

public class AIPlayer extends Player {

    private Grid grid;

    public AIPlayer(String name, char mark, Grid grid) {
        super(name, mark);
        this.grid = grid;
    }

    // method to choose a random move to play
    public void chooseRndMove() {
        System.out.println("AI's turn: (" + getMark() + ") ");

        ArrayList<int[]> availableMoves = grid.getAvailableMoves();

        int rndMove = (int) (Math.random() * availableMoves.size());
        int[] move = availableMoves.get(rndMove);

        grid.markCell(move[0], move[1], getMark());
        grid.displayGrid();

        System.out.println("AI made its move");
    }
}
