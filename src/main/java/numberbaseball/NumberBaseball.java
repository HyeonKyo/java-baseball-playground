package numberbaseball;

import java.util.Scanner;

public class NumberBaseball {

    private String computerNumber;

    private static final int SIZE = 3;

    public static void main(String[] args) {
        NumberBaseball numberBaseball = new NumberBaseball();
        numberBaseball.prepareGame();
        numberBaseball.gameStart();
    }

    private void gameStart() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = getUserInput(scanner);
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

