import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Player player = new Player(2, 2);

        Board objectBoard = new Board(player);

        player.setBoard(objectBoard);

        // ArrayList<Crate> crates = new ArrayList<Crate>();

        objectBoard.addCrates();

        // objectBoard.addFlags();

        objectBoard.updateBoard();

        while(objectBoard.checkWin()==false) {

            objectBoard.displayBoard();

            System.out.println();

            // objectBoard.displayBoardCopy();

            // objectBoard.displayCrates();

            // objectBoard.displayFlags();

            System.out.println("Player is at x: " + player.x + " and y: " + player.y);

            char next = sc.next().charAt(0);

            switch(next) {
                case 'w':
                    player.moveUp();
                    break;

                case 's':
                    player.moveDown();
                    break;

                case 'a':
                    player.moveLeft();
                    break;

                case 'd':
                    player.moveRight();
                    break;
                
                case 'e':
                    return;
            }

            objectBoard.updateBoard();
        }
    }
}