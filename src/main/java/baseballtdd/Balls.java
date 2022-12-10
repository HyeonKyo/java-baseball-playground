package baseballtdd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Balls {
    private static final int SIZE = 3;

    private List<Ball> balls;

    public Balls(List<Integer> numbers) {
        checkValidSize(numbers);
        checkDuplicateNo(numbers);
        balls = mapBalls(numbers);
    }

    public CountResult compare(Balls userBalls) {
        CountResult result = new CountResult(SIZE);
        List<Ball> userBallList = userBalls.getBalls();
        for (int index = 0; index < SIZE; index++) {
            Ball userBall = userBallList.get(index);
            BallStatus status = play(userBall, index);
            result.addCount(status);
        }
        return result;
    }

    BallStatus play(Ball userBall, int index) {
        if (userBall.equals(balls.get(index))) {
            return BallStatus.STRIKE;
        }
        if (balls.contains(userBall)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public int size() {
        return balls.size();
    }

    private List<Ball> mapBalls(List<Integer> numbers) {
        return numbers.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    private void checkDuplicateNo(List<Integer> numbers) {
        Set<Integer> dupCheckSet = new HashSet<>();
        for (Integer number : numbers) {
            checkDupAndInsertSet(dupCheckSet, number);
        }
    }

    private void checkDupAndInsertSet(Set<Integer> dupCheckSet, Integer number) {
        if (!dupCheckSet.add(number)) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    private void checkValidSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(String.format("숫자는 %d개 이어야 합니다.", SIZE));
        }
    }
}
