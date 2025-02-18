package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver1 {

    public static void main(String[] _args) {
        Scanner inp = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        ArrayList<String> inputLines = new ArrayList<>();

        // Read all input lines
        while (true) {
            String buffer = inp.nextLine();
            if (buffer.equals("---"))
                break;
            inputLines.add(buffer);
        }

        inp.close();

        // Process each input line
        for (String buffer : inputLines) {
            String[] data = buffer.split("#");
            if (data.length == 5) {
                String entityType = data[0];
                switch (entityType) {
                    case "course-add":
                        String courseCode = data[1];
                        String courseName = data[2];
                        int credit = Integer.parseInt(data[3]);
                        String passingGrade = data[4];
                        if (!courseExists(courses, courseCode)) {
                            courses.add(new Course(courseCode, courseName, credit, passingGrade));
                        }
                        break;
                    case "student-add":
                        String studentId = data[1];
                        String studentName = data[2];
                        int year = Integer.parseInt(data[3]);
                        String major = data[4];
                        if (!studentExists(students, studentId)) {
                            students.add(new Student(studentId, studentName, year, major));
                        }
                        break;
                    case "enrollment-add":
                        String enrollCourseCode = data[1];
                        String enrollStudentId = data[2];
                        String academicYear = data[3];
                        String semester = data[4];
                        if (courseExists(courses, enrollCourseCode) && studentExists(students, enrollStudentId)) {
                            enrollments.add(new Enrollment(enrollCourseCode, enrollStudentId, academicYear, semester));
                        }
                        break;
                }
            }
        }

        for (Course course : courses) {
            System.out.println(course);
        }

        for (Student student : students) {
            System.out.println(student);
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }

    private static boolean courseExists(ArrayList<Course> courses, String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    private static boolean studentExists(ArrayList<Student> students, String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return true;
            }
        }
        return false;
    }
}