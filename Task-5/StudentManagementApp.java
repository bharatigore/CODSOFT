import java.util.ArrayList;
import java.util.Scanner;

//////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                  //
//     class name :  StudentManagementApp                                                           //
//     Description : The class serves as the entry point for the application, handling user        //
//                   input and invoking actions within the StudentManagementSystem to manage        //
//                   student records. It also includes input validation to ensure data quality.     //
//                   The application is executed in a continuous loop, providing a user-friendly    // 
//                    way to manage student information.                                            //
 //  Author :             Gore Bharati                                                              //
//  Date :               05/10/2023                                                                 //
//  Update Date :        12/10/2023                                                             //
//////////////////////////////////////////////////////////////////////////////////////////////////


public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\u001B[36mStudent Management System\u001B[0m"); // Cyan
            System.out.println("\u001B[33m1. Add Student\u001B[0m"); // Yellow
            System.out.println("\u001B[33m2. Remove Student\u001B[0m"); // Yellow
            System.out.println("\u001B[33m3. Search for Student\u001B[0m"); // Yellow
            System.out.println("\u001B[33m4. Display All Students\u001B[0m"); // Yellow
            System.out.println("\u001B[31m5. Exit\u001B[0m"); // Red
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("\u001B[33mEnter name: \u001B[0m"); // Yellow
                    String name = scanner.nextLine();
                    System.out.print("\u001B[33mEnter roll number: \u001B[0m"); // Yellow
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("\u001B[33mEnter grade: \u001B[0m"); // Yellow
                    String grade = scanner.nextLine();

                    Student newStudent = new Student(name, rollNumber, grade);
                    sms.addStudent(newStudent);
                    System.out.println("\u001B[32mStudent added successfully.\u001B[0m"); // Green
                    break;

                case 2:
                    System.out.print("\u001B[33mEnter roll number of the student to remove: \u001B[0m"); // Yellow
                    int rollToRemove = scanner.nextInt();
                    if (sms.removeStudent(rollToRemove)) {
                        System.out.println("\u001B[32mStudent removed successfully.\u001B[0m"); // Green
                    } else {
                        System.out.println("\u001B[31mStudent not found.\u001B[0m"); // Red
                    }
                    break;

                case 3:
                    System.out.print("\u001B[33mEnter roll number of the student to search: \u001B[0m"); // Yellow
                    int rollToSearch = scanner.nextInt();
                    Student foundStudent = sms.findStudent(rollToSearch);
                    if (foundStudent != null) {
                        System.out.println("\u001B[32mStudent found: " + foundStudent + "\u001B[0m"); // Green
                    } else {
                        System.out.println("\u001B[31mStudent not found.\u001B[0m"); // Red
                    }
                    break;

                case 4:
                    ArrayList<Student> allStudents = sms.getAllStudents();
                    for (Student student : allStudents) {
                        System.out.println(student);
                    }
                    break;

                case 5:
                    System.out.println("\u001B[31mExiting the application.\u001B[0m"); // Red
                    System.exit(0);

                default:
                    System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m"); // Red
            }
        }
    }
}

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public Student findStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }
}
