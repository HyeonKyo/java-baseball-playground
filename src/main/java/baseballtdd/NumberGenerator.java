package baseballtdd;

import java.util.*;

public class NumberGenerator {

    private static final int SIZE = 3;
    private static final String INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String INPUT_ERROR_MESSAGE = "잘못된 입력입니다. 다시 입력해주세요.";

    public NumberGenerator() {

    }

    public List<Integer> makeRandomNumbers() {
        List<Integer> numberList = new ArrayList<>();

        Set<Integer> dupCheckSet = new HashSet<>();
        while (numberList.size() < SIZE) {
            checkAndInsertNumber(numberList, makeRandomNo(), dupCheckSet);
        }
        return numberList;
    }

    public List<Integer> makeInputNumbers() {
        String input = getUserInputString();
        return mapNumberList(input);
    }

    private List<Integer> mapNumberList(String input) {
        List<Integer> numberList = new ArrayList<>();
        String[] numbers = input.split("");
        for (String number : numbers) {
            numberList.add(Integer.parseInt(number));
        }
        return numberList;
    }

    private String getUserInputString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!isValid(input)) {
            System.out.print(INPUT_MESSAGE);
            input = scanner.nextLine();
        }
        scanner.close();
        return input;
    }

    private boolean isValid(String input) {
        boolean validFlag = checkSize(input);
        validFlag = checkValidNumberAndNotDuplicate(input, validFlag);
        if (!validFlag) {
            System.out.println(INPUT_ERROR_MESSAGE);
        }
        return validFlag;
    }

    private boolean checkValidNumberAndNotDuplicate(String input, boolean validFlag) {
        if (!validFlag) {
            return false;
        }

        Set<Character> dupCheckSet = new HashSet<>();
        int index = 0;
        while (validFlag && index < input.length()) {
            char c = input.charAt(index++);
            validFlag = isRightNumber(c) && isNotDuplicate(dupCheckSet, c);
        }
        return validFlag;
    }

    private boolean isRightNumber(char c) {
        return '1' <= c && c <= '9';
    }

    private boolean isNotDuplicate(Set<Character> dupCheckSet, char c) {
        return dupCheckSet.add(c);
    }

    private boolean checkSize(String input) {
        return input.length() == SIZE;
    }

    private void checkAndInsertNumber(List<Integer> numberList, int randomNo, Set<Integer> dupCheckSet) {
        if (dupCheckSet.add(randomNo)) {
            numberList.add(randomNo);
        }
    }

    int makeRandomNo() {
        return new Random().nextInt(9) + 1;
    }
}
