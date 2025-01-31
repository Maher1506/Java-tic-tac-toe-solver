package Players;

import java.util.ArrayList;

import GameLogic.MoveScore;
import Grid.Grid;

public class AIPlayer extends Player {

    public AIPlayer(String name, char mark, Grid grid) {
        super(name, mark, grid);
    }

    // handle the turn of the AI based on its mode
    @Override
    public void handleTurn() {
        System.out.println("AI's turn: (" + getMark() + ") ");

        //chooseRndMove();
        chooseBestMove();
        getGrid().displayGrid();

        System.out.println("AI made its move");
    }

    // method to choose the best move to play (AI Impossible Bot)
    // this approach uses the Minimax algorithm to choose the move with the best possible outcome
    public void chooseBestMove() {
        MoveScore bestMove = chooseBestMoveHelper(getGrid(), true, 0);
        getGrid().markCell(bestMove.getMove()[0], bestMove.getMove()[1], getMark());
    }
    private MoveScore chooseBestMoveHelper(Grid state, boolean isMaximizingPlayer, int depth) {
        //System.out.println("depth: " + depth);
        //state.displayGrid();

        // teriminal state reached
        if (state.isTerminalState()) {
            char winnerMark = state.getWinnerMark(); // mark of winner
            // tie
            if (winnerMark == '\0') { 
                return new MoveScore(0, null); 
            }
            // the AI won
            else if (winnerMark == getMark()) { 
                return new MoveScore(1, null); 
            }
            // the opponent won
            else {
                return new MoveScore(-1, null); 
            }
        }

        // if the turn of the MAX player (AI's turn)
        if (isMaximizingPlayer) {
            // worst possible case
            MoveScore bestMove = new MoveScore(Integer.MIN_VALUE, null); 
            // loop through every possible move
            for (int[] move : state.getAvailableMoves()) {
                // apply move on the current state and save it as new state
                Grid newState = new Grid(state);
                newState.markCell(move[0], move[1], getMark());

                // get the score of every move recursviely
                MoveScore currentMove = chooseBestMoveHelper(newState, false, depth+1);
                // update the best move of current move is better
                if (currentMove.getScore() > bestMove.getScore()) {
                    bestMove = new MoveScore(currentMove.getScore(), move);
                }
            }
            return bestMove;
        }

        // if the turn of the MIN player (Opponnent's turn)
        else {
            // worst possible case
            MoveScore bestMove = new MoveScore(Integer.MAX_VALUE, null);
            // loop through every possible move
            for (int[] move : state.getAvailableMoves()) {
                // apply move on the current state and save it as new state
                Grid newState = new Grid(state);
                newState.markCell(move[0], move[1], getOpponentMark());

                // get the score of every move recursviely
                MoveScore currentMove = chooseBestMoveHelper(newState, true, depth+1);
                // update the best move of current move is better
                if (currentMove.getScore() < bestMove.getScore()) {
                    bestMove = new MoveScore(currentMove.getScore(), move);
                }            }
            return bestMove;
        }
    }

    // method to choose a random move to play (AI Random Bot)
    private void chooseRndMove() {
        ArrayList<int[]> availableMoves = getGrid().getAvailableMoves();

        int rndMove = (int) (Math.random() * availableMoves.size());
        int[] move = availableMoves.get(rndMove);

        getGrid().markCell(move[0], move[1], getMark());
    }
}
