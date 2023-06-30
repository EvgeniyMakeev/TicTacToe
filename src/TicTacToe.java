import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m";

    private static int counter = 0;
    private static boolean gameIsNotOver = true;
    public static char[][] gameBoard = {
            {'1', '|', '2', '|', '3'},
            {'—', '+', '—', '+', '—'},
            {'4', '|', '5', '|', '6'},
            {'—', '+', '—', '+', '—'},
            {'7', '|', '8', '|', '9'}
    };

    public static void main(String[] args) {
        System.out.println(WHITE_BOLD_BRIGHT + "Welcome to the game Tic Tac Toe!\n" + ANSI_YELLOW + "Choose a game:\n"
                + "1 - Playing with a human.\n" + "2 - Playing with the stupid computer." + ANSI_RESET);

        int ver = inputVer();
        printColoredGameBoard(gameBoard);
        int position;

        while (gameIsNotOver) {
            if (counter % 2 == 0){
                System.out.println("Turn of " + RED_BOLD_BRIGHT + "PLAYER #1 - X" + ANSI_RESET);
                position = inputTry();
                move(position, 'X');
                printColoredGameBoard(gameBoard);
            } else {
                System.out.println("Turn of " + GREEN_BOLD_BRIGHT + "PLAYER #2 - 0" + ANSI_RESET);
                position = ver == 1 ? inputTry() : compTurn();
                move(position, '0');
                printColoredGameBoard(gameBoard);
            }
            counter++;
            gameIsNotOver = checkGame();
        }

    }

    private static int compTurn() {
        Random rand = new Random();
        return rand.nextInt(9) + 1;
    }

    private static int inputVer() {
        Scanner scan = new Scanner(System.in);
        int input;
        do {
            System.out.println("Enter a number between 1 and 2.");
            input = scan.nextInt();
        }
        while (input < 1 || input > 2);
        return input;
    }

    private static int inputTry() {
        Scanner scan = new Scanner(System.in);
        int input;
        do {
            System.out.println("Enter a number between 1 and 9.");
            input = scan.nextInt();
        }
        while (input < 1 || input > 9);
        return input;
    }

    private static void move(int position, char c) {
        String wrong = ANSI_YELLOW + "This cell is already taken." + ANSI_RESET;
        switch (position) {
            case 1:
                if (gameBoard[0][0] != 'X' && gameBoard[0][0] != '0') {
                gameBoard[0][0] = c;
                } else {
                    System.out.println(wrong);
                    move(inputTry(), c);
                }
                break;
            case 2:
                if (gameBoard[0][2] != 'X' && gameBoard[0][2] != '0') {
                    gameBoard[0][2] = c;
                } else {
                    System.out.println(wrong);
                    move(inputTry(), c);
                }
                break;
            case 3:
                if (gameBoard[0][4] != 'X' && gameBoard[0][4] != '0') {
                    gameBoard[0][4] = c;
                } else {
                    System.out.println(wrong);
                    move(inputTry(), c);
                }
                break;
            case 4:
                if (gameBoard[2][0] != 'X' && gameBoard[2][0] != '0') {
                    gameBoard[2][0] = c;
                } else {
                    System.out.println(wrong);
                    move(inputTry(), c);
                }
                break;
            case 5:
                if (gameBoard[2][2] != 'X' && gameBoard[2][2] != '0') {
                    gameBoard[2][2] = c;
                } else {
                    System.out.println(wrong);
                    move(inputTry(), c);
                }
                break;
            case 6:
                if (gameBoard[2][4] != 'X' && gameBoard[2][4] != '0') {
                    gameBoard[2][4] = c;
                } else {
                    System.out.println(wrong);
                    move(inputTry(), c);
                }
                break;
            case 7:
                if (gameBoard[4][0] != 'X' && gameBoard[4][0] != '0') {
                    gameBoard[4][0] = c;
                } else {
                    System.out.println(wrong);
                    move(inputTry(), c);
                }
                break;
            case 8:
                if (gameBoard[4][2] != 'X' && gameBoard[4][2] != '0') {
                    gameBoard[4][2] = c;
                } else {
                    System.out.println(wrong);
                    move(inputTry(), c);
                }
                break;
            case 9:
                if (gameBoard[4][4] != 'X' && gameBoard[4][4] != '0') {
                    gameBoard[4][4] = c;
                } else {
                    System.out.println(wrong);
                    move(inputTry(), c);
                }
                break;
        }
    }

    private static boolean checkGame() {
        if (counter == 9) {
            return false;
        } else if ((gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X')
                || (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X')
                || (gameBoard[4][0] == 'X' && gameBoard[4][2] == 'X' && gameBoard[4][4] == 'X')
                || (gameBoard[0][0] == 'X' && gameBoard[2][0] == 'X' && gameBoard[4][0] == 'X')
                || (gameBoard[0][2] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][2] == 'X')
                || (gameBoard[0][4] == 'X' && gameBoard[2][4] == 'X' && gameBoard[4][4] == 'X')
                || (gameBoard[0][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][4] == 'X')
                || (gameBoard[0][4] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][0] == 'X')) {
            System.out.println("WINNER IS " + RED_BOLD_BRIGHT + "PLAYER #1 - X" + ANSI_RESET);
            return false;
        } else if ((gameBoard[0][0] == '0' && gameBoard[0][2] == '0' && gameBoard[0][4] == '0')
                || (gameBoard[2][0] == '0' && gameBoard[2][2] == '0' && gameBoard[2][4] == '0')
                || (gameBoard[4][0] == '0' && gameBoard[4][2] == '0' && gameBoard[4][4] == '0')
                || (gameBoard[0][0] == '0' && gameBoard[2][0] == '0' && gameBoard[4][0] == '0')
                || (gameBoard[0][2] == '0' && gameBoard[2][2] == '0' && gameBoard[4][2] == '0')
                || (gameBoard[0][4] == '0' && gameBoard[2][4] == '0' && gameBoard[4][4] == '0')
                || (gameBoard[0][0] == '0' && gameBoard[2][2] == '0' && gameBoard[4][4] == '0')
                || (gameBoard[0][4] == '0' && gameBoard[2][2] == '0' && gameBoard[4][0] == '0')) {
            System.out.println("WINNER IS " + GREEN_BOLD_BRIGHT + "PLAYER #2 - 0" + ANSI_RESET);
            return false;
        } else {
            return true;
        }
    }

    private static void printColoredGameBoard(char[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (i == 1 || i == 3) {
                    System.out.print(gameBoard[i][j]);
                } else {
                    if (j == 1 || j == 3) {
                        System.out.print(WHITE_BOLD_BRIGHT + gameBoard[i][j]);
                    } else {
                        if (gameBoard[i][j] == 'X') {
                            System.out.print(RED_BOLD_BRIGHT + gameBoard[i][j]);
                        } else if (gameBoard[i][j] == '0') {
                            System.out.print(GREEN_BOLD_BRIGHT + gameBoard[i][j]);
                        } else {
                            System.out.print(ANSI_YELLOW + gameBoard[i][j]);
                        }
                    }
                }
            }
            System.out.println(WHITE_BOLD_BRIGHT);
        }
    }
}