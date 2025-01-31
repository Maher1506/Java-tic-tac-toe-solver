package Players;

import Grid.Grid;

public abstract class Player {

    private String name;
    private char mark;
    private Grid grid;

    public Player(String name, char mark, Grid grid) {
        this.name = name;
        this.mark = mark;
        this.grid = grid;
    }

    // method to be implemented to handle the turn 
    public abstract void handleTurn();

    // to diplay player stats
    public void displayPlayer() {
        System.out.println("Name: " + name + " | Mark: " + mark);
    }

    // to get the mark of the opponent
    public char getOpponentMark() {
        if (mark == 'X') { 
            return '0'; 
        }
        else {
            return 'X';
        }
    }

    // getters
    public String getName() {
        return name;
    }
    public char getMark() {
        return mark;
    }
    public Grid getGrid() {
        return grid;
    }

    // setters 
    public void setName(String newName) {
        name = newName;
    }
    public void setMark(char mark) {
        this.mark = mark;
    }
}
