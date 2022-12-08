package baseballtdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    private static final int SIZE = 3;

    public List<Integer> makeComputerNo() {
        List<Integer> numberList = new ArrayList<>();

        boolean[] dupCheckArray = new boolean[10];
        while (numberList.size() < SIZE) {
            int randomNo = makeRandomNo();
            checkAndInsertNumber(numberList, randomNo, dupCheckArray);
        }
        return numberList;
    }

    private void checkAndInsertNumber(List<Integer> numberList, int randomNo, boolean[] dupCheckArray) {
        if (!dupCheckArray[randomNo]) {
            dupCheckArray[randomNo] = true;
            numberList.add(randomNo);
        }
    }

    int makeRandomNo() {
        return new Random().nextInt(9) + 1;
    }
}
