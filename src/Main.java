import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> game = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            game.add(".");
        }
        startGame(game, scanner);
        while(true){
            System.out.println("Would you like to play again (Y/N)");
            if(scanner.next() == "Y"){
                startGame(game, scanner);
            } else{
                break;
            }
        }

    }
    public static void startGame(ArrayList<String> game, Scanner scanner){
        printGame(game);
        for(int i = 0; i < 5 ; i++) {
            System.out.println("Player 1 what move would you like to make");
            int input = Integer.valueOf(scanner.next());
            game.set((input - 1), "X");
            printGame(game);
            if(checkIfWin(game, input - 1)){
                System.out.println("PLayer 1 wins");
                break;
            }
            if (i == 4){
                System.out.println("The game is a draw");
                break;
            }
            System.out.println("Player 2 what move would you like to make");
            input = Integer.valueOf(scanner.next());
            game.set((input - 1), "O");
            printGame(game);
            if(checkIfWin(game, input - 1)){
                System.out.println("PLayer 2 wins");
                break;
            }
        }
    }
    static void printGame(ArrayList<String> game){
        System.out.println(game.get(0) + " " + game.get(1) + " " + game.get(2));
        System.out.println(game.get(3) + " " + game.get(4) + " " + game.get(5));
        System.out.println(game.get(6) + " " + game.get(7) + " " + game.get(8));
    }
    static void resetGame(ArrayList<String> game){
        for (int i = 0; i < 9; i++) {
            game.set(i , ".");

        }
    }
    static boolean checkIfWin(ArrayList<String> game, int move) {
        if(move == 0){
                if ((game.get(1) == game.get(move) && game.get(2) == game.get(move)) ||
                        (game.get(3) == game.get(move) && game.get(6) == game.get(move)) ||
                        (game.get(4) == game.get(move) && game.get(8) == game.get(move))){
                    return true;
            }
            return false;
        }
        if(move == 1){
            if ((game.get(4) == game.get(move) && game.get(7) == game.get(move)) ||
                    (game.get(0) == game.get(move) && game.get(2) == game.get(move))){
                return true;
            }
            return false;
        }
        if(move == 2){
            if ((game.get(0) == game.get(move) && game.get(1) == game.get(move)) ||
                    (game.get(5) == game.get(move) && game.get(8) == game.get(move)) ||
                    (game.get(4) == game.get(move) && game.get(6) == game.get(move))){
                return true;
            }
            return false;
        }
        if(move == 3){
            if ((game.get(4) == game.get(move) && game.get(5) == game.get(move)) ||
                    (game.get(0) == game.get(move) && game.get(6) == game.get(move))){
                return true;
            }
            return false;
        }
        if(move == 4){
            if ((game.get(1) == game.get(move) && game.get(7) == game.get(move)) ||
                    (game.get(3) == game.get(move) && game.get(5) == game.get(move)) ||
                    (game.get(6) == game.get(move) && game.get(2) == game.get(move)) ||
                    (game.get(0) == game.get(move) && game.get(8) == game.get(move))){
                return true;
            }
            return false;
        }
        if(move == 5){
            if ((game.get(2) == game.get(move) && game.get(8) == game.get(move)) ||
                    (game.get(3) == game.get(move) && game.get(4) == game.get(move))){
                return true;
            }
            return false;
        }
        if(move == 6){
            if ((game.get(7) == game.get(move) && game.get(8) == game.get(move)) ||
                    (game.get(0) == game.get(move) && game.get(3) == game.get(move)) ||
                    (game.get(2) == game.get(move) && game.get(4) == game.get(move))){
                return true;
            }
            return false;
        }
        if(move == 7){
            if ((game.get(1) == game.get(move) && game.get(4) == game.get(move)) ||
                    (game.get(6) == game.get(move) && game.get(8) == game.get(move))){
                return true;
            }
            return false;
        }
        if(move == 8){
            if ((game.get(6) == game.get(move) && game.get(7) == game.get(move)) ||
                    (game.get(2) == game.get(move) && game.get(5) == game.get(move)) ||
                    (game.get(0) == game.get(move) && game.get(4) == game.get(move))){
                return true;
            }
            return false;
        }
        return false;

    }
}