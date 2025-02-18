package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator; // Tambahkan impor ini

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
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
                    courses.add(new Course(data[1], data[2], Integer.parseInt(data[3]), data[4]));
                    break;
                case "student-add":
                    students.add(new Student(data[1], data[2], Integer.parseInt(data[3]), data[4]));
                    break;
                case "enrollment-add":
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
                    break;
            }
        }
        scanner.close();

        // Sort courses and enrollments
        courses.sort(Comparator.comparing(Course::getCourseId));
        enrollments.sort(Comparator.comparing(enrollment -> enrollment.getCourse().getCourseId()));

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