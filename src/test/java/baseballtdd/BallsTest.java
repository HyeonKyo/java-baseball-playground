package baseballtdd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BallsTest {

    @Test
    void Balls_생성_test() {
        assertThat(new Balls(Arrays.asList(1, 2, 3))).isNotNull();
    }

    @Test
    void 자리수_검증() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Balls(Arrays.asList(1, 2)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Balls(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    void 숫자범위_1_9_검증() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Balls(Arrays.asList(1, 0, 3)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Balls(Arrays.asList(10, 2, 3)));
    }

    @Test
    void 중복_숫자_검증() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Balls(Arrays.asList(1, 2, 2)));
    }

    @Test
    void strike() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Ball userBall = new Ball(2);

        BallStatus status = computerBalls.play(userBall, 1);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Ball userBall = new Ball(2);

        BallStatus status = computerBalls.play(userBall, 0);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Ball userBall = new Ball(9);

        BallStatus status = computerBalls.play(userBall, 0);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void strike_result() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));

        Balls user = new Balls(Arrays.asList(4, 5, 3));
        CountResult result = computerBalls.compare(user);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.isNothing()).isFalse();

        Balls user2 = new Balls(Arrays.asList(1, 5, 3));
        CountResult result2 = computerBalls.compare(user2);
        assertThat(result2.getStrike()).isEqualTo(2);
        assertThat(result2.isNothing()).isFalse();
    }

    @Test
    void ball_result() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));

        Balls user = new Balls(Arrays.asList(2, 3, 1));
        CountResult result = computerBalls.compare(user);
        assertThat(result.getBall()).isEqualTo(3);
        assertThat(result.isNothing()).isFalse();

        Balls user2 = new Balls(Arrays.asList(4, 5, 1));
        CountResult result2 = computerBalls.compare(user2);
        assertThat(result2.getBall()).isEqualTo(1);
        assertThat(result2.isNothing()).isFalse();
    }

    @Test
    void nothing_result() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));

        Balls user = new Balls(Arrays.asList(5, 6, 7));
        CountResult result = computerBalls.compare(user);

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isNothing()).isTrue();
    }

    @Test
    void finish_result() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));

        Balls user = new Balls(Arrays.asList(1, 2, 3));
        CountResult result = computerBalls.compare(user);

        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.isFinish()).isTrue();
    }
}
