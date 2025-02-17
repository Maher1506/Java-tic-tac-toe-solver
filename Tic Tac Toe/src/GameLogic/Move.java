package GameLogic;
public class Move {
    
    int[] move;
    int score;

    public Move(int score, int[] move) {
        this.move = move;
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    public int[] getMove() {
        return move;
    }
}
