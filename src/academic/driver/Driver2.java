package academic.driver;

/**
 * @author 12S23018_Early sembiring
 * @author 12S230132_Seprian siagian
 */


import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Driver2 {
    public static void main(String[] args) {
        // Create maps to store courses and students
        Map<String, Course> courses = new HashMap<>();
        Map<String, Student> students = new HashMap<>();
        List<Enrollment> enrollments = new ArrayList<>();

        // Add courses
        courses.put("12S2203", new Course("12S2203", "Object-oriented Programming", 3, "C"));
        courses.put("10S1002", new Course("10S1002", "Pemrograman Prosedural", 2, "D"));

        // Add students
        students.put("12S20999", new Student("12S20999", "Wiro Sableng", 2020, "Information Systems"));
        students.put("12S20111", new Student("12S20111", "Jaka Sembung", 2019, "Information Systems"));

        // Add enrollments with exception handling
        addEnrollment(courses, students, enrollments, "12S2203", "12S20999", "2021/2022", "even");
        addEnrollment(courses, students, enrollments, "12S2203", "12S20000", "2020/2021", "even");
        addEnrollment(courses, students, enrollments, "12S2200", "12S20000", "2020/2021", "odd");

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