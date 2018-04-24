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



}
