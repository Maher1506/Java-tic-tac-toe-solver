package Players;

import java.util.ArrayList;

import Grid.Grid;

public class AIPlayer extends Player {

    public AIPlayer(String name, char mark, Grid grid) {
        super(name, mark, grid);
    }

    // handle the turn of the AI based on its mode
    @Override
    public void handleTurn() {
        System.out.println("AI's turn: (" + getMark() + ") ");

        chooseRndMove();
        getGrid().displayGrid();

        System.out.println("AI made its move");
    }

    // method to choose a random move to play
    private void chooseRndMove() {
        ArrayList<int[]> availableMoves = getGrid().getAvailableMoves();

        int rndMove = (int) (Math.random() * availableMoves.size());
        int[] move = availableMoves.get(rndMove);

        getGrid().markCell(move[0], move[1], getMark());
    }
}
