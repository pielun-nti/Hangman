import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class Main {

    public static int attempt = 0;
    public static String wrong = "";

    public static void main(String[] args) {
        Intro();

    }

    static void Intro() {
        try {
            System.out.println("Welcome select option");
            System.out.println("1 - vs pc");
            System.out.println("2 - vs human");
            Scanner in = new Scanner(System.in);

            //Option 1 - vs pc
            //Option 2 - vs another human
            int option = in.nextInt();
            if (option == 1) {
                vsPC();

            } else if (option == 2) {
                vsHuman();
            } else {
                System.out.println("Wrong input");
                Intro();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Intro();
        }


    }

    static void vsPC() {
        try {
            Scanner infile = null;
            String correctword = null;
            File words = new File("words.txt");
            infile = new Scanner(words);
            //BufferedReader br = new BufferedReader(fis);
            if (infile.hasNext()) {
                correctword = infile.nextLine();
            }


            System.out.println("Guess the word");
            Scanner in = new Scanner(System.in);

            String word = in.nextLine();

            if (word.contains(correctword) & (attempt != 5)) {
                System.out.println("You guessed right the word was: " + word);
                int Attemptleft = 4 - attempt;
                System.out.println("You had " + Attemptleft + " tries left");
                System.out.println("Type 1 to play again or 2 to exit");
                int number = in.nextInt();
                if (number == 1) {
                    Intro();
                }
                else if (number == 2) {
                    System.out.println("Exiting");
                } else if (number != 1 & number != 2) {
                    System.out.println("Incorrect choice try again");
                }
            } else if (attempt == 4) {
                attempt++;
                System.out.println("Game over. you tried " + attempt + " times");
                wrong += "---";
                System.out.println(wrong);
                System.out.println("Type 1 to play again or 2 to exit");
                int number = in.nextInt();
                if (number == 1) {
                    Intro();
                }
                else if (number == 2) {
                    System.out.println("Exiting");
                } else if (number != 1 & number != 2) {
                    System.out.println("Incorrect choice try again");
                }
                } else {
                    attempt++;
                    int attemptleft = 5 - attempt;
                    System.out.println("Wrong guess. Attempt left: " + attemptleft);

                    if (attempt >= 1 & attempt < 3) {
                        //System.out.println("  |");
                        //wrong += "|||";
                        wrong += "---";
                    } else if (attempt <= 2) {
                        wrong += "---";
                    }
                    else if (attempt >= 3 & attempt <= 5) {
                        wrong += "---";
                    }
                    System.out.println(wrong);
                    vsPC();
                }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void vsHuman() {

    }
}