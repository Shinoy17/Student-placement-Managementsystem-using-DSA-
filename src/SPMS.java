import java.io.IOException;
import java.util.Scanner;


// mohit
public class SPMS {
    //this main method integerates all the componenets of the software 
    public static void main(String[] args){

        boolean flag = true;
        System.out.println("Welcome to Student Placement Management System");
        Scanner appread = new Scanner(System.in);

        //used for keeping infinite loop till the user want to exit
        while (flag){
            System.out.println("-".repeat(75));

            //prompting user for different actions 
            System.out.println("enter \n1 if you are a student \n2 if your a placement administrator \n3 if you are college management \n4 to exit");
            System.out.println("-".repeat(75));
            int inp =appread.nextInt();

            //runs when the user is a student
            if (inp==1){
                    StudentHome.IAmStudent();
            }

            //runs when the user is a placement admin
            else if (inp==2){
                try {
                    PAHome.IAmPlacementAdmin();
                } catch (ClassNotFoundException | IOException e) {
                    System.out.println("some error occured please try again");
                } catch (IndexOutOfBoundsException s){
                    System.out.println("invalid serial number recieved");
                }
            }

            //runs when the user is from college management 
            else if (inp==3){
                try {
                    MHome.IAmManagement();
                } catch (ClassNotFoundException | IOException e) {
                    System.out.println("some error occured please try again");
                }
            }

            //runs when the user want to exit the program
            else if (inp==4){
                flag= false;
                appread.close();
            }

            //runs when invalid action selected
            else{
                System.out.println("invalid input please try again");
            }
        }
    }
}
