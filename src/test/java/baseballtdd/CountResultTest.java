package baseballtdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountResultTest {

    static final int SIZE = 3;

    OutputStream out;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void nothing_출력_테스트() {
        CountResult result = new CountResult(SIZE);
        result.print();

        assertThat(out.toString()).contains(CountResult.NOTHING_MESSAGE);
    }

    @Test
    void only_strike_출력_테스트() {
        CountResult result = new CountResult(SIZE);
        result.addCount(BallStatus.STRIKE);
        result.addCount(BallStatus.STRIKE);
        result.print();

        assertThat(out.toString()).contains("2스트라이크");
        assertThat(out.toString()).doesNotContain("볼");
    }

    @Test
    void only_ball_출력_테스트() {
        CountResult result = new CountResult(SIZE);
        result.addCount(BallStatus.BALL);
        result.addCount(BallStatus.BALL);
        result.print();

        assertThat(out.toString()).contains("2볼");
        assertThat(out.toString()).doesNotContain("스트라이크");
    }

    @Test
    void strike_ball_출력_테스트() {
        CountResult result = new CountResult(SIZE);
        result.addCount(BallStatus.BALL);
        result.addCount(BallStatus.BALL);
        result.addCount(BallStatus.STRIKE);
        result.print();

        assertThat(out.toString()).contains("2볼 1스트라이크");
    }
}