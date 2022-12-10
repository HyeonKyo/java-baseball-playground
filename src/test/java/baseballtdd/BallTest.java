package baseballtdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @Test
    void create_ball() {
        assertThat(new Ball(9)).isNotNull();
    }

    @Test
    void 숫자값_검증_1_9() {
        assertThat(new Ball(1)).isNotNull();
        assertThat(new Ball(9)).isNotNull();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ball(0))
                .withMessageMatching("1이상 9이하의 값만 가능합니다.");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ball(10))
                .withMessageMatching("1이상 9이하의 값만 가능합니다.");
    }

    @Test
    void Equal_Test() {
        Ball ball1 = new Ball(1);
        Ball ball2 = new Ball(1);
        assertThat(ball1.equals(ball2)).isTrue();
    }
}
