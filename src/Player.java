/**
 * The Player class represents a player in the game with attributes such as
 * name, character, numeric value corresponding to the character, and a unique
 * player number. It also provides methods to get and set these attributes.
 */
public class Player {
    String name;
    String character;
    int characterValue;
    int playerNumber;
    public Player(String name, String character, int characterValue, int playerNumber){
        this.name = name;
        this.character = character;
        this.characterValue = characterValue;
        this.playerNumber = playerNumber;

    }
    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getCharacterValue() {
        return characterValue;
    }

    public void setCharacterValue(int characterValue) {
        this.characterValue = characterValue;
    }
}
