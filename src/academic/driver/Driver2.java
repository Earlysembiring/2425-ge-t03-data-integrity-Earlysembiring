package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create maps to store courses and students
        Map<String, Course> courses = new HashMap<>();
        Map<String, Student> students = new HashMap<>();
        List<Enrollment> enrollments = new ArrayList<>();

        // Read input lines
        List<String> inputLines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;
            inputLines.add(line);
        }

        // Process each input line
        for (String line : inputLines) {
            String[] data = line.split("#");
            switch (data[0]) {
                case "course-add":
                    courses.put(data[1], new Course(data[1], data[2], Integer.parseInt(data[3]), data[4]));
                    break;
                case "student-add":
                    students.put(data[1], new Student(data[1], data[2], Integer.parseInt(data[3]), data[4]));
                    break;
                case "enrollment-add":
                    addEnrollment(courses, students, enrollments, data[1], data[2], data[3], data[4]);
                    break;
            }
        }
        scanner.close();

        // Print courses
        for (Course course : courses.values()) {
            System.out.println(course);
        }

        // Print students
        for (Student student : students.values()) {
            System.out.println(student);
        }

        // Print enrollments
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }

    private static void addEnrollment(Map<String, Course> courses, Map<String, Student> students, List<Enrollment> enrollments, String courseId, String studentId, String academicYear, String semester) {
        Course course = courses.get(courseId);
        Student student = students.get(studentId);

        if (course == null) {
            System.out.println("invalid course|" + courseId);
        } else if (student == null) {
            System.out.println("invalid student|" + studentId);
        } else {
            Enrollment enrollment = new Enrollment(course, student, academicYear, semester);
            enrollments.add(enrollment);
        }
    }
}