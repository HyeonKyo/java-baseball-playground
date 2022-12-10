package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void test() {
        Integer.parseInt("-");
        String[] s = "       ".split(" ");
        System.out.println(s.length);
    }

    @Test
    void calculatorTest() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void calculatorTest2() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.calculate("2");
        assertThat(result).isEqualTo(2);
    }
}