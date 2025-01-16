import java.util.Objects;
import java.util.Scanner;
/**
 * The Main class serves as the entry point for the game application. It provides functionality for initializing the game,
 * collecting user inputs for the game setup, and managing the gameplay loop.
 */
public class Main {
    /**
     * Main entry point for the application. This method initializes the game,
     * handles player setup (names and character assignment), and manages the
     * game session loop to allow multiple rounds of gameplay.
     *
     * @param args command-line arguments passed to the program
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Noughts and Crosses");
        boolean hasPlayed = false;
        int size = 0;
        Player[] players = null;
        outerLoop:
        while (true) {
            if(!hasPlayed){
                size = initializeSize(scanner);
                players = initializePlayersList(scanner);
                Game game = new Game(size, players);
                startGame(game, size);
            } else {
                Game game = new Game(size, players);
                startGame(game, size);
            }

            while (true) {
                System.out.println("Would you like to play again (Y/N)");
                String input = scanner.nextLine();
                if (Objects.equals(input, "Y") || Objects.equals(input, "y")) {
                    while (true) {
                        System.out.println("Would you like to change the settings?(Y/N)");
                        input = scanner.nextLine();
                        if (Objects.equals(input, "Y") || Objects.equals(input, "y")) {
                            hasPlayed = false;
                            break;
                        } else if (Objects.equals(input, "N") || Objects.equals(input, "n")) {
                            hasPlayed = true;
                            break;
                        } else {
                            System.out.println("Didn't recognise input");
                        }
                    }
                    break;
                } else if (Objects.equals(input, "N") || Objects.equals(input, "n")) {
                    break outerLoop;
                } else {
                    System.out.println("Didn't recognise input");
                }
            }
        }
    }

    /**
     * Starts the game for the given size and manages player turns.
     * The method iterates through the turns of the game, allowing each player
     * to make a move, and checks for a win condition after each turn.
     *
     * @param game the Game object representing the game instance to be played
     * @param size the size of the game board (e.g., a size of 3 would imply a 3x3 board)
     */
    public static void startGame(Game game, int size){
        System.out.println("Enjoy the game");
        for(int i = 0; i <= size * size; i ++){
            if(game.Turn(i % 2)){
                game.printBoard();
                System.out.println("Player " + (i % 2 + 1) + " won");
                break;
            }
        }
    }
    /**
     * Initializes a player by prompting the user for a valid name and character.
     * Ensures the name and character are unique and not empty, and returns a new
     * Player object with the specified attributes.
     *
     * @param otherName the name of the other player to ensure uniqueness
     * @param otherCharacter the character of the other player to ensure uniqueness
     * @param scanner the scanner object used for user input
     * @param characterValue the numeric value associated with the player's character
     * @param playerNumber the index or number of the player being initialized
     * @return a Player object representing the initialized player
     */
    public static Player initializePlayers(String otherName, String otherCharacter, Scanner scanner, int characterValue,int playerNumber){
        String name;
        while (true) {
            System.out.println("What would you like player " + (playerNumber + 1) + " to be called");
            name = scanner.nextLine();
            if(name.equals(otherName) || name.isEmpty()) {
                System.out.println("Invalid input name is the same as player one");
            } else{
                break;
            }
        }
        String character;
        while (true) {
            System.out.println("What would you like their character to be called");
            character = scanner.nextLine();
            if (character.length() > 1 || character.equals(otherCharacter) || character.isEmpty()) {
                System.out.println("Invalid input");
            } else {
                break;
            }

        }
        return new Player(name, character, characterValue, playerNumber);
    }
    /**
     * Prompts the user to input the size of a game board and validates the input.
     * The method ensures the size is within the acceptable range [1, 10].
     * Re-prompts the user in case of invalid input.
     *
     * @param scanner the Scanner object used to read user input
     * @return the validated board size as an integer
     */
    public static int initializeSize(Scanner scanner){
        while (true) {
            try {
                System.out.println("What size board would you like to play on?");
                int size = Integer.valueOf(scanner.nextLine());
                if (size < 1 || size > 10) {
                    throw new NumberFormatException();
                }

                return size;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }



    }
    /**
     * Initializes a list of players by calling the `initializePlayers` method
     * twice to set up two players. Ensures that the player names and characters are
     * unique and properly validated through user input.
     *
     * @param scanner the Scanner object used to read user input during the player setup
     * @return an array of Player objects containing the two initialized players
     */
    public static Player[] initializePlayersList(Scanner scanner) {
        Player playerOne = initializePlayers("", "", scanner, 1, 0);
        Player playerTwo = initializePlayers(playerOne.getName(), playerOne.getCharacter(), scanner, -1, 1);
        return new Player[] {playerOne, playerTwo};
    }


}