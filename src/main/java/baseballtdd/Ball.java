package baseballtdd;

public class Ball {
    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;

    private int number;

    public Ball(int number) {
        validNumber(number);
        this.number = number;
    }

    private void validNumber(int value) {
        if (value < MIN_NO || value > MAX_NO) {
            throw new IllegalArgumentException("1이상 9이하의 값만 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

}
