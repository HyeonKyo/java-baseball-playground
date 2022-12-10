package numberbaseball;

import java.util.Scanner;

public class NumberBaseball {

    private String computerNumber;

    private static final int SIZE = 3;

    public static void main(String[] args) {
        NumberBaseball numberBaseball = new NumberBaseball();

        boolean continueGame = true;
        while (continueGame) {
            numberBaseball.prepareGame();
            numberBaseball.gameStart();
            continueGame = numberBaseball.getContinueInput();
        }
    }

    private boolean getContinueInput() {
        Scanner scanner = new Scanner(System.in);
        Boolean continueResult = null;

        while (continueResult == null) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String continueInput = scanner.nextLine();

            continueResult = checkContinueResult(continueInput);
        }
        return continueResult;
    }

    private Boolean checkContinueResult(String continueInput) {
        try {
            int inputValue = Integer.parseInt(continueInput);
            return continueResult(inputValue);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Boolean continueResult(int value) {
        if (value == 1) {
            return true;
        }
        if (value == 2) {
            return false;
        }
        return null;
    }

    private void gameStart() {
        Scanner scanner = new Scanner(System.in);
        Result result = new Result(SIZE);

        while (result.notRightAnswer()) {
            String input = getUserInput(scanner);
            compareNumber(input, result);

            result.printResult();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void compareNumber(String input, Result result) {
        result.initResult();
        if (input == null) {
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            counting(i, input, result);
        }
    }

    private void counting(int index, String input, Result result) {
        char inputValue = input.charAt(index);
        char comparedValue = computerNumber.charAt(index);

        if (inputValue == comparedValue) {
            result.addStrike();
            return;
        }
        if (computerNumber.contains(inputValue + "")) {
            result.addBall();
        }
    }

    private String getUserInput(Scanner scanner) {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();

        if (input.length() != SIZE) {
            System.out.println("잘못된 입력입니다!");
            return null;
        }
        return input;
    }

    private void prepareGame() {
        StringBuilder numberBuilder = new StringBuilder();
        boolean[] numbers = new boolean[10];

        for (int i = 0; i < SIZE; i++) {
            int randomNumber = getRandomNumber(numbers);
            numberBuilder.append(randomNumber);
        }
        computerNumber = numberBuilder.toString();
    }

    private int getRandomNumber(boolean[] numbers) {
        int randomNumber = 0;
        while (randomNumber == 0) {
            randomNumber = choiceNumber(numbers);
        }

        numbers[randomNumber] = true;
        return randomNumber;
    }

    private int choiceNumber(boolean[] numbers) {
        int randomNumber = (int) (Math.random() * 9) + 1;
        if (numbers[randomNumber]) {
            return 0;
        }
        return randomNumber;
    }

}

