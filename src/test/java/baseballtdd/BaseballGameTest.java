package baseballtdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

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

    @Test
    void 게임_지속_여부_입력_받기() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        boolean isContinue = baseballGame.continueGameInput();
        assertThat(isContinue).isTrue();

        System.setIn(new ByteArrayInputStream("2".getBytes()));
        boolean isContinue2 = baseballGame.continueGameInput();
        assertThat(isContinue2).isFalse();

        System.setIn(new ByteArrayInputStream("2   ".getBytes()));
        boolean isContinue3 = baseballGame.continueGameInput();
        assertThat(isContinue3).isFalse();
    }

    @Test
    void 게임_지속_여부_입력_예외처리() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        System.setIn(new ByteArrayInputStream("3\n1".getBytes()));
        baseballGame.continueGameInput();
        assertThat(out.toString()).contains("잘못된 입력입니다. 다시 입력하세요.");

        System.setIn(new ByteArrayInputStream("a\n1".getBytes()));
        baseballGame.continueGameInput();
        assertThat(out.toString()).contains("잘못된 입력입니다. 다시 입력하세요.");
    }

}
