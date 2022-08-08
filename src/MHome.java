import java.io.IOException;
import java.util.Scanner;


// Girish
@SuppressWarnings("resource")
public class MHome {
    public static void IAmManagement() throws ClassNotFoundException, IOException{
        //create an object for management class
        Management m = new Management();

        //open a scanner for taking input
        Scanner sc = new Scanner(System.in);

        //take the entered passcode and verify it
        String passcode = sc.nextLine();

        //runs when the passcode is correct
        if(m.getCode().equals(passcode)){
            boolean flag = true;
            
            //used to keep infinite loop til the user wants to exit
            while(flag){
                
                //prompting user for different actions
                System.out.println("to get all the student data enter 1");
                System.out.println("to suspend a student from portal enter 2");
                System.out.println("to delete all the data of the registered students enter 3");
                System.out.println("to get all the Placemnt admin data enter 4");
                System.out.println("to logout and exit enter 5");
                System.out.println("*".repeat(75));
                int in1= sc.nextInt();
                sc.nextLine();

                //code to print all the data of registered student
                if(in1==1){
                    m.getAllStudents();
                    System.out.println("*".repeat(75));
                }

                //code for nulling a student
                else if(in1==2){
                    System.out.println("enter the roll number of the student you want to remove: ");
                    int ind= sc.nextInt();
                    sc.nextLine();
                    m.changeValidity(ind, false);
                }

                //code for resetting the application
                else if(in1==3){
                    System.out.println("if you really want to delete all the data enter 'YES': ");
                    String res = sc.nextLine();
                    if (res.equals("YES")){
                        m.reset();
                    }
                    else{
                        System.out.println("operation cancelled");
                    }

                }

                else if(in1==4){
                    m.getAllPA();
                }

                //code for logging out
                else if(in1==5){
                    flag= false;
                    System.out.println("you have been logged out succesfully");
                }

                

                else{
                    System.out.println("invalid action try again");
                }
            }
        }
        else{
            System.out.println("the passcode entered by you is incorrect please try again");
        }
    }
}
