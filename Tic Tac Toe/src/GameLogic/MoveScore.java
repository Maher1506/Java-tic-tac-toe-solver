package GameLogic;
public class MoveScore {
    
    int[] move;
    int score;

    public MoveScore(int score, int[] move) {
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
