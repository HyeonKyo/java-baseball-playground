package baseballtdd;

public class CountResult {

    private final int SIZE;
    private int strike;
    private int ball;

    public CountResult(int size) {
        this.SIZE = size;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        return strike <= 0 && ball <= 0;
    }

    public void addCount(BallStatus status) {
        if (status.isStrike()) {
            strike++;
        } else if (status.isBall()) {
            ball++;
        }
    }

    public boolean isFinish() {
        return strike == SIZE;
    }
}
