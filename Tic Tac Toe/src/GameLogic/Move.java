package GameLogic;
public class Move {
    
    int[] move;
    int score;
    int depth;

    public Move(int score, int[] move, int depth) {
        this.move = move;
        this.score = score;
        this.depth = depth;
    }

    public int getScore() {
        return score;
    }
    public int[] getMove() {
        return move;
    }
    public int getDepth() {
        return depth;
    }
}
