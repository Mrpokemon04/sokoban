public class Crate {
    public int x;
    public int y;
    public Board board;
    public Player player;

    public Crate(int x, int y) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveLeft() {
        x = x - 1;
    }

    public void moveRight() {
        x = x + 1;
    }

    public void moveUp() {
        y = y - 1;
    }

    public void moveDown() {
        y = y + 1;
    }

    // public void getPushed() {
    //     if(player.moveLeft()) {

    //     }
    // }
}