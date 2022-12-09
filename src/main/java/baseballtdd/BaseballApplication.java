package baseballtdd;

public class BaseballApplication {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        boolean continueGameFlag = true;
        while (continueGameFlag) {
            baseballGame.prepare();
            baseballGame.gameStart();
            continueGameFlag = baseballGame.continueGame();
        }
        System.out.println("게임 종료");
    }
}
