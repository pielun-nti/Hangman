import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;
public class test {

    public static int attempt = 0;
    public static String wrong = "";

    public static void main(String[] args) {
        Intro();

    }

    static void Intro() {
        try {
            attempt = 0;
            System.out.print("* * * * * * * * * * * * * * *"
                    + "\n*    Welcome to Hangman!    *"
                    + "\n*    Select option          *"
                    + "\n* * * * * * * * * * * * * * *");
            System.out.println("\n" + "1 - vs pc");
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
            File words = new File("words.txt");
            BufferedReader br = new BufferedReader(new FileReader(words));
            infile = new Scanner(words);
            //BufferedReader br = new BufferedReader(fis);
            ArrayList<String> list = new ArrayList<String>();
            while (infile.hasNextLine()) {
                list.add(infile.nextLine());
                System.out.println(infile.nextLine());
            }


            System.out.println("Guess the word");
            Scanner in = new Scanner(System.in);

            String word = in.nextLine();

            if (word.contains(list.toString())) {
                System.out.println("You guessed right the word was: " + word);
                int Attemptleft = 10 - attempt;
                System.out.println("You had " + Attemptleft + " tries left");
                System.out.println("Type 1 to play again or 2 to exit");
                int number = in.nextInt();
                if (number == 1) {
                    Intro();
                }
                else if (number == 2 & attempt != 9) {
                    System.out.println("Exiting");
                } else if (number != 1 & number != 2 & attempt != 4) {
                    System.out.println("Incorrect choice try again");
                }
            } else if (attempt == 9) {
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
                int attemptleft = 10 - attempt;
                System.out.println("Wrong guess. Attempt left: " + attemptleft);

                if (attempt <= 1 & attempt < 2) {
                    //System.out.println("  |");
                    //wrong += "|||";
                    wrong += "-------------";
                    System.out.println(wrong);
                } else if (attempt >= 2 & attempt < 3) {
                    wrong += "---";
                    System.out.println(
                            "\n       |"
                                    + "\n       |"
                                    + "\n       |"
                                    + "\n       |"
                                    + "\n       |"
                                    + "\n       |"
                                    + "\n" + wrong);
                } else if (attempt >= 3 & attempt < 4) {
                    //wrong += "---";
                    System.out.println(
                            "       ------------------------"
                                    + "\n       |"
                                    + "\n       |"
                                    + "\n       |"
                                    + "\n       |"
                                    + "\n       |"
                                    + "\n       |"
                                    + "\n" + wrong);
                } else if (attempt >= 4 & attempt < 5) {
                    //wrong += "---";
                    System.out.println(
                            "       ------------------------"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n" + wrong);
                } else if (attempt >= 5 & attempt < 6) {
                    //wrong += "---";
                    System.out.println(
                            "       ------------------------"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |            -----|-----"
                                    + "\n" + wrong);
                } else if (attempt >= 6 & attempt < 7) {
                    //wrong += "---";
                    System.out.println(
                            "       ------------------------"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |         --------|--------"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n" + wrong + "    -----|-----");
                } else if (attempt >= 7 & attempt < 8) {
                    //wrong += "---";
                    System.out.println(
                            "       ------------------------"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |         --------|--------"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n" + wrong + "    -----|-----");
                } else if (attempt >= 8 & attempt < 9) {
                    //wrong += "---";
                    System.out.println(
                            "       ------------------------"
                                    + "\n       |                -|-"
                                    + "\n       |         --------|--------"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n" + wrong + "    -----|-----");
                } else if (attempt >= 9 & attempt < 10) {
                    //wrong += "---";
                    System.out.println(
                            "       ------------------------"
                                    + "\n       |                -|-"
                                    + "\n       |                 |"
                                    + "\n       |         --------|--------"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n       |                 |"
                                    + "\n" + wrong + "    -----|-----");
                }

                vsPC();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void vsHuman() {

    }
}