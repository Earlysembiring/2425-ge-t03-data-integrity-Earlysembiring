package academic.driver;


/**
 * @author 12S23018_Early sembiring
 * @author 12S230132_Seprian siagian
 */

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

public class Driver1 {
    public static void main(String[] args) {
        // Add courses
        Course course1 = new Course("12S2203", "Object-oriented Programming", 3, "C");
        Course course2 = new Course("10S1002", "Pemrograman Prosedural", 2, "D");

        // Add students
        Student student1 = new Student("12S20999", "Wiro Sableng", 2020, "Information Systems");
        Student student2 = new Student("12S20111", "Jaka Sembung", 2019, "Information Systems");

        // Add enrollments
        Enrollment enrollment1 = new Enrollment(course1, student1, "2021/2022", "even");
        Enrollment enrollment2 = new Enrollment(course1, student2, "2020/2021", "even");

        // Print enrollments
        System.out.println(enrollment1);
        System.out.println(enrollment2);

        // Ensure no duplicate data
        // Implement logic to check for duplicates and handle accordingly
    }
}