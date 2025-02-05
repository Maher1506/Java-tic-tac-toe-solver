package Players;

import java.util.ArrayList;

import Enums.AIMode;
import GameLogic.Move;
import Grid.Grid;

public class AIPlayer extends Player {

    // 1 = random, 2 = beatable, 3 = unbeatable
    private AIMode aiMode;

    public AIPlayer(String name, char mark, Grid grid, AIMode aiMode) {
        super(name, mark, grid);
        this.aiMode = aiMode;
    }

    // handle the turn of the AI based on its mode
    @Override
    public void handleTurn() {
        System.out.println("AI's turn: (" + getMark() + ") ");

        switch (aiMode) {
            case RANDOM -> chooseRndMove();
            case BEATABLE -> beatableMode();
            case UNBEATABLE -> unbeatableMode();
        }

        getGrid().displayGrid();
        System.out.println("AI made its move");
    }

    // method to allow for mistakes by AI so the player can win
    // works by sometimes choosing the best move and sometimes choosing a random move
    public void beatableMode() {
        double rndFactor = Math.random();
        if (rndFactor > 0.6) {
            unbeatableMode();
        } else {
            chooseRndMove();
        }
    }

    // method to choose the best move to play (AI Impossible Bot)
    // this approach uses the Minimax algorithm to choose the move with the best possible outcome
    public void unbeatableMode() {
        Move bestMove = chooseBestMove(getGrid(), true, 0);
        getGrid().markCell(bestMove.getMove()[0], bestMove.getMove()[1], getMark());
    }
    private Move chooseBestMove(Grid state, boolean isMaximizingPlayer, int depth) {
        // teriminal state reached
        if (state.isTerminalState()) {
            char winnerMark = state.getWinnerMark(); // mark of winner
            // tie
            if (winnerMark == '\0') { 
                return new Move(0, null, depth); 
            }
            // the AI won
            else if (winnerMark == getMark()) { 
                return new Move(1, null, depth); 
            }
            // the opponent won
            else {
                return new Move(-1, null, depth); 
            }
        }

        // if the turn of the MAX player (AI's turn)
        if (isMaximizingPlayer) {
            // worst possible case
            Move bestMove = new Move(Integer.MIN_VALUE, null, depth); 
            // loop through every possible move
            for (int[] move : state.getAvailableMoves()) {
                // apply move on the current state and save it as new state
                Grid newState = new Grid(state);
                newState.markCell(move[0], move[1], getMark());

                // get the score of every move recursviely
                Move currentMove = chooseBestMove(newState, false, depth+1);
                // update the best move if current move has better score or same score but better depth
                if (currentMove.getScore() > bestMove.getScore() ||
                    (currentMove.getScore() == bestMove.getScore() && currentMove.getDepth() < bestMove.getDepth())) {
                    bestMove = new Move(currentMove.getScore(), move, depth);
                }
            }
            return bestMove;
        }

        // if the turn of the MIN player (Opponnent's turn)
        else {
            // worst possible case
            Move bestMove = new Move(Integer.MAX_VALUE, null, depth);
            // loop through every possible move
            for (int[] move : state.getAvailableMoves()) {
                // apply move on the current state and save it as new state
                Grid newState = new Grid(state);
                newState.markCell(move[0], move[1], getOpponentMark());

                // get the score of every move recursviely
                Move currentMove = chooseBestMove(newState, true, depth+1);
                // update the best move if current move has better score or same score but better depth
                if (currentMove.getScore() < bestMove.getScore() ||
                    (currentMove.getScore() == bestMove.getScore() && currentMove.getDepth() < bestMove.getDepth())) {
                    bestMove = new Move(currentMove.getScore(), move, depth);
                }        }
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
