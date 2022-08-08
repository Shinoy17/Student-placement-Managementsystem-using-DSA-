import java.io.IOException;
import java.util.Scanner;


//vamsi
public class StudentHome {

    @SuppressWarnings("resource")
    public static void IAmStudent() {

        Scanner sc2 = new Scanner(System.in);
        UltimateList ul = new UltimateList();

        System.out.println("Welcome to SPMS student portal");
        System.out.println("enter \n1 to login or \n2 to register ");

        int i2 = sc2.nextInt();

        if (i2 == 1) {

            System.out.println("please enter your SPMS serial number");
            int ent_serialNo = sc2.nextInt();
            sc2.nextLine();

            System.out.println("please enter password");
            String ent_password = sc2.nextLine();

            try {
                ul.login(ent_serialNo, ent_password);
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("Something Went Wrong During Login Please try again");
            }

        } else if (i2 == 2) {
            System.out.println("*".repeat(75));
            System.out.println("please enter your rollNo");
            int reg_roll = sc2.nextInt();
            sc2.nextLine();

            System.out.println("*".repeat(75));
            System.out.println("please enter your name");
            String reg_name = sc2.nextLine();

            System.out.println("*".repeat(75));
            System.out.println("please enter your batch eg: 21AIEB");
            String reg_batch = sc2.nextLine();

            System.out.println("*".repeat(75));
            System.out.println("please set your phone no");
            Long reg_phone = sc2.nextLong();
            sc2.nextLine();

            System.out.println("*".repeat(75));
            System.out.println("please set your password");
            String reg_password = sc2.nextLine();

            System.out.println("*".repeat(75));
            ul.register(reg_phone, reg_roll, reg_name, reg_batch, reg_password);
        }

        else {
            System.out.println("invalid input recieved please try again");
        }
    }
}
