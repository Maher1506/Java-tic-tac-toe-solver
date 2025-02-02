# Tic-Tac-Toe AI

A Java-based Tic-Tac-Toe game with AI opponents of varying difficulty levels, including Random, Beatable, and Unbeatable AI using the Minimax algorithm. Players can compete against another human or different AI modes.

## 🏆 Features 

-  **Play Against AI or a Human Opponent**  
-  **Multiple AI Difficulty Levels**:  
  - **Random AI**  (Picks moves randomly)  
  - **Beatable AI**  (Makes some mistakes)  
  - **Unbeatable AI**  (Uses the Minimax algorithm)  
-  **Console-based UI**  
-  **Modular and Extensible Codebase**  

## 🎮 How to Play 

1. **Run the game** and enter the name of the player
2. **Choose the Game mode** select **1** to play against AI or **2** to play against another Human player.
3. If playing against AI, choose difficulty:  
   - **1** - Random AI 
   - **2** - Beatable AI  
   - **3** - Unbeatable AI (Minimax)
4. If playing against another Human, enter his name
5. **Enter your move** by selecting a row and column (1-3).
6. The **game ends** when a player wins or the board is full (draw).
7. **To replay the game** enter **1** or enter any other key **to exit**
8. **Enjoy playing!** 🎉

## 📂 Project Structure
- **src/**
  - **GameLogic/**
    - `Game.java` → Game management
    - `MoveScore.java` → Represents move evaluation in Minimax
  - **Grid/**
    - `Grid.java` → Represents the Tic-Tac-Toe board
  - **Players/**
    - `Player.java` → Base abstract class for all players
    - `HumanPlayer.java` → Handles human player input
    - `AIPlayer.java` → AI player with Minimax & difficulty levels
  - **Enums/**
    - `AIMode.java` → Enum for AI difficulty modes (RANDOM, BEATABLE, UNBEATABLE)
  - `Main.java` → Main game loop and entry point of the game

## :robot: AI Implementation

The **Unbeatable AI** uses the **Minimax Algorithm** to find the best move by:
1. Finding all possible moves
2. Alternating between MIN and MAX opponents
3. Assigning each terminal state a value
   - +1 for a WIN
   - -1 for a LOSS
   - 0 for a TIE
4. Backtracking to choose the move with the highest score

## 📌Future Improvements
- Add depth to the best move to choose the fastest move to win
- Add alpha-beta pruning for optimization

## References and Resources
- https://en.wikipedia.org/wiki/Minimax
- [Minimax Algorithm for Tic Tac Toe (Coding Challenge 154)](https://www.youtube.com/watch?v=trKjYdBASyQ&t=3s)
- https://victorz.ca/game/t3
- My OneNote Note on Minimax algorithm: [Minimax Algorithm.pdf](https://github.com/user-attachments/files/18633236/Minimax.Algorithm.pdf)


