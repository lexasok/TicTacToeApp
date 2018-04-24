import java.util.ArrayList;
import java.util.Random;

public class Ai {
    public int picSpot(TicTacToe game) {
        ArrayList<Integer> choices = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            if (game.board[i] == '-') {
                choices.add(i + 1);
            }
        }
        Random random = new Random();
        int choice = choices.get(Math.abs(random.nextInt() % choices.size()));

        return choice;
    }
}
