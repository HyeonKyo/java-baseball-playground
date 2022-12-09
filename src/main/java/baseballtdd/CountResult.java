package baseballtdd;

public class CountResult {
    public static final String NOTHING_MESSAGE = "낫띵";

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

    public void print() {
        StringBuilder message = new StringBuilder();
        if (ball > 0) {
            message.append(String.format("%d볼 ", ball));
        }
        if (strike > 0) {
            message.append(String.format("%d스트라이크", strike));
        }
        if (message.length() == 0) {
            message.append(NOTHING_MESSAGE);
        }
        System.out.println(message);
    }
}
