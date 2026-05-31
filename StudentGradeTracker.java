import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Student {

    String name;
    int math;
    int science;
    int english;
    
    int total;
    double percentage;
    char grade;

    Student(String name, int math, int science, int english)
    {
        this.name = name;
        this.math = math;
        this.science = science;
        this.english = english;

        calculateResult();
    }

    void calculateResult()
    {
        total = math + science + english;

        percentage = total/3.0;

        if (percentage >= 90)
            grade = 'A';
        else if(percentage >= 75)
            grade = 'B';
        else if(percentage >= 60)
            grade = 'C';
        else if(percentage >= 40)
            grade = 'D';
        else 
            grade = 'F';
    }
    void displayStudent()
    {
      
        System.out.println("------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Maths: " + math);
        System.out.println("Science: " + science);
        System.out.println("English: " + english);
        System.out.println("Total: " + total);
        System.out.println("Percentage: " + percentage);
        System.out.println("Grade: " + grade);
    }

}
public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {

            // Menu
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Save To File");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // Add Student
                case 1:

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Maths marks: ");
                    int maths = sc.nextInt();

                    System.out.print("Enter Science marks: ");
                    int science = sc.nextInt();

                    System.out.print("Enter English marks: ");
                    int english = sc.nextInt();

                    sc.nextLine();

                    Student s = new Student(name, maths, science, english);

                    students.add(s);

                    System.out.println("Student Added Successfully!");
                    break;

                // Display All Students
                case 2:

                    if (students.isEmpty()) {

                        System.out.println("No student records found.");
                    }
                    else {

                        System.out.println("\n===== STUDENT RECORDS =====");

                        for (Student student : students) {

                            student.displayStudent();
                        }
                    }

                    break;

                // Search Student
                case 3:

                    System.out.print("Enter student name to search: ");
                    String searchName = sc.nextLine();

                    boolean found = false;

                    for (Student student : students) {

                        if (student.name.equalsIgnoreCase(searchName)) {

                            System.out.println("\nStudent Found!");
                            student.displayStudent();

                            found = true;
                            break;
                        }
                    }

                    if (!found) {

                        System.out.println("Student not found.");
                    }

                    break;

                // Save To File
                case 4:

                    try {

                        FileWriter writer = new FileWriter("students.txt");

                        writer.write("===== STUDENT RECORDS =====\n\n");

                        for (Student student : students) {

                            writer.write("Name       : " + student.name + "\n");
                            writer.write("Maths      : " + student.math + "\n");
                            writer.write("Science    : " + student.science + "\n");
                            writer.write("English    : " + student.english + "\n");
                            writer.write("Total      : " + student.total + "\n");
                            writer.write("Percentage : " + student.percentage + "\n");
                            writer.write("Grade      : " + student.grade + "\n");

                            writer.write("-----------------------------------\n");
                        }

                        writer.close();

                        System.out.println("Data saved successfully to students.txt");
                    }
                    catch (IOException e) {

                        System.out.println("Error saving file.");
                    }

                    break;

                // Exit
                case 5:

                    System.out.println("Exiting Program...");
                    break;

                // Invalid Choice
                default:

                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
