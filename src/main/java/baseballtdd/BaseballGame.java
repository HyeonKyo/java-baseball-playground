package baseballtdd;

public class BaseballGame {
    private final NumberGenerator numberGenerator;
    private Balls balls;

    public BaseballGame() {
        numberGenerator = new NumberGenerator();
    }

    public void prepare() {
        balls = new Balls(numberGenerator.makeComputerNo());
    }

    public Balls getBalls() {
        return balls;
    }
}
