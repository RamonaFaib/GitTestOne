package lv.accenture.preboot.cowsbulls;

import java.util.*;

public class CowsBullsGame {

    public static void main(String[] args) {


        // Random skaitla generesana bez dublikatiem, bez nulles:
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() != 4) {
            int r = new Random().nextInt(9) + 1;
            numbers.add(r);
        }

        int iter = 0;
        int[] secretNumberIntTest = new int[4];
        for (Integer number : numbers) {
            secretNumberIntTest[iter] = number;
            iter++;
        }

        // Printesana testam
        for (int i=0; i < secretNumberIntTest.length; i++) {
            int element = secretNumberIntTest[i];
            System.out.print(element);
        }
        System.out.println(" ");

        // Lietotaja ievads:
        CBCalculator cowsBullsGame = new CBCalculator();
        cowsBullsGame.printExplainRules();

        // Skeneris
        Scanner scanner = new Scanner(System.in);

        // Lietotajs izvelas speles limeni
        String gameLevel = "";
        gameLevel = scanner.nextLine();

        // Ja ievads ir String - rinda, kas sastav no simboliem, tad parveidojam par array of integers:
        String userNumberStr;

        int[] userNumberInt = new int[4];

        System.out.println("Enter 4 digit number with no duplicates: ");
        userNumberStr = scanner.nextLine();


        boolean userWin = false;
        int sequence = 2;
        int attempts = 1;

            while (!userWin) {

                String[] userNumberStrParts = userNumberStr.split("");

                for (int i = 0; i < userNumberStrParts.length; i++) {
                    String userNumberPart = userNumberStrParts[i];
                    int userNumberIntPart = Integer.parseInt(userNumberPart);
                    userNumberInt[i] = userNumberIntPart;
                }


                int countOfBulls = cowsBullsGame.getCountOfBull(secretNumberIntTest, userNumberInt);
                int countOfCows = cowsBullsGame.getCountOfCow(secretNumberIntTest, userNumberInt);


                if (countOfBulls == 4) {
                    userWin = true;
                    System.out.println("You won with " + attempts + " attempts!" + " Thank you for playing!");
                } else {
                    if (countOfBulls == 1 && countOfCows !=1) {
                        System.out.println(countOfBulls + " Bull and " + countOfCows + " Cows");
                    } else if (countOfBulls != 1 && countOfCows == 1) {
                        System.out.println(countOfBulls + " Bulls and " + countOfCows + " Cow");
                    } else if (countOfBulls == 1 && countOfCows == 1) {
                        System.out.println(countOfBulls + " Bull and " + countOfCows + " Cow");
                    } else {
                        System.out.println(countOfBulls + " Bulls and " + countOfCows + " Cows");
                    }

                    System.out.println(sequence + ". " + "Enter your number: ");
                    userNumberStr = scanner.nextLine();
                    attempts++;
                    sequence++;
                }

                switch (gameLevel) {
                    case "Medium" :
                        if (attempts == 12) {
                            userWin = true;
                            System.out.println("You lost! Try again.");
                        }
                            break;

                    case "Hard" :
                       if (attempts == 8) {
                           userWin = true;
                           System.out.println("You lost! Try again.");
                       }
                       break;

                }

            }
    }
}