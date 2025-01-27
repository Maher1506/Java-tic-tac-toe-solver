public class Player {

    private int score;
    private String name;

    Player(String name) {
        this.score = 0;
        this.name = name;
    }

    // to diplay player stats
    public void displayPlayer() {
        System.out.println("Name: " + name + " Score: " + score);
    }

    //getters
    public int getScore() {
        return score;
    }
    public String getName() {
        return name;
    }

    // setters
    public void setScore(int newScore) {
        score = newScore;
    } 
    public void setName(String newName) {
        name = newName;
    }
}
