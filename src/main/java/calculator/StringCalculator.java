package calculator;

public class StringCalculator {

    public int calculate(String input) {
        String[] args = parseInputString(input);
        int result = calculateInput(args);
        return result;
    }

    private int calculateInput(String[] args) {
        int result = 0;
        int number = 0;
        String operator = null;

        for (String arg : args) {
            try {
                number = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                operator = arg;
            }

            result = operate(result, number, operator);
        }
        return result;
    }

    private String[] parseInputString(String input) {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException();
        }

        String[] args = input.split(" ");
        if (args.length == 0) {
            throw new RuntimeException();
        }
        return args;
    }

    private int operate(int a, int b, String operator) {
        if (operator == null) {
            return b;
        }
        switch (operator) {
            case "+":
                return add(a, b);
            case "-":
                return minus(a, b);
            case "*":
                return multiplication(a, b);
            case "/":
                return divide(a, b);
        }
        throw new RuntimeException();
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int multiplication(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        return a / b;
    }
}
