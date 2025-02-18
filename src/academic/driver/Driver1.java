package academic.driver;

/**
 * @author 12s23018 Early
 * @author 12S23032 seprian
 */


import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        // Read courses
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;

            String[] data = line.split("#");
            if (data[0].equals("course-add")) {
                courses.add(new Course(data[1], data[2], Integer.parseInt(data[3]), data[4]));
            }
        }

        // Read students
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;

            String[] data = line.split("#");
            if (data[0].equals("student-add")) {
                students.add(new Student(data[1], data[2], Integer.parseInt(data[3]), data[4]));
            }
        }

        // Read enrollments
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;

            String[] data = line.split("#");
            if (data[0].equals("enrollment-add")) {
                Course course = courses.stream()
                    .filter(c -> c.getCourseId().equals(data[1]))
                    .findFirst()
                    .orElse(null);

                Student student = students.stream()
                    .filter(s -> s.getStudentId().equals(data[2]))
                    .findFirst()
                    .orElse(null);

                if (course != null && student != null) {
                    enrollments.add(new Enrollment(course, student, data[3], data[4]));
                }
            }
        }

        // Print courses
        for (Course course : courses) {
            System.out.println(course);
        }

        // Print students
        for (Student student : students) {
            System.out.println(student);
        }

        // Print enrollments
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }
}