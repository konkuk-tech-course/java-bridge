package bridge.domain;

public class Player {

    private Position position;
    private int tryCount;

    public Player(Position position, int tryCount) {
        this.position = position;
        this.tryCount = tryCount;
    }

    public void move() {
        position = position.increase();
    }

    public void resetPosition() {
        position = position.reset();
    }

    public void increaseTryCount() {
        this.tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getPosition() {
        return position.getValue();
    }
}
