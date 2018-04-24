public class TicTacToe {

    protected char[] board;
    protected char userMarker;
    protected char aiMarker;
    protected char winner;
    protected char currentMarker;

    public TicTacToe(char playerToken, char aiMarker) {
        userMarker = playerToken;
        this.aiMarker = aiMarker;
        this.winner = '-';
        this.board = setBoard();
    }

    public static char[] setBoard() {
        char[] board = new char[9];
        for (int i = 0; i < board.length; i ++) {
            board[i] = '-';
        }
        return board;
    }

    public boolean playTurn(int spot) {
        boolean isValid = withRange(spot) && !isSpotTaken(spot);
        if (isValid) {
            board[spot - 1] = currentMarker;
            currentMarker = (currentMarker == userMarker) ? aiMarker : userMarker;
        }
        return isValid;
    }

    public boolean isSpotTaken(int spot) {
        return board[spot - 1] == '-';
    }

    public boolean withRange(int spot) {
        return spot > 0 && spot < board.length + 1;
    }

    public void printBoard() {
        System.out.println();
        for (int i = 0; i < board.length; i ++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
                System.out.println("--------------");
            }
            System.out.print(" | " + board[i]);
        }
        System.out.println();
    }

    public void printIndexBoard() {
        System.out.println();
        for (int i = 0; i < board.length; i ++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
                System.out.println("--------------");
            }
            System.out.print(" | " + (i + 1));
        }
        System.out.println();
    }

    public boolean isThereAWinner() {
        boolean diagonalsAndMiddles = rightDi() || leftDi() || middleRow() || secondCol() && board[4] != '-';
        boolean topAndFirst = topRow() || firstCol() && board[0] != '-';
        boolean bottomAndThird = bottomRow() || thirdCol && board[8] != '-';

        if (diagonalsAndMiddles) {
            this.winner = board[4];
        } else if (topAndFirst) {
            this.winner = board[0];
        } else if (bottomAndThird) {
            this.winner = board[8];
        }
        return diagonalsAndMiddles || topAndFirst || bottomAndThird;
    }

    public boolean topRow() {
        return board[0] == board[1] && board[1] == board[2];
    }

    public boolean middleRow() {
        return board[3] == board[4] && board[4] == board[5];
    }

    public boolean bottomRow() {
        return board[6] == board[7] && board[7] == board[8];
    }

    public boolean firstCol() {
        return board[0] == board[3] && board[3] == board[6];
    }
    public boolean secondCol() {
        return board[1] == board[4] && board[4] == board[7];
    }
    public boolean thirdCol() {
        return board[2] == board[5] && board[5] == board[8];
    }



}
