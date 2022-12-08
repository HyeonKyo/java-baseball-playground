package baseballtdd;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private static final int SIZE = 3;

    private List<Ball> balls;

    public Balls(List<Integer> numbers) {
        checkValidSize(numbers);
        makeBallList(numbers);
        checkDuplicateNo();
    }

    private void makeBallList(List<Integer> numbers) {
        balls = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            balls.add(new Ball(i + 1, numbers.get(i)));
        }
    }

    private void checkDuplicateNo() {
        boolean[] numberCheckArray = new boolean[10];
        for (Ball ball : balls) {
            int ballNumber = ball.getNumber();
            if (numberCheckArray[ballNumber]) {
                throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
            }
            numberCheckArray[ballNumber] = true;
        }
    }

    private void checkValidSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(String.format("숫자는 %d개 이어야 합니다.", SIZE));
        }
    }
}
