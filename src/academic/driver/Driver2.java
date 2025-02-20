package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;

/**
 * @author 12S23018_early
 * @author 12S230132_seprian
 */

public class Driver2 {
    public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);

        Course[] courseArray = new Course[100];
        Student[] studentArray = new Student[100];
        Enrollment[] enrollmentArray = new Enrollment[100];

        int courseIndex = 0;
        int studentIndex = 0;
        int enrollmentIndex = 0;

        StringBuilder invalidEntries = new StringBuilder();

        while (true) {
            String inputLine = scanner.nextLine().trim();

            if (inputLine.equals("---")) {
                break;
            }

            String[] inputParts = inputLine.split("#");

            switch (inputParts[0]) {
                case "course-add":
                    if (inputParts.length == 5) {
                        String courseCode = inputParts[1];
                        String courseName = inputParts[2];
                        String courseCredits = inputParts[3];
                        String courseGrade = inputParts[4];
                        courseArray[courseIndex++] = new Course(courseCode, courseName, courseCredits, courseGrade);
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

                        boolean courseExists = false;
                        boolean studentExists = false;

                        for (int i = 0; i < courseIndex; i++) {
                            if (courseArray[i].getCode().equals(enrollmentCourseCode)) {
                                courseExists = true;
                                break;
                            }
                        }

                        for (int i = 0; i < studentIndex; i++) {
                            if (studentArray[i].getCode().equals(enrollmentStudentId)) {
                                studentExists = true;
                                break;
                            }
                        }

                        if (!courseExists) {
                            invalidEntries.append("invalid course|").append(enrollmentCourseCode).append("\n");
                        } else if (!studentExists) {
                            invalidEntries.append("invalid student|").append(enrollmentStudentId).append("\n");
                        } else {
                            String courseCode = inputParts[1];
                            String studentId = inputParts[2];
                            String year = inputParts[3];
                            String semester = inputParts[4];
                            String notes = "None";
                            enrollmentArray[enrollmentIndex++] = new Enrollment(courseCode, studentId, year, semester, notes);
                        }
                    }
                    break;
                default:
                    System.out.println("Error: Perintah tidak dikenali.");
            }
        }

        scanner.close();

        System.out.print(invalidEntries.toString());

        for (int i = courseIndex - 1; i >= 0; i--) {
            System.out.println(courseArray[i].toString());
        }

        for (int i = 0; i < studentIndex; i++) {
            System.out.println(studentArray[i].toString());
        }

        for (int i = 0; i < enrollmentIndex; i++) {
            System.out.println(enrollmentArray[i].toString());
        }
    }
}