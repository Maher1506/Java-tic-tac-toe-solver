public class Player {

    private String name;
    private char mark;

    Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    // to diplay player stats
    public void displayPlayer() {
        System.out.println("Name: " + name + " | Mark: " + mark);
    }

    // getters
    public String getName() {
        return name;
    }
    public char getMark() {
        return mark;
    }

    // setters 
    public void setName(String newName) {
        name = newName;
    }
    public void setMark(char mark) {
        this.mark = mark;
    }
}
