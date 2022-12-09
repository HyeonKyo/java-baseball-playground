package baseballtdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    final int SIZE = 3;
    BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
    }

    @Test
    void create_BaseballGame() {
        assertThat(baseballGame).isNotNull();
    }

    @Test
    void prepare_test() {
        baseballGame.prepare();
        assertThat(baseballGame.getComputerBalls()).isNotNull();
        assertThat(baseballGame.getComputerBalls().size()).isEqualTo(SIZE);
    }

}
