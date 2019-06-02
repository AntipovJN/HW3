public class Robot {
    private int x = 0;
    private int y = 0;
    private Direction direction = Direction.UP;

    public Direction getDirection() {
        return direction;    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        System.out.println("turn left");
        switch (direction) {
            case UP:this.direction = Direction.LEFT;
                return;
            case DOWN:this.direction = Direction.RIGHT;
                return;
            case LEFT:this.direction = Direction.DOWN;
                return;
            case RIGHT:this.direction = Direction.UP;
        }
    }

    public void turnRight() {
        System.out.println("turn right");
        switch (direction) {
            case UP:this.direction = Direction.RIGHT;
                return;
            case DOWN:this.direction = Direction.LEFT;
                return;
            case LEFT:this.direction = Direction.UP;
                return;
            case RIGHT:this.direction = Direction.DOWN;
        }    }

    public void stepForward() {
        switch (direction) {
            case LEFT: x--;
                System.out.println("step on left");
                break;
            case RIGHT: x++;
                System.out.println("step on right");
                break;
            case UP: y++;
                System.out.println("step up");
                break;
            case DOWN: y--;
                System.out.println("step down");
                break;
        }

    }

}