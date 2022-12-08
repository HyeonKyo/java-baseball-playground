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

}
