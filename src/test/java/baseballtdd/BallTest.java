package baseballtdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    static final int SIZE = 3;

    @Test
    void create_ball() {
        assertThat(new Ball(1, 9)).isNotNull();
    }

    @Test
    void 숫자값_검증_1_9() {
        assertThat(new Ball(1, 1)).isNotNull();
        assertThat(new Ball(1, 9)).isNotNull();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ball(1, 0))
                .withMessageMatching("1이상 9이하의 값만 가능합니다.");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ball(1, 10))
                .withMessageMatching("1이상 9이하의 값만 가능합니다.");
    }

    @Test
    void 위치값_검증_1_9() {
        assertThat(new Ball(1, 1)).isNotNull();
        assertThat(new Ball(3, 1)).isNotNull();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ball(0, 1))
                .withMessageMatching(String.format("위치 값은 1이상 %d이하만 가능합니다.", SIZE));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ball(4, 1))
                .withMessageMatching(String.format("위치 값은 1이상 %d이하만 가능합니다.", SIZE));
    }
}
