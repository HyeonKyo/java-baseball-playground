package baseballtdd;

import java.util.Scanner;

public class BaseballGame {
    private static final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String WRONG_MESSAGE = "잘못된 입력입니다. 다시 입력하세요.";

    private final NumberGenerator numberGenerator;
    private Balls computerBalls;

    public BaseballGame() {
        numberGenerator = new NumberGenerator();
    }

    public void prepare() {
        computerBalls = new Balls(numberGenerator.makeRandomNumbers());
    }

    public void gameStart() {
        boolean continueFlag = true;
        while (continueFlag) {
            //1. user input 받기, 유효성 검사
            Balls userBalls = new Balls(numberGenerator.makeInputNumbers());
            //2. compare하기
//            computerBalls.compare();
            //3. result 출력

            //4. 계속 할 것인지 입력 받기
        }
    }

    public Balls getComputerBalls() {
        return computerBalls;
    }

    public boolean continueGameInput() {
        Scanner scanner = new Scanner(System.in);

        String input = getInputTrimString(scanner, CONTINUE_MESSAGE);
        while (notValidContinueInput(input)) {
            input = getInputTrimString(scanner, WRONG_MESSAGE);
        }
        scanner.close();
        return isContinue(input);
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
