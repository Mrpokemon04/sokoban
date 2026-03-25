import java.util.*;

public class Board {
    public int height = 8;
    public int width = 7;
    public Player player;
    public ArrayList<Crate> crates = new ArrayList<Crate>();
    public ArrayList<Flag> flags = new ArrayList<Flag>();

    public char[][] board = new char[][] {{' ', ' ', 'X', 'X', 'X', 'X', 'X', ' '},
                                          {'X', 'X', 'X', ' ', ' ', ' ', 'X', ' '},
                                          {'X', ' ', ' ', 'O', ' ', ' ', 'X', ' '},
                                          {'X', 'X', 'X', ' ', 'O', ' ', 'X', ' '},
                                          {'X', ' ', 'X', 'X', 'O', ' ', 'X', ' '},
                                          {'X', ' ', 'X', ' ', ' ', ' ', 'X', 'X'},
                                          {'X', 'O', ' ', 'O', 'O', 'O', ' ', 'X'},
                                          {'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
                                          {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};

    public char[][] boardCopy = new char[][] {{' ', ' ', 'X', 'X', 'X', 'X', 'X', ' '},
                                              {'X', 'X', 'X', ' ', ' ', ' ', 'X', ' '},
                                              {'X', 'F', ' ', ' ', ' ', ' ', 'X', ' '},
                                              {'X', 'X', 'X', ' ', ' ', 'F', 'X', ' '},
                                              {'X', 'F', 'X', 'X', ' ', ' ', 'X', ' '},
                                              {'X', ' ', 'X', ' ', 'F', ' ', 'X', 'X'},
                                              {'X', ' ', ' ', 'F', ' ', ' ', 'F', 'X'},
                                              {'X', ' ', ' ', ' ', 'F', ' ', ' ', 'X'},
                                              {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};

    public Board(Player player) {
        this.height = height;
        this.width = width;
        this.board = board;
        this.player = player;
        addFlags();
    }

    public Board() {
        this.height = height;
        this.width = width;
        this.board = board;
    }

    public void addFlags() {
        for(int i = 0; i <= height; i++) {
            for(int j = 0; j <= width; j++) {
                if(boardCopy[i][j] == 'F') {
                    Flag flag = new Flag(j, i);
                    flags.add(flag);
                }
            }
        }
    }

    public void displayFlags() {
        int count = 1;
        for(Flag flag : flags) {
            System.out.println("Flag " + count + ", x: " + flag.getX() + ", y: " + flag.getY());
            count++;
        }
    }

    public void addCrates() {
        for(int i = 0; i <= height; i++) {
            for(int j = 0; j <= width; j++) {
                if(board[i][j] == 'O') {
                    Crate crate = new Crate(j, i);
                    crates.add(crate);
                }
            }
        }     
    }

    public void displayCrates() {
        int count = 1;
        
        for(Crate crate : crates) {
            System.out.println("Crate " + count + ", x: " + crate.getX() + ", y: " + crate.getY());
            count++;
        }
    }

    public void displayBoard() {
        for(int i = 0; i <= height; i++) {
            for(int j = 0; j <= width; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void displayBoardCopy() {
        for(int i = 0; i <= height; i++) {
            for(int j = 0; j <= width; j++) {
                System.out.print(boardCopy[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void moveCrate(String direction) {
        switch(direction) {
            case "left":
                for(Crate crate : crates) {
                    if(crate.getX() == (player.getX()-1) && crate.getY() == (player.getY())) {
                        crate.moveLeft();
                    }
                }
                break;

            case "right":
                for(Crate crate : crates) {
                    if(crate.getX() == (player.getX()+1) && crate.getY() == (player.getY())) {
                        crate.moveRight();
                    }
                }
                break;

            case "up":
                for(Crate crate : crates) {
                    if(crate.getX() == (player.getX()) && crate.getY() == (player.getY()-1)) {
                        crate.moveUp();
                    }
                }
                break;

            case "down":
                for(Crate crate : crates) {
                    if(crate.getX() == (player.getX()) && crate.getY() == (player.getY()+1)) {
                        crate.moveDown();
                    }
                }
                break;
            
            default:
                break;
        }
    }

    public boolean crateCheck(int i, int j) {
        for(Crate crate : crates) {
            if(crate.getX() == j && crate.getY() == i) {
                return true;
            }
        }
        return false;
    }

    public void updateBoard() {
        for(int i = 0; i <= height; i++) {
            for(int j = 0; j <= width; j++) {
                if((player.getX() == j && player.getY() == i) && crateCheck(i, j) == false)
                    board[i][j] = '1';
                else if(crateCheck(i, j) == true && boardCopy[i][j] != 'F')
                    board[i][j] = 'O';
                else if(crateCheck(i, j) == true && boardCopy[i][j] == 'F')
                    board[i][j] = '0';
                else
                    board[i][j] = boardCopy[i][j];
            }
        }
    }

    public boolean checkWin() {
        for(Flag flag : flags) {
            int check = 0;
            for(Crate crate : crates) {
                if(flag.getX() == crate.getX() && flag.getY() == crate.getY())
                    check = 1;
            }
            if(check == 0)
                return false;
        }
        return true;
    }
}