import java.util.*;

public class Player {
    public int x;
    public int y;
    public Board board;
    // public ArrayList<Crate> crates = board.crates;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveLeft() {
        if(((x-1) >= 0) && ((board.board[y][x-1] == ' ') || (board.board[y][x-1] == 'F')))
            x = x - 1;
        else if(((x-2) >= 0) && ((board.board[y][x-1] == 'O' || board.board[y][x-1] == '0') && ((board.board[y][x-2] == ' ') || (board.board[y][x-2] == 'F')))) {
            board.moveCrate("left");
            x = x - 1;
        }
    }

    public void moveRight() {
        if(((x+1) <= board.width) && ((board.board[y][x+1] == ' ') || (board.board[y][x+1] == 'F')))
            x = x + 1;
        else if(((x+2) <= board.width) && ((board.board[y][x+1] == 'O' || board.board[y][x+1] == '0') && ((board.board[y][x+2] == ' ') || (board.board[y][x+2] == 'F')))) {
            board.moveCrate("right");
            x = x + 1;
        }
    }

    public void moveUp() {
        if(((y-1) >= 0) && ((board.board[y-1][x] == ' ') || (board.board[y-1][x] == 'F')))
            y = y - 1;
        else if(((y-2) >= 0) && ((board.board[y-1][x] == 'O' || board.board[y-1][x] == '0') && ((board.board[y-2][x] == ' ') || (board.board[y-2][x] == 'F')))) {
            board.moveCrate("up");
            y = y - 1;
        }
    }

    public void moveDown() {
        if(((y+1) <= board.height) && ((board.board[y+1][x] == ' ') || (board.board[y+1][x] == 'F')))
            y = y + 1;
        else if(((y+2) <= board.height) && ((board.board[y+1][x] == 'O' || board.board[y+1][x] == '0') && ((board.board[y+2][x] == ' ') || (board.board[y+2][x] == 'F')))) {
            board.moveCrate("down");
            y = y + 1;
        }
    }
}