package baseballtdd;

public class Ball {
    private static final int SIZE = 3;
    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;

    private int position;
    private int number;

    public Ball(int position, int number) {
        validNumber(number);
        validPosition(position);
        this.position = position;
        this.number = number;
    }

    private void validPosition(int position) {
        if (position < 1 || position > SIZE) {
            throw new IllegalArgumentException(String.format("위치 값은 1이상 %d이하만 가능합니다.", SIZE));
        }
    }

    private void validNumber(int value) {
        if (value < MIN_NO || value > MAX_NO) {
            throw new IllegalArgumentException("1이상 9이하의 값만 가능합니다.");
        }
    }
}
