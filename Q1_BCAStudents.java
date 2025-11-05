

class Student {
    protected String name;
    protected int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
}

class BCAStudent extends Student {
    private int semester;
    private int marks;

    public BCAStudent(String name, int rollNo, int semester) {
        super(name, rollNo);
        this.semester = semester;
    }

    public void setMarksFromString(String marksStr) {

        this.marks = Integer.parseInt(marksStr);
    }

    public String getDetails() {
        return "Name: " + name + ", Roll No: " + rollNo + ", Semester: " + semester + ", Marks: " + marks;
    }
}

public class Q1_BCAStudents {
    public static void main(String[] args) {

        BCAStudent[] students = new BCAStudent[3];
        students[0] = new BCAStudent("Aman", 101, 3);
        students[1] = new BCAStudent("Ravi", 102, 3);
        students[2] = new BCAStudent("Sonal", 103, 3);

        try {
            students[0].setMarksFromString("78");
            students[1].setMarksFromString("85");
            students[2].setMarksFromString("90");

            for (int i = 0; i < students.length; i++) {
                System.out.println(students[i].getDetails());
            }


            System.out.println("\nDemonstrating ArrayIndexOutOfBoundsException (access index 5):");
            System.out.println(students[5].getDetails());
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.err.println("Caught ArrayIndexOutOfBoundsException: " + aioobe.getMessage());
        } catch (NumberFormatException nfe) {
            System.err.println("Caught NumberFormatException (bad number format): " + nfe.getMessage());
        } catch (Exception e) {
            System.err.println("Caught unexpected exception: " + e.getMessage());
        }


        try {
            System.out.println("\nNow demonstrating NumberFormatException by passing 'eighty' as marks:");
            students[0].setMarksFromString("eighty");
        } catch (NumberFormatException nfe) {
            System.err.println("Caught NumberFormatException: " + nfe.getMessage());
        }
    }
}
