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

    public char[] setBoard() {
        char[] board = new char[9];
        for (int i = 0; i < board.length; i ++) {
            board[i] = '-';
        }
        return board;
    }

}
