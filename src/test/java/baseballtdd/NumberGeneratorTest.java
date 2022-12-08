package baseballtdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    static final int SIZE = 3;

    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @DisplayName("1-9 랜덤 생성 테스트")
    @RepeatedTest(value = 5, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void random_in_1_9() {
        int randomNumber = numberGenerator.makeRandomNo();
        assertThat(randomNumber >= 1 && randomNumber <= 9).isTrue();
    }

    @Test
    void 중복_검증() {
        boolean[] dupCheckArray = new boolean[10];

        List<Integer> numbers = numberGenerator.makeComputerNo();
        for (Integer number : numbers) {
            assertThat(dupCheckArray[number]).isFalse();
            dupCheckArray[number] = true;
        }
    }

    @Test
    void 자리수_검증() {
        List<Integer> numbers = numberGenerator.makeComputerNo();
        assertThat(numbers.size()).isEqualTo(SIZE);
    }
}
