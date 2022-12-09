package baseballtdd;

public class BaseballGame {
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
}
