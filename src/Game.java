import java.util.Arrays;
import java.util.Scanner;

/**
 * The Game class facilitates a board game where players take turns making moves
 * on an n x n board. It tracks the current state of the game board, player moves,
 * and winning conditions for rows, columns, and diagonals.
 */
public class Game {
    private int[] usedNumbers;
    private int[] columns;
    private int[] rows;
    private int diagonal;
    private int antiDiagonal;
    private int size;
    private Player[] players;
    private String[] board;
    public Game(int size, Player[] players) {
        this.size = size;
        usedNumbers = new int[size * size];
        diagonal = 0;
        antiDiagonal = 0;
        rows = new int[size];
        columns = new int[size];
        this.players = players;
        board = new String[size * size];
        Arrays.fill(board, ".");
        
    }
    /**
     * Processes a player's turn in the game. Prompts the current player for their move,
     * checks if the move is valid, and applies the move to the game board if valid.
     * Continues prompting until a valid move is made.
     *
     * @param playerTurn the index of the player whose turn it currently is
     * @return true if the player makes a move that results in a win condition; false otherwise
     */
    public boolean Turn(int playerTurn){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Player " + players[playerTurn].getName() + " what move would you like to make");
            printBoard();
            try {
                int input = Integer.valueOf(scanner.next());
                if (usedNumbers[input - 1] == input){
                    System.out.println("Someone has already picked that one");
                }else{
                    return (makeMove(players[playerTurn].getCharacterValue(), input, players[playerTurn].getPlayerNumber()));
                }

            } catch (Exception e) {
                System.out.println("Input not recognised");
            }

        }
    }
    /**
     * Executes a player's move in the game. Updates the game board and relevant
     * tracking variables, such as rows, columns, and diagonals, to reflect the
     * player's move. Evaluates whether the move results in a win condition.
     *
     * @param characterValue the numeric value representing the player's character (e.g., 1 or -1)
     * @param input the position on the board where the player wants to make their move
     *              (represented as a 1-based index)
     * @param playerNumber the index of the player making the move
     * @return true if the player's move results in a win condition; false otherwise
     */
    public boolean makeMove(int characterValue, int input, int playerNumber){
        usedNumbers[input-1] = input;
        board[input-1] = players[playerNumber].getCharacter();
        int row = (input - 1) / size;
        int column = (input - 1) % size;
        if (row == column) { // Primary diagonal condition
            diagonal = diagonal + characterValue;
        }
        if (row + column == size - 1) { // Anti-diagonal condition
            antiDiagonal = antiDiagonal + characterValue;
        }
        rows[row] = rows[row] + characterValue;
        columns[column] = columns[column] + characterValue;
        int checker = characterValue * size;
        return (rows[row] == (checker)) || (columns[column] == (checker))
                || (diagonal == (checker)) || (antiDiagonal == (checker));
    }
    /**
     * Prints the current state of the game board to the console.
     * Each row of the board is displayed, with elements separated by spaces.
     * Iterates through the entire board array and constructs each row based on the
     * dimension of the board (size x size).
     */
    public void printBoard(){
        for(int i = 0; i < size; i ++){
            String row = "";
            for(int j = 0; j < size; j ++) {
                row += board[i * size + j] + " ";
            }
            System.out.println(row);
        }
    }



}
