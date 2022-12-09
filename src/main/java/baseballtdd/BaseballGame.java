package baseballtdd;

import java.util.Scanner;

public class BaseballGame {
    private static final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String WRONG_MESSAGE = "잘못된 입력입니다. 다시 입력하세요.";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private final NumberGenerator numberGenerator;
    private Balls computerBalls;

    public BaseballGame() {
        numberGenerator = new NumberGenerator();
    }

    public void prepare() {
        computerBalls = new Balls(numberGenerator.makeRandomNumbers());
    }

    public void gameStart() {
        boolean finishGameFlag = false;
        while (!finishGameFlag) {
            Balls userBalls = new Balls(numberGenerator.makeInputNumbers());
            CountResult result = computerBalls.compare(userBalls);
            result.print();
            finishGameFlag = result.isFinish();
        }
        System.out.println(END_MESSAGE);
    }

    public boolean continueGame() {
        Scanner scanner = new Scanner(System.in);

        String input = getInputTrimString(scanner, CONTINUE_MESSAGE);
        while (notValidContinueInput(input)) {
            input = getInputTrimString(scanner, WRONG_MESSAGE);
        }
        return isContinue(input);
    }

    public Balls getComputerBalls() {
        return computerBalls;
    }

    private boolean isContinue(String input) {
        return "1".equals(input);
    }

    private String getInputTrimString(Scanner scanner, String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        return input.trim();
    }

    private boolean notValidContinueInput(String input) {
        return !"1".equals(input) && !"2".equals(input);
    }
}
