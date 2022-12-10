package numberbaseball;

public class Result {
    private int strike;
    private int ball;
    private int size;

    public Result(int size) {
        this.size = size;
    }

    public boolean notRightAnswer() {
        return strike != size;
    }


    public void initResult() {
        strike = 0;
        ball = 0;
    }

    public void addStrike() {
        strike++;
    }

    public void addBall() {
        ball++;
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();

        if (ball != 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        System.out.println(sb);
    }
}
