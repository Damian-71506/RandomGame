import java.util.Random;
import java.util.Scanner;

/***
 * @author Damian Kluk
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        mainMenu();
    }
    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to my number guessing game.");
        System.out.println("====================");
        System.out.println("Chose game mode:");
        System.out.println("1. Classic Game (Easy).");
        System.out.println("2. Classic Game (Normal).");
        System.out.println("3. Classic Game (Hard).");
        System.out.println("4. Classic Game (Advance).");
        System.out.println("5. Computer Guessing.");
        System.out.println("6. Player VS Computer.");
        System.out.println("7. Multiplayer.");
        System.out.println("8. Exit.");
        System.out.println("====================");
        System.out.print("Type number of game mode: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                easyMode(); // casual game mode - guess number 1-10
                break;
            case 2:
                normalMode(); // casual game mode - guess number 1-50
                break;
            case 3:
                hardMode(); // casual game mode - guess number 1-100
                break;
            case 4:
                advanceMode(); // game mode that player chose the range of guessing number
                break;
            case 5:
                computerGuessing(); // mode that compuer guess your number 0-100
                break;
            case 6:
                playerVScomputer(); // mode that player play against computer 0-100
                break;
            case 7:
                multiplayerMenu(); // mode that you can play with friends
            case 8:
                break; // exit game
            default:
                System.out.println("Wrong choice. Try again.");
                break;
        }
    }
    public static void multiplayerMenu() {
        Color color = new Color();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println(color.YELLOW + "Chose number of players." + color.RESET);
        System.out.println("============");
        System.out.println("1. 2 Player.");
        System.out.println("2. 3 Player.");
        System.out.println("3. 4 Player.");
        System.out.println("4. Back.");
        System.out.println("============");
        System.out.print("Your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                twoPlayerMode();
                break;
            case 2:
                threePlayerMode();
                break;
            case 3:
                fourPlayerMode();
                break;
            case 4:
                mainMenu();
                break;
            default:
                System.out.println("Wrong choice. Try again.");
                break;
        }
    }
    public static void easyMode() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Player playerData = new Player();

        playerData.playerName(); // run the upload player nickname method

        int randomNumber = random.nextInt(11);
        int numberAttempts = 0;

        System.out.print("Hello, guess the number from 0 to 10: ");
        int playerNumber = scanner.nextInt();
        numberAttempts++;

        do {
            if (playerNumber < randomNumber) {
                System.out.println("The number is too low.");
                System.out.print("Guess the number: ");
                playerNumber = scanner.nextInt();
            } else if (playerNumber > randomNumber) {
                System.out.println("The number is too high.");
                System.out.print("Guess the number: ");
                playerNumber = scanner.nextInt();
            }
            numberAttempts++;
        } while(playerNumber != randomNumber);
        System.out.println("Congratulations! You guessed the number: " + randomNumber + " in " + numberAttempts + " times!");
        System.out.println(playerData.name + " won the game!");
        mainMenu();
    }
    public static void normalMode() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Player playerData = new Player();

        playerData.playerName(); // run the upload player nickname method

        int randomNumber = random.nextInt(51);
        int numberAttempts = 0;

        System.out.print("Hello, guess the number from 0 to 50: ");
        int playerNumber = scanner.nextInt();
        numberAttempts++;

        do {
            if (playerNumber < randomNumber) {
                System.out.println("The number is too low.");
                System.out.print("Guess the number: ");
                playerNumber = scanner.nextInt();
            } else if (playerNumber > randomNumber) {
                System.out.println("The number is too high.");
                System.out.print("Guess the number: ");
                playerNumber = scanner.nextInt();
            }
            numberAttempts++;
        } while(playerNumber != randomNumber);
        System.out.println("Congratulations! You guessed the number: " + randomNumber + " in " + numberAttempts + " times!");
        System.out.println(playerData.name + " won the game!");
        mainMenu();
    }
    public static void hardMode() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Player playerData = new Player();

        playerData.playerName(); // run the upload player nickname method

        int randomNumber = random.nextInt(101);
        int numberAttempts = 0;

        System.out.print("Hello, guess the number from 0 to 100: ");
        int playerNumber = scanner.nextInt();
        numberAttempts++;

        do {
            if (playerNumber < randomNumber) {
                System.out.println("The number is too low.");
                System.out.print("Guess the number: ");
                playerNumber = scanner.nextInt();
            } else if (playerNumber > randomNumber) {
                System.out.println("The number is too high.");
                System.out.print("Guess the number: ");
                playerNumber = scanner.nextInt();
            }
            numberAttempts++;
        } while(playerNumber != randomNumber);
        System.out.println("Congratulations! You guessed the number: " + randomNumber + " in " + numberAttempts + " times!");
        System.out.println(playerData.name + " won the game!");
        mainMenu();
    }
    public static void advanceMode() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        Color color = new Color();

        System.out.println(color.YELLOW + "In this mode you choose the range of guessing number." + color.RESET);
        player.playerName();
        System.out.print("Select lower range: ");
        int lowerRange = scanner.nextInt();
        System.out.print("Select upper range: ");
        int upperRange = scanner.nextInt();

        int randomNumber = random.nextInt(lowerRange, upperRange);
        boolean guessed = false;
        int playerAttempts = 0;
        int playerNumber;

        System.out.println(color.YELLOW + "OK. Now you are guessing the number from: " + lowerRange + " to " + upperRange + color.RESET);

        while (!guessed) {
            System.out.print("Type your trial: ");
            playerNumber = scanner.nextInt();
            playerAttempts++;

            if (playerNumber > randomNumber) {
                System.out.println(color.RED + "Number it too high." + color.RESET);
            } else if (playerNumber < randomNumber) {
                System.out.println(color.RED + "Number is too low." + color.RESET);
            } else {
                System.out.println(color.GREEN + "Congratulations! You are guessed the number in " + playerAttempts + " times!" + color.RESET);
                guessed = true;
            }
        }
        mainMenu();
    }
    public static void computerGuessing() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Computer computer = new Computer();
        int computerAttempts = 0;
        int lowerRange = 1;
        int upperRange = 100;
        boolean numberGuessed = false;

        System.out.println("In this mode, " + computer.name + " will guess your number.");
        System.out.println("Think of a number from 1 to 100.");
        System.out.println("================================");

        while (!numberGuessed) {
            int randomNumber = random.nextInt(lowerRange, upperRange);
            computerAttempts++;
            System.out.println("Is your number: " + randomNumber + " ?");
            System.out.println("1. Number is too high.");
            System.out.println("2. Number is too low.");
            System.out.println("3. It's my number!");
            System.out.print("Type number of your choice: ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("1")) {
                upperRange = randomNumber - 1;
            } else if (choice.equalsIgnoreCase("2")) {
                lowerRange = randomNumber + 1;
            } else if (choice.equalsIgnoreCase("3")){
                System.out.println("Great! I guessed the number for " + computerAttempts + " times!");
                numberGuessed = true;
            } else {
                System.out.println("Type option from 1 to 3.");
            }

            if (lowerRange > upperRange) {
                System.out.println("Don't cheat ;)");
                break;
            }
        }
        mainMenu();
    }
    public static void playerVScomputer() {
        Color color = new Color();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        Computer computer = new Computer();
        int playerAttempts = 0;
        int computerAttempts = 0;
        int playerNumber;
        boolean guessed = false;
        int lowerRange = 1;
        int upperRange = 100;

        System.out.println(color.YELLOW + "In this mode you will play against " + computer.name + color.RESET);
        player.playerName();
        int numberToGuess = random.nextInt(11);

        while(!guessed) {
            boolean turn = false;
            while (!turn) {
                System.out.print(color.GREEN + "Guess the number: " + color.RESET);
                playerNumber = scanner.nextInt();
                playerAttempts++;

                if (playerNumber > numberToGuess) {
                    System.out.println(color.GREEN + "Number is too high." + color.RESET);
                } else if (playerNumber < numberToGuess) {
                    System.out.println(color.GREEN + "Number is too low." + color.RESET);
                } else {
                    System.out.println(color.GREEN + "Congratulation! You are guessed the number in: " + playerAttempts + " times." + color.RESET);
                    guessed = true;
                }
                turn = true;
            }
            if (!guessed) { // if player don't guess the number make loops

                System.out.println(color.RED + computer.name + " guessing!" + color.RESET);
                int randomNumber = random.nextInt(lowerRange, upperRange);
                computerAttempts++;
                System.out.println(color.RED + "Is your number: " + randomNumber + " ?" + color.RESET);
                System.out.println("1. Number is too high.");
                System.out.println("2. Number is too low.");
                System.out.println("3. It's my number!");
                System.out.print("Type number of your choice: ");
                String choice = scanner.next();

                if (choice.equalsIgnoreCase("1")) {
                    upperRange = randomNumber - 1;
                } else if (choice.equalsIgnoreCase("2")) {
                    lowerRange = randomNumber + 1;
                } else if (choice.equalsIgnoreCase("3")){
                    System.out.println(color.RED + "Great! I guessed the number for " + computerAttempts + " times!" + color.RESET);
                    guessed = true;
                } else {
                    System.out.println("Type option from 1 to 3.");
                }

                if (lowerRange > upperRange) {
                    System.out.println(color.RED + "Don't cheat ;)" + color.RESET);
                    break;
                }
            }
        }
        System.out.println("Thank you for game!");
        mainMenu();
    }
    public static void twoPlayerMode() {
        Color color = new Color();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("In this mode you are guessing the number from 0 to 100.");
        player1.playerName();
        player2.playerName();
        System.out.println(color.GREEN + player1.name + color.RESET + " VS " + color.RED + player2.name + color.RESET);

        boolean guessed = false;
        int player1Attempts = 0;
        int player2Attempts = 0;
        int numberToGuess = random.nextInt(101);
        int player1Guess;
        int player2Guess;
        boolean player1Win = false;

        while (!guessed) {
            boolean turn = false;
            while (!turn) {
                System.out.print(color.GREEN + player1.name + " Guess the number: " + color.RESET);
                player1Guess = scanner.nextInt();
                player1Attempts++;

                if (player1Guess > numberToGuess) {
                    System.out.println(color.GREEN + "Number is too high." + color.RESET);
                } else if (player1Guess < numberToGuess) {
                    System.out.println(color.GREEN + "Number is too low." + color.RESET);
                } else {
                    System.out.println(color.GREEN + "Congratulation! You are guessed the number in: " + player1Attempts + " times." + color.RESET);
                    guessed = true;
                    player1Win = true;
                }
                turn = true;
            }
            if (!guessed) { // if player don't guess the number make loops
                System.out.print(color.RED + player2.name + " Guess the number: " + color.RESET);
                player2Guess = scanner.nextInt();
                player2Attempts++;

                if (player2Guess > numberToGuess) {
                    System.out.println(color.RED + "Number is too high." + color.RESET);
                } else if (player2Guess < numberToGuess) {
                    System.out.println(color.RED + "Number is too low." + color.RESET);
                } else {
                    System.out.println(color.RED + "Congratulation! You are guessed the number in: " + player2Attempts + " times." + color.RESET);
                    guessed = true;
                }
            }
        }
        if (player1Win) { // if player1 win do this action
            System.out.println(color.GREEN + player1.name + " win the game!" + color.RESET);
        } else {
            System.out.println(color.RED + player2.name + " win the game!" + color.RESET);
        }
        mainMenu();
    }
    public static void threePlayerMode() {
        System.out.println(" 3 players.");
    }
    public static void fourPlayerMode() {
        System.out.println(" 4 players.");
    }
}

class Player {
    String name;
    public void playerName() {
        // method that can load your nickname
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        this.name = scanner.next();
    }
}

class Computer {
    String name = "Bot";
}

class Color {
    // colours that can be used to format a text in console
    String RESET = "\u001B[0m";
    String GREEN = "\u001B[32m";
    String RED = "\u001B[31m";
    String YELLOW = "\u001B[33m";
    String BLUE = "\u001B[34m";
    String CYAN = "\u001B[36m";
}