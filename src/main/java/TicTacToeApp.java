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


            System.out.println("The game started!\n");
            TicTacToe.printIndexBoard();

            System.out.println("\nEnter number of spot, where you want to put your token:\n");

            while (game.gameOver().equals("notOver")) {
                if (game.currentMarker == game.userMarker) {
                    System.out.println("Your turn!\n");
                    int spot = sc.nextInt();
                    while (!game.playTurn(spot)) {
                        System.out.println("Try again! " + spot + " is invalid.\n");
                        spot = sc.nextInt();
                    }
                    System.out.println(" You picked: " + spot + "!");
                } else {
                    System.out.println("It's my turn!");
                    int aiSpot = ai.picSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked: " + aiSpot + "!");
                }
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            System.out.println("Play again& Y - yes! :");
            if (sc.next().charAt(0) != 'Y') {
                doYouWantToPlay = false;
                sc.close();
            }
            System.out.println();
            System.out.println();
            System.out.println();

        }
    }
}
