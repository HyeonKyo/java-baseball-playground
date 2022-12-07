package numberbaseball;

public class NumberBaseball {

    private String computerNumber;

    private static final int SIZE = 3;

    public static void main(String[] args) {
        NumberBaseball numberBaseball = new NumberBaseball();
        numberBaseball.prepareGame();
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

