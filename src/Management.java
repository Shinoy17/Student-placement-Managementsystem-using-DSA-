
import java.io.IOException;

//Girish 
public class Management {
    private String passCode = "amritavishwavidyapeetam";
    UltimateList ul = new UltimateList();
    PAList pl = new PAList(10);

    // returns the passcode
    public String getCode() {
        return passCode;
    }

    // method to null a student
    public void changeValidity(int rollNo, boolean b) throws ClassNotFoundException, IOException {
        ul.changeValidity(rollNo, b);
    }

    // priints all the details of all the students
    public void getAllStudents() throws ClassNotFoundException, IOException {
        ul.printAll();
    }

    public void getAllPA() {
        pl.print();
    }

    // method to reset the whole application
    public void reset() throws ClassNotFoundException, IOException {
        ul.resetApplication();
    }
}
