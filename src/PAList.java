import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

// shinoy
public class PAList implements Serializable {
    private PA[] array;
    private int count;

    public PAList(int i) {

        try {
            PAList pal = readList();
            this.array = pal.array;
            this.count = pal.count;
            pal = null;
        } catch (Exception e) {
            try {
                array = new PA[i];
                this.count = 0;
                writeList(this);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void insert(PA pa) {
        if (array.length == count) {
            PA[] newArr = new PA[count * 2];
            for (int i = 0; i < count; i++) {
                newArr[i] = array[i];
            }
            array = newArr;
        }
        array[count] = pa;
        count++;
        try {
            writeList(this);
        } catch (IOException e) {
            System.out.println("cant serialize");
            e.printStackTrace();
        }
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(array[i].oneLineString());
        }
    }

    public void removeAt(int i) {
        if (i < 0 || i >= count) {
            throw new IllegalArgumentException();
        }
        for (int j = 0; j < count; j++) {
            array[i] = array[i + 1];
        }
        count--;

        try {
            writeList(this);
        } catch (IOException e) {
            System.out.println("cant serialize");
            e.printStackTrace();
        }
    }

    public int indexOf(PA pa) {
        for (int i = 0; i < count; i++) {
            if (array[i].equals(pa)) {
                return i;
            }
        }
        return -1;
    }

    static PAList readList() throws IOException, ClassNotFoundException {
        PAList pal;
        File file = new File("App_temp_PA.ser");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        pal = (PAList) ois.readObject();
        fis.close();
        ois.close();
        return pal;
    }

    static void writeList(PAList pal) throws IOException {
        File file = new File("App_temp_PA.ser");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(pal);
        fos.close();
        oos.close();
    }

    void register(String password, Long phNo, String email, String name, String Organisation)
            throws ClassNotFoundException, IOException {

        PA p = new PA(password, phNo, email, name, Organisation);
        Long in_phone = p.getPhone();
        String in_email = p.getEmail();
        boolean flag = true;
        for (int j = 0; j < count; j++) {
            PA i = array[j];
            boolean signal;
            if (i.getPhone() == in_phone | i.getEmail() == in_email) {
                signal = false;
            } else {
                signal = true;
            }
            flag = flag & signal;
        }
        if (flag) {
            insert(p);
            System.out.println("you have been succesfully registerd fto SPMS\nYour serial number is " + (count - 1)
                    + "\nplease remember this for future purposes");
        } else {
            System.out.println("the email or phone number you entered is already in use please try again");
        }
    }

    @SuppressWarnings("resource")
    void login(int ser_no, String password) throws ClassNotFoundException, IOException {

        // check if the entered password is correct for the entered serial number
        // if correct password runs the following
        if (array[ser_no].getPassword().equals(password)) {
            Boolean flag = true;
            Scanner sc = new Scanner(System.in);

            UltimateList ul = new UltimateList();

            // used to keep infinite loop till the user wants to exit
            while (flag) {
                // code for prompting the user for using available actions
                System.out.println("to see all your details press 1");
                System.out.println("to start the sorting process please enter 2");
                System.out.println("to log out enter 3");
                System.out.println("*".repeat(75));
                int input = sc.nextInt();
                sc.nextLine();

                // displays all the saved information till now
                if (input == 1) {
                    System.out.println(array[ser_no].toString());
                }

                // code to sort the students
                else if (input == 2) {
                    // taking required inputs for the sorting process
                    System.out.println("please enter minimum tenth percentage ");
                    Float req_tenthpercent = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("please enter minimum twelth percentage ");
                    Float req_twelthpercent = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("please enter maximum number of backlogs ");
                    int req_backlogs = sc.nextInt();
                    sc.nextLine();
                    System.out.println("please enter minimum CGPA ");
                    Float req_CGPA = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("*".repeat(75));

                    // for(Student s : SR.sort(req_tenthpercent, req_twelthpercent, req_backlogs,
                    // req_CGPA)){
                    // System.out.println(s.oneLineString());
                    // }
                    for (UltimateList.Student s : ul.filter(req_tenthpercent, req_twelthpercent, req_backlogs,
                            req_CGPA)) {
                        System.out.println(s.oneLineString());
                    }

                }

                // code to logout and exit the infinite loop
                else if (input == 3) {
                    flag = false;
                    System.out.println("you have been logged out");
                    System.out.println("*".repeat(75));
                }

                // code when the user enters invalid action
                else {
                    System.out.println("invalid input recieved please try another input");
                }

            }
        }
        // code when the password is incorrect
        else {
            System.out.println("the serial number and password didnt match please try again");
            System.out.println("*".repeat(75));
        }

    }

}
