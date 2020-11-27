package lv.accenture.preboot.cowsbulls;

public class CBCalculator {

    public int getCountOfBull(int[] secretNumber, int[] userInput) {
        int countBull = 0;
        //int[] secretNumber = new int[]{};
        //int[] userInput = new int[]{};
        for (int i = 0; i < secretNumber.length; i++) {
            if (secretNumber[i] == userInput[i]) {
                countBull++;
            }
        }
        return countBull;
    }

    public int getCountOfCow(int[] secretNumber, int[] userInput) {
        int countCow = 0;
        //int[] secretNumber = new int[]{};
        //int[] userInput = new int[]{};
        for (int i = 0; i < userInput.length; i++) {
            for (int j = 0; j < secretNumber.length; j++) {
                if (i != j && userInput[i] == secretNumber[j])
                    countCow++;
            }
        }
        return countCow;
    }

    public void printExplainRules() {
        System.out.println("Welcome to the Cows and Bulls Game!");
        System.out.println("You have to guess 4 digit number generated by game. Number 0 is not included!");
        System.out.println("If you guess the digit in the right place - You have Bull, if the digit is correct, " +
                "but in the wrong place - You have Cow.");
        System.out.println(" ");
        System.out.println("Choose game level. Easy - infinite number of tries. Medium - 12 number of tries. Hard - " +
                "8 number of tries.");
    }

}
