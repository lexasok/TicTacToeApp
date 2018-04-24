import java.util.Scanner;

public class TicTacToeApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean doYouWantToPlay = true;
        while (doYouWantToPlay) {
            System.out.println("Are you ready?\n");
            System.out.println("Pic your character: ");
            char playerToken = sc.next().charAt(0);

            System.out.println("Pic my character: ");
            char aiToken = sc.next().charAt(0);

            TicTacToe game = new TicTacToe(playerToken, aiToken);
            Ai ai = new Ai();
        }
    }
}
