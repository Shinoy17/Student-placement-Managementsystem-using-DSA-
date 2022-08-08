import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class UltimateList implements Serializable {
    ArrayList<Student> list = new ArrayList<>();

    //vamsi
    class Student implements Serializable {
        private String password;// password
        private Long phNo;// phone number
        private int rollNo;// roll number
        private String name;// name
        private String batch;// batch
        private float tenthPercentage;// 10th percentage
        private float twelthPercentage;// 12th percentage
        private int noOfBackLogs;// number of backlogs
        private float CGPA;// average CGPA
        private String otherQualifications;// other things in string

        private Boolean isValid;

        // single parametric constructor for Student class
        Student() {
            this.password = "12345678";
            isValid = true;
        }

        // parametric constructor for Student class
        Student(Long phNo, int rollNo, String name, String batch, String password) {
            this.name = name;
            this.password = password;
            this.phNo = phNo;
            this.rollNo = rollNo;
            this.batch = batch;
            isValid = true;
        }

        Student(String password, Long phNo, int rollNo, String name, float tenthPercentage, float twelthPercentage,
                int noOfBackLogs, float CGPA, String otherQualifications) {
            this.password = password;
            this.phNo = phNo;
            this.rollNo = rollNo;
            this.name = name;
            this.tenthPercentage = tenthPercentage;
            this.twelthPercentage = twelthPercentage;
            this.noOfBackLogs = noOfBackLogs;
            this.CGPA = CGPA;
            this.otherQualifications = otherQualifications;
            isValid = true;
        }

        // setter and getter for phone number
        public Long getphNo() {
            return this.phNo;
        }

        public void setphNo(Long phNo) {
            this.phNo = phNo;
        }

        // setter and getter for name
        public String getname() {
            return this.name;
        }

        public void setname(String name) {
            this.name = name;
        }

        // setter and getter for roll number
        public int getrollNo() {
            return this.rollNo;
        }

        public void setrollNo(int rollNo) {
            this.rollNo = rollNo;
        }

        // setter and getter for batch
        public String getbatch() {
            return this.batch;
        }

        public void setbatch(String batch) {
            this.batch = batch;
        }

        // setter and getter for tenth percentage
        public float gettenthPercentage() {
            return this.tenthPercentage;
        }

        public void settenthPercentage(float tenthPercentage) {
            this.tenthPercentage = tenthPercentage;
        }

        // setter and getter for 12th percentage
        public float gettwelthhPercentage() {
            return this.twelthPercentage;
        }

        public void settwelthPercentage(float twelthPercentage) {
            this.twelthPercentage = twelthPercentage;
        }

        // setter and getter for other qualifications
        public String getotherQualifications() {
            return this.otherQualifications;
        }

        public void setotherQualifications(String otherQualifications) {
            this.otherQualifications = otherQualifications;
        }

        // setter and getter for no of backlogs
        public int getnoOfBackLogs() {
            return this.noOfBackLogs;
        }

        public void setBackLogs(int noOfBackLogs) {
            this.noOfBackLogs = noOfBackLogs;
        }

        // setter and getter for CGPA
        public float getCGPA() {
            return this.CGPA;
        }

        public void setCGPA(float CGPA) {
            this.CGPA = CGPA;
        }

        // setter and getter for password
        public String getPassword() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void changeValidity(Boolean b) {
            this.isValid = b;
        }

        // all details in multiple lines
        public String toString() {
            return ("name: " + this.name +
                    ";\nbatch: " + this.batch + ";\nCGPA: " + this.CGPA + ";\nRoll Number: " +
                    this.rollNo + ";\nTenth Percentage: " + this.tenthPercentage + ";\nTwelth Percentage: " +
                    this.twelthPercentage + ";\nNo of Backlogs: " + this.noOfBackLogs);
        }

        // all details in one line
        public String oneLineString() {
            return ("name: " + this.name + "; phone: " + this.phNo +
                    "; batch: " + this.batch + "; CGPA: " + this.CGPA + "; Roll Number: " +
                    this.rollNo + "; Tenth Percentage: " + this.tenthPercentage + "; Twelth Percentage: " +
                    this.twelthPercentage + "; No of Backlogs: " + this.noOfBackLogs);
        }

        Student prevCGPA;
        Student nextCGPA;

        Student prevBacklogs;
        Student nextBacklogs;

        Student prevtenthPercentage;
        Student nexttenthPercentage;

        Student prevtwelthPercentage;
        Student nexttwelthPercentage;
    }

    // Sathvik
    UltimateList() {
        try {
            UltimateList ul = stateSaver.readList();
            this.headBacklogs = ul.headBacklogs;
            this.headCGPA = ul.headCGPA;
            this.headtenthPercentage = ul.headtenthPercentage;
            this.headtwelthPercentage = ul.headtwelthPercentage;
            this.tailBacklogs = ul.tailBacklogs;
            this.tailCGPA = ul.tailCGPA;
            this.tailtenthPercentage = ul.tailtenthPercentage;
            this.tailtwelthPercentage = ul.tailtwelthPercentage;
            this.list = ul.list;

            // ul = null;
        } catch (ClassNotFoundException | IOException e) {
            try {
                stateSaver.writeList(this);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    int size = 0;

    Student headCGPA;
    Student tailCGPA;

    Student headBacklogs;
    Student tailBacklogs;

    Student headtenthPercentage;
    Student tailtenthPercentage;

    Student headtwelthPercentage;
    Student tailtwelthPercentage;

    
    private void add(Student s) {

        if (headCGPA == null) {
            this.headCGPA = s;
            this.tailCGPA = s;
        } else if (headCGPA == tailCGPA) {
            if (headCGPA.CGPA > s.CGPA) {
                headCGPA.nextCGPA = s;
                s.prevCGPA = headCGPA;
                tailCGPA = s;
                tailCGPA.nextCGPA = null;
            } else {
                s.nextCGPA = headCGPA;
                headCGPA.prevCGPA = s;
                headCGPA = s;
                headCGPA.prevCGPA = null;
            }
        } else if (headCGPA.CGPA <= s.CGPA) {
            s.nextCGPA = headCGPA;
            headCGPA.prevCGPA = s;
            headCGPA = s;
            headCGPA.prevCGPA = null;
        } else if (tailCGPA.CGPA > s.CGPA) {
            tailCGPA.nextCGPA = s;
            s.prevCGPA = tailCGPA;
            tailCGPA = s;
            tailCGPA.nextCGPA = null;
        } else {
            Student currentStu = headCGPA;
            while (currentStu.CGPA > s.CGPA) {
                currentStu = currentStu.nextCGPA;
            }
            s.prevCGPA = currentStu.prevCGPA;
            s.nextCGPA = currentStu;

            currentStu.prevCGPA.nextCGPA = s;
            currentStu.prevCGPA = s;
        }

        if (headBacklogs == null) {
            this.headBacklogs = s;
            this.tailBacklogs = s;
        } else if (headBacklogs == tailBacklogs) {
            if (headBacklogs.noOfBackLogs > s.noOfBackLogs) {
                headBacklogs.nextBacklogs = s;
                s.prevBacklogs = headBacklogs;
                tailBacklogs = s;
                tailBacklogs.nextBacklogs = null;
            } else {
                s.nextBacklogs = headBacklogs;
                headBacklogs.prevBacklogs = s;
                headBacklogs = s;
                headBacklogs.prevBacklogs = null;
            }

        } else if (headBacklogs.noOfBackLogs <= s.noOfBackLogs) {
            s.nextBacklogs = headBacklogs;
            headBacklogs.prevBacklogs = s;
            headBacklogs = s;
            headBacklogs.prevBacklogs = null;
        } else if (tailBacklogs.noOfBackLogs > s.noOfBackLogs) {
            tailBacklogs.nextBacklogs = s;
            s.prevBacklogs = tailBacklogs;
            tailBacklogs = s;
            tailBacklogs.nextBacklogs = null;
        } else {
            Student currentStu = headBacklogs;
            while (currentStu.noOfBackLogs > s.noOfBackLogs) {
                currentStu = currentStu.nextBacklogs;
            }
            s.prevBacklogs = currentStu.prevBacklogs;
            s.nextBacklogs = currentStu;

            currentStu.prevBacklogs.nextBacklogs = s;
            currentStu.prevBacklogs = s;
        }

        if (headtenthPercentage == null) {
            this.headtenthPercentage = s;
            this.tailtenthPercentage = s;
        } else if (headtenthPercentage == tailtenthPercentage) {
            if (headtenthPercentage.tenthPercentage > s.tenthPercentage) {
                headtenthPercentage.nexttenthPercentage = s;
                s.prevtenthPercentage = headtenthPercentage;
                tailtenthPercentage = s;
                tailtenthPercentage.nexttenthPercentage = null;
            } else {
                s.nexttenthPercentage = headtenthPercentage;
                headtenthPercentage.prevtenthPercentage = s;
                headtenthPercentage = s;
                headtenthPercentage.prevtenthPercentage = null;
            }
        } else if (headtenthPercentage.tenthPercentage <= s.tenthPercentage) {
            s.nexttenthPercentage = headtenthPercentage;
            headtenthPercentage.prevtenthPercentage = s;
            headtenthPercentage = s;
            headtenthPercentage.prevtenthPercentage = null;
        } else if (tailtenthPercentage.tenthPercentage > s.tenthPercentage) {
            tailtenthPercentage.nexttenthPercentage = s;
            s.prevtenthPercentage = tailtenthPercentage;
            tailtenthPercentage = s;
            tailtenthPercentage.nexttenthPercentage = null;
        } else {
            Student currentStu = headtenthPercentage;
            while (currentStu.tenthPercentage > s.tenthPercentage) {
                currentStu = currentStu.nexttenthPercentage;
            }
            s.prevtenthPercentage = currentStu.prevtenthPercentage;
            s.nexttenthPercentage = currentStu;

            currentStu.prevtenthPercentage.nexttenthPercentage = s;
            currentStu.prevtenthPercentage = s;
        }

        if (headtwelthPercentage == null) {
            this.headtwelthPercentage = s;
            this.tailtwelthPercentage = s;
        } else if (headtwelthPercentage == tailtwelthPercentage) {
            if (headtwelthPercentage.twelthPercentage > s.twelthPercentage) {
                headtwelthPercentage.nexttwelthPercentage = s;
                s.prevtwelthPercentage = headtwelthPercentage;
                tailtwelthPercentage = s;
                tailtwelthPercentage.nexttwelthPercentage = null;
            } else {
                s.nexttwelthPercentage = headtwelthPercentage;
                headtwelthPercentage.prevtwelthPercentage = s;
                headtwelthPercentage = s;
                headtwelthPercentage.prevtwelthPercentage = null;
            }
        } else if (headtwelthPercentage.twelthPercentage <= s.twelthPercentage) {
            s.nexttwelthPercentage = headtwelthPercentage;
            headtwelthPercentage.prevtwelthPercentage = s;
            headtwelthPercentage = s;
            headtwelthPercentage.prevtwelthPercentage = null;
        } else if (tailtwelthPercentage.twelthPercentage > s.twelthPercentage) {
            tailtwelthPercentage.nexttwelthPercentage = s;
            s.prevtwelthPercentage = tailtwelthPercentage;
            tailtwelthPercentage = s;
            tailtwelthPercentage.nexttwelthPercentage = null;
        } else {
            Student currentStu = headtwelthPercentage;
            while (currentStu.twelthPercentage > s.twelthPercentage) {
                currentStu = currentStu.nexttwelthPercentage;
            }
            s.prevtwelthPercentage = currentStu.prevtwelthPercentage;
            s.nexttwelthPercentage = currentStu;

            currentStu.prevtwelthPercentage.nexttwelthPercentage = s;
            currentStu.prevtwelthPercentage = s;
        }

        size++;
        list.add(s);
        try {
            stateSaver.writeList(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(int rollNo) {
        Student currentStu = headCGPA;
        while (currentStu != null) {
            if (currentStu.rollNo == rollNo) {
                currentStu.prevCGPA.nextCGPA = currentStu.nextCGPA;
                currentStu.prevBacklogs.nextBacklogs = currentStu.nextBacklogs;
                currentStu.prevtenthPercentage.nexttenthPercentage = currentStu.nexttenthPercentage;
                currentStu.prevtwelthPercentage.nexttwelthPercentage = currentStu.nexttwelthPercentage;

                currentStu.nextCGPA.prevCGPA = currentStu.prevCGPA;
                currentStu.nextBacklogs.prevBacklogs = currentStu.prevBacklogs;
                currentStu.nexttenthPercentage.prevtenthPercentage = currentStu.prevtenthPercentage;
                currentStu.nexttwelthPercentage.prevtwelthPercentage = currentStu.prevtwelthPercentage;

                currentStu.nextCGPA = null;
                currentStu.nextBacklogs = null;
                currentStu.nexttenthPercentage = null;
                currentStu.nexttwelthPercentage = null;

                currentStu.prevCGPA = null;
                currentStu.prevBacklogs = null;
                currentStu.prevtenthPercentage = null;
                currentStu.prevtwelthPercentage = null;
                try {
                    stateSaver.writeList(this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            } else {
                currentStu = currentStu.nextCGPA;
                continue;
            }
        }
        System.out.println("The roll number you are trying to delete doesnt exist");
    }

    public void print(String sort_Parameter) {
        Student currentStu;
        switch (sort_Parameter) {
            case "CGPA":
                currentStu = headCGPA;
                if (headCGPA == null) {
                    System.out.println("List is empty");
                    return;
                }
                while (currentStu != null) {
                    System.out.println(currentStu.oneLineString());
                    currentStu = currentStu.nextCGPA;
                }
                System.out.println();
                break;

            case "BackLogs":
                currentStu = headBacklogs;
                if (headBacklogs == null) {
                    System.out.println("List is empty");
                    return;
                }
                while (currentStu != null) {
                    System.out.println(currentStu.oneLineString());
                    currentStu = currentStu.nextBacklogs;
                }
                System.out.println();
                break;

            case "tenthPercentage":
                currentStu = headtenthPercentage;
                if (headtenthPercentage == null) {
                    System.out.println("List is empty");
                    return;
                }
                while (currentStu != null) {
                    System.out.println(currentStu.oneLineString());
                    currentStu = currentStu.nexttenthPercentage;
                }
                System.out.println();
                break;

            case "twelthPercentage":
                currentStu = headtwelthPercentage;
                if (headtwelthPercentage == null) {
                    System.out.println("List is empty");
                    return;
                }
                while (currentStu != null) {
                    System.out.println(currentStu.oneLineString());
                    currentStu = currentStu.nexttwelthPercentage;
                }
                System.out.println();
                break;

            default:
                break;
        }
    }

    private void rePosition_CGPA(Student s) {
        if (s != headCGPA & s != tailCGPA) {
            s.nextCGPA.prevCGPA = s.prevCGPA;
            s.prevCGPA.nextCGPA = s.nextCGPA;
        } else if (s == headCGPA & s == tailCGPA) {
            return;
        } else if (s == headCGPA) {
            headCGPA = s.nextCGPA;
            s.nextCGPA.prevCGPA = null;
        } else if (s == tailCGPA) {
            tailCGPA = s.prevCGPA;
            tailCGPA.nextCGPA = null;
        }

        if (headCGPA == null) {
            this.headCGPA = s;
            this.tailCGPA = s;
        } else if (headCGPA == tailCGPA) {
            if (headCGPA.CGPA > s.CGPA) {
                headCGPA.nextCGPA = s;
                s.prevCGPA = headCGPA;
                tailCGPA = s;
                tailCGPA.nextCGPA = null;
            } else {
                s.nextCGPA = headCGPA;
                headCGPA.prevCGPA = s;
                headCGPA = s;
                headCGPA.prevCGPA = null;
            }
        } else if (headCGPA.CGPA <= s.CGPA) {
            s.nextCGPA = headCGPA;
            headCGPA.prevCGPA = s;
            headCGPA = s;
            headCGPA.prevCGPA = null;
        } else if (tailCGPA.CGPA > s.CGPA) {
            tailCGPA.nextCGPA = s;
            s.prevCGPA = tailCGPA;
            tailCGPA = s;
            tailCGPA.nextCGPA = null;
        } else {
            Student currentStu = headCGPA;
            while (currentStu.CGPA > s.CGPA) {
                currentStu = currentStu.nextCGPA;
            }
            s.prevCGPA = currentStu.prevCGPA;
            s.nextCGPA = currentStu;

            currentStu.prevCGPA.nextCGPA = s;
            currentStu.prevCGPA = s;
        }

    }

    private void rePosition_BackLogs(Student s) {
        if (s != headBacklogs & s != tailBacklogs) {
            s.nextBacklogs.prevBacklogs = s.prevBacklogs;
            s.prevBacklogs.nextBacklogs = s.nextBacklogs;
        } else if (s == headBacklogs & s == tailBacklogs) {
            return;
        } else if (s == headBacklogs) {
            headBacklogs = s.nextBacklogs;
            s.nextBacklogs.prevBacklogs = null;
        } else if (s == tailBacklogs) {
            tailBacklogs = s.prevBacklogs;
            tailBacklogs.nextBacklogs = null;
        }

        if (headBacklogs == null) {
            this.headBacklogs = s;
            this.tailBacklogs = s;
        } else if (headBacklogs == tailBacklogs) {
            if (headBacklogs.noOfBackLogs > s.noOfBackLogs) {
                headBacklogs.nextBacklogs = s;
                s.prevBacklogs = headBacklogs;
                tailBacklogs = s;
                tailBacklogs.nextBacklogs = null;
            } else {
                s.nextBacklogs = headBacklogs;
                headBacklogs.prevBacklogs = s;
                headBacklogs = s;
                headBacklogs.prevBacklogs = null;
            }

        } else if (headBacklogs.noOfBackLogs <= s.noOfBackLogs) {
            s.nextBacklogs = headBacklogs;
            headBacklogs.prevBacklogs = s;
            headBacklogs = s;
            headBacklogs.prevBacklogs = null;
        } else if (tailBacklogs.noOfBackLogs > s.noOfBackLogs) {
            tailBacklogs.nextBacklogs = s;
            s.prevBacklogs = tailBacklogs;
            tailBacklogs = s;
            tailBacklogs.nextBacklogs = null;
        } else {
            Student currentStu = headBacklogs;
            while (currentStu.noOfBackLogs > s.noOfBackLogs) {
                currentStu = currentStu.nextBacklogs;
            }
            s.prevBacklogs = currentStu.prevBacklogs;
            s.nextBacklogs = currentStu;

            currentStu.prevBacklogs.nextBacklogs = s;
            currentStu.prevBacklogs = s;
        }

    }

    private void rePosition_tenth(Student s) {
        if (s != headtenthPercentage & s != tailtenthPercentage) {
            s.nexttenthPercentage.prevtenthPercentage = s.prevtenthPercentage;
            s.prevtenthPercentage.nexttenthPercentage = s.nexttenthPercentage;
        } else if (s == headtenthPercentage & s == tailtenthPercentage) {
            return;
        } else if (s == headtenthPercentage) {
            headtenthPercentage = s.nexttenthPercentage;
            s.nexttenthPercentage.prevtenthPercentage = null;
        } else if (s == tailtenthPercentage) {
            tailtenthPercentage = s.prevtenthPercentage;
            tailtenthPercentage.nexttenthPercentage = null;
        }

        if (headtenthPercentage == null) {
            this.headtenthPercentage = s;
            this.tailtenthPercentage = s;
        } else if (headtenthPercentage == tailtenthPercentage) {
            if (headtenthPercentage.tenthPercentage > s.tenthPercentage) {
                headtenthPercentage.nexttenthPercentage = s;
                s.prevtenthPercentage = headtenthPercentage;
                tailtenthPercentage = s;
                tailtenthPercentage.nexttenthPercentage = null;
            } else {
                s.nexttenthPercentage = headtenthPercentage;
                headtenthPercentage.prevtenthPercentage = s;
                headtenthPercentage = s;
                headtenthPercentage.prevtenthPercentage = null;
            }
        } else if (headtenthPercentage.tenthPercentage <= s.tenthPercentage) {
            s.nexttenthPercentage = headtenthPercentage;
            headtenthPercentage.prevtenthPercentage = s;
            headtenthPercentage = s;
            headtenthPercentage.prevtenthPercentage = null;
        } else if (tailtenthPercentage.tenthPercentage > s.tenthPercentage) {
            tailtenthPercentage.nexttenthPercentage = s;
            s.prevtenthPercentage = tailtenthPercentage;
            tailtenthPercentage = s;
            tailtenthPercentage.nexttenthPercentage = null;
        } else {
            Student currentStu = headtenthPercentage;
            while (currentStu.tenthPercentage > s.tenthPercentage) {
                currentStu = currentStu.nexttenthPercentage;
            }
            s.prevtenthPercentage = currentStu.prevtenthPercentage;
            s.nexttenthPercentage = currentStu;

            currentStu.prevtenthPercentage.nexttenthPercentage = s;
            currentStu.prevtenthPercentage = s;
        }

    }

    private void rePosition_twelth(Student s) {

        if (s != headtwelthPercentage & s != tailtwelthPercentage) {
            s.nexttwelthPercentage.prevtwelthPercentage = s.prevtwelthPercentage;
            s.prevtwelthPercentage.nexttwelthPercentage = s.nexttwelthPercentage;
        } else if (s == headtwelthPercentage & s == tailtwelthPercentage) {
            return;
        } else if (s == headtwelthPercentage) {
            headtwelthPercentage = s.nexttwelthPercentage;
            s.nexttwelthPercentage.prevtwelthPercentage = null;
        } else if (s == tailtwelthPercentage) {
            tailtwelthPercentage = s.prevtwelthPercentage;
            tailtwelthPercentage.nexttwelthPercentage = null;
        }

        if (headtwelthPercentage == null) {
            this.headtwelthPercentage = s;
            this.tailtwelthPercentage = s;
        } else if (headtwelthPercentage == tailtwelthPercentage) {
            if (headtwelthPercentage.twelthPercentage > s.twelthPercentage) {
                headtwelthPercentage.nexttwelthPercentage = s;
                s.prevtwelthPercentage = headtwelthPercentage;
                tailtwelthPercentage = s;
                tailtwelthPercentage.nexttwelthPercentage = null;
            } else {
                s.nexttwelthPercentage = headtwelthPercentage;
                headtwelthPercentage.prevtwelthPercentage = s;
                headtwelthPercentage = s;
                headtwelthPercentage.prevtwelthPercentage = null;
            }
        } else if (headtwelthPercentage.twelthPercentage <= s.twelthPercentage) {
            s.nexttwelthPercentage = headtwelthPercentage;
            headtwelthPercentage.prevtwelthPercentage = s;
            headtwelthPercentage = s;
            headtwelthPercentage.prevtwelthPercentage = null;
        } else if (tailtwelthPercentage.twelthPercentage > s.twelthPercentage) {
            tailtwelthPercentage.nexttwelthPercentage = s;
            s.prevtwelthPercentage = tailtwelthPercentage;
            tailtwelthPercentage = s;
            tailtwelthPercentage.nexttwelthPercentage = null;
        } else {
            Student currentStu = headtwelthPercentage;
            while (currentStu.twelthPercentage > s.twelthPercentage) {
                currentStu = currentStu.nexttwelthPercentage;
            }
            s.prevtwelthPercentage = currentStu.prevtwelthPercentage;
            s.nexttwelthPercentage = currentStu;

            currentStu.prevtwelthPercentage.nexttwelthPercentage = s;
            currentStu.prevtwelthPercentage = s;
        }
    }

    // Vamsi
    public void register(Long phNo, int rollNo, String name, String batch, String password) {

        Student s = new Student(phNo, rollNo, name, batch, password);
        int in_roll = s.getrollNo();
        boolean flag = true;
        Student currentStu = headCGPA;
        while (currentStu != null) {
            boolean signal;
            if (currentStu.getrollNo() == in_roll) {
                signal = false;
            } else {
                signal = true;
            }
            flag = flag & signal;
            currentStu = currentStu.nextCGPA;
        }
        if (flag) {
            add(s);
            System.out.println("you have been succesfully registerd fto SPMS\nYour serial number is " +
                    list.indexOf(s) + "\nplease remember this for future purposes");
        } else {
            System.out.println("the roll number you are trying to use is already registered please try again");
        }
    }

    public void register(String password, Long phNo, int rollNo, String name, float tenthPercentage,
            float twelthPercentage, int noOfBackLogs, float CGPA, String otherQualifications) {

        Student s = new Student(password, phNo, rollNo, name, tenthPercentage, twelthPercentage, noOfBackLogs, CGPA,
                otherQualifications);

        int in_roll = s.getrollNo();
        boolean flag = true;
        Student currentStu = headCGPA;
        while (currentStu != null) {
            boolean signal;
            if (currentStu.getrollNo() == in_roll) {
                signal = false;
            } else {
                signal = true;
            }
            flag = flag & signal;
            currentStu = currentStu.nextCGPA;
        }
        if (flag) {
            add(s);
            list.add(s);
            System.out.println("you have been succesfully registerd fto SPMS\nYour serial number is " +
                    list.indexOf(s) + "\nplease remember this for future purposes");
        } else {
            System.out.println("the roll number you are trying to use is already registered please try again");
        }
    }

    // Girish
    void changeValidity(int rollNo, Boolean b) {
        Student currentStu = headCGPA;
        while (currentStu != null) {
            if (currentStu.rollNo == rollNo) {
                currentStu.isValid = b;
                try {
                    stateSaver.writeList(this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            } else {
                currentStu = currentStu.nextCGPA;
                continue;
            }
        }
        System.out.println("The roll number you are trying to delete doesnt exist");
    }

    @SuppressWarnings("resource")
    void login(int ser_no, String password) throws ClassNotFoundException, IOException {
        // check if the entered password is correct for the entered serial number
        // if correct password runs the following
        if (list.get(ser_no).getPassword().equals(password)) {
            Boolean flag = true;
            Scanner sc = new Scanner(System.in);

            // used to keep infinite loop till the user wants to exit
            while (flag) {
                // code for prompting the user for using available actions
                stateSaver.writeList(this);
                System.out.println("to see all your details press 1");
                System.out.println("to change your phone number press 2");
                System.out.println("to change your batch press 3");
                System.out.println("to set your tenth percentage press 4");
                System.out.println("to set your twelth percentage press 5");
                System.out.println("to set your CGPA press 6");
                System.out.println("to set number of backlogs press 7");
                System.out.println("to log out press 8");
                System.out.println("*".repeat(75));
                int input = sc.nextInt();
                sc.nextLine();

                // displays all the saved information till now
                if (input == 1) {
                    System.out.println(list.get(ser_no).toString());
                }

                // code to change the phone number
                else if (input == 2) {
                    System.out.println("current phone number: " + list.get(ser_no).getphNo());
                    System.out.println("enter new phone number: ");
                    long newphone = sc.nextLong();
                    sc.nextLine();
                    Student s = list.get(ser_no);
                    s.setphNo(newphone);
                    list.set(ser_no, s);
                    System.out.println("phone Number changed");
                    System.out.println("*".repeat(75));
                }

                // code to change the batch
                else if (input == 3) {
                    System.out.println("current batch: " + list.get(ser_no).getbatch());
                    System.out.println("enter new batch: ");
                    String newbatch = sc.nextLine();
                    Student s = list.get(ser_no);
                    s.setbatch(newbatch);
                    list.set(ser_no, s);
                    System.out.println("batch changed");
                    System.out.println("*".repeat(75));
                }

                // code to change the 10th percentage
                else if (input == 4) {
                    System.out.println("current tenth percentage: " + list.get(ser_no).gettenthPercentage());
                    System.out.println("enter new tenth percentage: ");
                    Float newtenthpercentage = sc.nextFloat();
                    sc.nextLine();
                    Student s = list.get(ser_no);
                    s.settenthPercentage(newtenthpercentage);
                    list.set(ser_no, s);
                    System.out.println("tenth percentage changed");
                    System.out.println("*".repeat(75));
                    rePosition_tenth(s);
                }

                // code to change the 12th percentage
                else if (input == 5) {
                    System.out.println("current twelth percentage: " + list.get(ser_no).gettwelthhPercentage());
                    System.out.println("enter new twelth percentage: ");
                    Float newtwelthpercentage = sc.nextFloat();
                    sc.nextLine();
                    Student s = list.get(ser_no);
                    s.settwelthPercentage(newtwelthpercentage);
                    list.set(ser_no, s);
                    System.out.println("twelth percentage changed");
                    System.out.println("*".repeat(75));
                    rePosition_twelth(s);
                }

                // code to change CGPA
                else if (input == 6) {
                    System.out.println("current CGPA: " + list.get(ser_no).getCGPA());
                    System.out.println("enter new CGPA: ");
                    Float newCGPA = sc.nextFloat();
                    sc.nextLine();
                    Student s = list.get(ser_no);
                    s.setCGPA(newCGPA);
                    list.set(ser_no, s);
                    System.out.println("CGPA changed");
                    rePosition_CGPA(s);
                    System.out.println("*".repeat(75));
                }

                // code to change the number of backlogs
                else if (input == 7) {
                    System.out.println("current number of backlogs: " + list.get(ser_no).getnoOfBackLogs());
                    System.out.println("enter new number of backlogs: ");
                    int newbl = sc.nextInt();
                    sc.nextLine();
                    Student s = list.get(ser_no);
                    s.setBackLogs(newbl);
                    list.set(ser_no, s);
                    System.out.println("number of backlogs changed");
                    rePosition_BackLogs(s);
                    System.out.println("*".repeat(75));
                }

                // code to logout and exit the infinite loop
                else if (input == 8) {
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

    // Mohit
    public ArrayList<Student> getTopCGPA(int i) {
        ArrayList<Student> li = new ArrayList<>();
        Student currStudent = headCGPA;
        for (int j = 0; j < i; j++) {
            if (currStudent.isValid) {
                if (!(li.contains(currStudent))) {
                    li.add(currStudent);
                }
            }
            if (currStudent.nextCGPA != null) {
                currStudent = currStudent.nextCGPA;
            }
        }
        return li;
    }

    public ArrayList<Student> getTopTenth(int i) {
        ArrayList<Student> li = new ArrayList<>();
        Student currStudent = headtenthPercentage;
        for (int j = 0; j < i; j++) {
            if (currStudent.isValid) {
                if (!(li.contains(currStudent))) {
                    li.add(currStudent);
                }
            }
            if (currStudent.nexttenthPercentage != null) {
                currStudent = currStudent.nexttenthPercentage;
            }
        }
        return li;
    }

    public ArrayList<Student> getTopTwelth(int i) {

        ArrayList<Student> li = new ArrayList<>();
        Student currStudent = headtwelthPercentage;
        for (int j = 0; j < i; j++) {
            if (currStudent.isValid) {
                if (!(li.contains(currStudent))) {
                    li.add(currStudent);
                }
            }
            if (currStudent.nexttwelthPercentage != null) {
                currStudent = currStudent.nexttwelthPercentage;
            }
        }
        return li;
    }

    public ArrayList<Student> getLeastBacklogs(int i) {
        ArrayList<Student> li = new ArrayList<>();
        Student currStudent = tailBacklogs;
        for (int j = 0; j < i; j++) {
            if (currStudent.isValid) {
                if (!(li.contains(currStudent))) {
                    li.add(currStudent);
                }
            }
            if (currStudent.prevBacklogs != null) {
                currStudent = currStudent.prevBacklogs;
            }
        }
        return li;
    }

    public ArrayList<Student> filter(Float tenthpercentage, float twelthPercentage, int noOfBackLogs, float CGPA)
            throws ClassNotFoundException, IOException {

        ArrayList<Student> req_student = new ArrayList<Student>();
        Student s = headCGPA;
        for (int j = 0; j < this.size; j++) {
            if (s.isValid) {
                if (!(req_student.contains(s))) {
                    if (s.gettenthPercentage() >= tenthpercentage) {
                        if (s.gettwelthhPercentage() >= twelthPercentage) {
                            if (s.getnoOfBackLogs() <= noOfBackLogs) {
                                if (s.getCGPA() >= CGPA) {
                                    req_student.add(s);
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                }
            }
            if (s.nextCGPA != null) {
                s = s.nextCGPA;
            }
        }
        return req_student;
    }

    public void resetApplication() {
        this.headCGPA = null;
        this.tailCGPA = null;
        this.headBacklogs = null;
        this.tailBacklogs = null;
        this.headtenthPercentage = null;
        this.tailtenthPercentage = null;
        this.headtwelthPercentage = null;
        this.tailtwelthPercentage = null;
        this.list.clear();
        try {
            stateSaver.writeList(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAll() {
        for (Student student : list) {
            System.out.println(student.oneLineString());
        }
    }
}
