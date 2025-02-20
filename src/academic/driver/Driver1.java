package academic.driver;

import java.util.Scanner;
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
/**
 * @author 12S23018_early
 * @author 12S230132_seprian
 */

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Course[] courseArray = new Course[100];
        Student[] studentArray = new Student[100];
        Enrollment[] enrollmentArray = new Enrollment[100];
        int courseIndex = 0;
        int studentIndex = 0;
        int enrollmentIndex = 0;

        while (true) {
            String inputLine = scanner.nextLine();
            if (inputLine.equals("---")) {
                break;
            }

            String[] inputParts = inputLine.split("#");
            if (inputParts.length > 0) {
                String command = inputParts[0];
                switch (command) {
                    case "course-add":
                        if (inputParts.length == 5) {
                            String courseCode = inputParts[1];
                            String courseName = inputParts[2];
                            String courseCredits = inputParts[3];
                            String coursePassingGrade = inputParts[4];
                            courseArray[courseIndex++] = new Course(courseCode, courseName, courseCredits, coursePassingGrade);
                        }
                        break;
                    case "student-add":
                        if (inputParts.length == 5) {
                            String studentId = inputParts[1];
                            String studentName = inputParts[2];
                            String studentYear = inputParts[3];
                            String studentMajor = inputParts[4];
                            studentArray[studentIndex++] = new Student(studentId, studentName, studentYear, studentMajor);
                        }
                        break;
                    case "enrollment-add":
                        if (inputParts.length == 5) {
                            String enrollmentCourseCode = inputParts[1];
                            String enrollmentStudentId = inputParts[2];
                            String enrollmentYear = inputParts[3];
                            String enrollmentSemester = inputParts[4];
                            String enrollmentNotes = "None";
                            enrollmentArray[enrollmentIndex++] = new Enrollment(enrollmentCourseCode, enrollmentStudentId, enrollmentYear, enrollmentSemester, enrollmentNotes);
                        }
                        break;
                }
            }
        }
        scanner.close();

        for (int i = courseIndex - 1; i >= 0; i--) {
            System.out.println(courseArray[i]);
        }

        for (int i = 0; i < studentIndex; i++) {
            System.out.println(studentArray[i]);
        }

        for (int i = 0; i < enrollmentIndex; i++) {
            System.out.println(enrollmentArray[i]);
        }
    }
}