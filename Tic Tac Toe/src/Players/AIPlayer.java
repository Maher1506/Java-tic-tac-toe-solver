package Players;

import java.lang.reflect.Array;
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

    // method to choose the best move to play (AI Impossible Bot)
    // this approach uses the Minimax algorithm to choose the move with the best possible outcome
    public void chooseBestMove() {
        ArrayList<int[]> availableMoves = getGrid().getAvailableMoves();
        Grid grid = getGrid();


    }
    /*private int[] chooseBestMoveHelper(ArrayList<int[]> moves, Grid grid, ) {

    }*/

    // method to choose a random move to play (AI Random Bot)
    private void chooseRndMove() {
        ArrayList<int[]> availableMoves = getGrid().getAvailableMoves();

        int rndMove = (int) (Math.random() * availableMoves.size());
        int[] move = availableMoves.get(rndMove);

        getGrid().markCell(move[0], move[1], getMark());
    }
}
