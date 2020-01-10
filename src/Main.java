import java.util.Scanner;

public class Main {
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

    }
}