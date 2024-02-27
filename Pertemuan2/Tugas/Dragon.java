public class Dragon {
    int x, y, width, height;

    void moveLeft() {
        x--;

        if (x < 0) {
            detectCollision(x, y);
        }
    }

    void moveRight() {
        x++;

        if (x > width) {
            detectCollision(x, y);
        }
    }

    void moveUp() {
        y++;

        if (y > height) {
            detectCollision(x, y);
        }
    }

    void moveDown() {
        y--;

        if (y < 0) {
            detectCollision(x, y);
        }
    }

    void detectCollision(int x, int y) {
        System.out.println("Game Over");
    }
}