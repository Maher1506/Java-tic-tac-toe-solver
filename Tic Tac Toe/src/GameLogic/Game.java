package GameLogic;
import java.util.InputMismatchException;
import java.util.Scanner;

import Enums.AIMode;
import Grid.Grid;
import Players.AIPlayer;
import Players.HumanPlayer;
import Players.Player;

public class Game {

    private Grid grid;
    private Player player1;
    private Player player2;

    // for finding the winner
    private Player winnerPlayer;
    private boolean isPlayer1Starting;

    private Scanner sc = new Scanner(System.in); // for input
    
    public Game(Grid grid) {
        this.grid = grid;

        player1 = new HumanPlayer("Player 1", 'X', grid);
        // set the name of the first player
        setPlayerName(player1);

        setMode();
        setPlayerOrder();
        setPlayerMarks();
    }

    // method to set the mode whether vs AI or vs another player
    private void setMode() {
        int mode = getMode();
        // player chose to play against AI
        if (mode == 1) {
            // choose AI mode
            int aiMode = getAIMode();
            if (aiMode == 1) {
                player2 = new AIPlayer("AI", 'O', grid, AIMode.RANDOM);
            } else if (aiMode == 2) {
                player2 = new AIPlayer("AI", 'O', grid, AIMode.BEATABLE);
            } else if (aiMode == 3) {
                player2 = new AIPlayer("AI", 'O', grid, AIMode.UNBEATABLE);
            }
        } else { // player chose to play agains another player
            player2 = new HumanPlayer("player 2", 'O', grid);

            // set the name of the second player
            sc.nextLine(); // clear buffer
            setPlayerName(player2);
        }

    }

    // method to set player marks based on the order
    private void setPlayerMarks() {
        if (isPlayer1Starting) {
            player1.setMark('X');
            player2.setMark('O');
        } else {
            player1.setMark('O');
            player2.setMark('X');
        }
    }

    // method for the player to chose who starts
    private void setPlayerOrder() {
        System.out.println("Would you like to start " + player1.getName() + "?");
        System.out.println("Press 1 if so press 2 if not");

        int input;
        while (true) {  
            try {
                input = sc.nextInt();

                if (input > 2 || input < 1) {
                    System.out.println("OUT OF BOUNDS");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("INCORRECT INPUT (ENTER INTEGER)");
                sc.nextLine(); // clear buffer for next input
            }
        } 
        if (input == 1) {
            isPlayer1Starting = true;
        } else {
            isPlayer1Starting = false;
        }
    }

    // sets the players name from input
    private void setPlayerName(Player p) {
        System.out.println("Enter Name: ");        
        String name = sc.nextLine();
        p.setName(name);
    }

    // acts as a main menu
    // based on the mode, the game will either assign p2 to a new player or an AI
    private int getMode() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("To play against an AI press 1 ");
        System.out.println("To play against another player press 2 ");

        int input;
        while (true) { 
            try {
                input = sc.nextInt();

                if (input > 2 || input < 1) {
                    System.out.println("OUT OF BOUNDS");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("INCORRECT INPUT (ENTER INTEGER)");
                sc.nextLine(); // clear buffer for next input
            }
        }
        return input;
    }

    // gets the mode of the AI based on player input
    private int getAIMode() {
        System.out.println("To play against a Random AI press 1 ");
        System.out.println("To play against a Beatable AI press 2 ");
        System.out.println("To play against an Unbeatable AI press 3 ");

        int input;
        while (true) {
            try {
                input = sc.nextInt();

                if (input < 1 || input > 3) {
                    System.out.println("OUT OF BOUNDS");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("INCORRECT INPUT (ENTER INTEGER)");
                sc.nextLine(); // clear buffer for next input
            }
        }
        return input;
    }

    // checks whether the game is finished
    public boolean isGameOver() {
        return grid.isGameWon() || grid.isFull();
    }

    // display the winner and loser or display if there is a tie
    public void displayFinalGameState() {
        System.out.println();

        if (grid.getWinnerMark() == 'X') {
            findWinnerPlayer();
            System.out.println("Player: " + winnerPlayer.getName() + " Won!");
        } else if (grid.getWinnerMark()  == 'O') {
            findWinnerPlayer();
            System.out.println("Player: " + winnerPlayer.getName() + " Won!");
        } else {
            System.out.println("Game is a Tie!");
        }
    }

    // method to find which player won from the winner mark
    private void findWinnerPlayer() {
        if (grid.getWinnerMark()  == player1.getMark()) {
            winnerPlayer = player1;
        } else {
            winnerPlayer = player2;
        }
    }

    // displays each player's name along with his/her mark at the start
    public void displayStats() {
        player1.displayPlayer();
        player2.displayPlayer();
    }
    
    // getters
    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public boolean isPlayerOneStarting() {
        return isPlayer1Starting;
    }
}
