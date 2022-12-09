package baseballtdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    static final int SIZE = 3;
    static final String INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    static final String INPUT_ERROR_MESSAGE = "잘못된 입력입니다. 다시 입력해주세요.";

    NumberGenerator numberGenerator;
    Scanner scanner;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
        scanner = new Scanner(System.in);
    }

    @DisplayName("1-9 랜덤 생성 테스트")
    @RepeatedTest(value = 5, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void random_in_1_9() {
        int randomNumber = numberGenerator.makeRandomNo();
        assertThat(randomNumber >= 1 && randomNumber <= 9).isTrue();
    }

    @Test
    void 랜덤숫자_중복_검증() {
        boolean[] dupCheckArray = new boolean[10];

        List<Integer> numbers = numberGenerator.makeRandomNumbers();
        for (Integer number : numbers) {
            assertThat(dupCheckArray[number]).isFalse();
            dupCheckArray[number] = true;
        }
    }

    @Test
    void 랜덤숫자_자리수_검증() {
        List<Integer> numbers = numberGenerator.makeRandomNumbers();
        assertThat(numbers.size()).isEqualTo(SIZE);
    }

    @Test
    void 입력숫자_처리_test() {
        System.setIn(new ByteArrayInputStream("123\n".getBytes()));

        List<Integer> numbers = numberGenerator.makeInputNumbers();
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    void 입력숫자_자리수_검증() {

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        System.setIn(new ByteArrayInputStream("1234\n123".getBytes()));
        numberGenerator.makeInputNumbers();
        assertThat(out.toString()).contains(INPUT_ERROR_MESSAGE);

        System.setIn(new ByteArrayInputStream("12\n123".getBytes()));
        numberGenerator.makeInputNumbers();
        assertThat(out.toString()).contains(INPUT_ERROR_MESSAGE);
    }

    @Test
    void 입력숫자_1_9_검증() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        System.setIn(new ByteArrayInputStream("012\n123".getBytes()));
        numberGenerator.makeInputNumbers();
        assertThat(out.toString()).contains(INPUT_ERROR_MESSAGE);

        System.setIn(new ByteArrayInputStream("a12\n123".getBytes()));
        numberGenerator.makeInputNumbers();
        assertThat(out.toString()).contains(INPUT_ERROR_MESSAGE);
    }

    @Test
    void 입력숫자_중복_검증() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        System.setIn(new ByteArrayInputStream("112\n123".getBytes()));
        numberGenerator.makeInputNumbers();
        assertThat(out.toString()).contains(INPUT_ERROR_MESSAGE);

        System.setIn(new ByteArrayInputStream("122\n123".getBytes()));
        numberGenerator.makeInputNumbers();
        assertThat(out.toString()).contains(INPUT_ERROR_MESSAGE);
    }

}
