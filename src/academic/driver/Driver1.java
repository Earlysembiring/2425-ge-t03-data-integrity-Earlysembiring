
package academic.driver;

import java.util.Arrays;
import java.util.Scanner;
import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;


/**
 * @author 12S2018_early
 * @author 12s23032 _ seprian
 */


public class Driver1 {

    static final String SEPARATOR = "#";
    static Course[] matkul = new Course[0];
    static Student[] siswa = new Student[0];
    static Enrollment[] enrol = new Enrollment[0];

    public static void main(String[] _args) {
        Scanner inp = new Scanner(System.in);
        String inputan = null;

        while(2 > 1) {
            inputan = inp.nextLine();
            if (inputan.equals("---")) { break; }

            String[] container = inputan.split(SEPARATOR);
            String order = container[0];
            // while (2 > 1) {
            //     // String temp = matkul[i].getCode();
            //     if (Course.getCode().equals(container[1]))          { break; }
            //     else if (Student.getId().equals(container[1]))      { break; }
            //     else if (Enrollment.getCode().equals(container[1])) { break; }
            // }

            // for (Course temp: matkul) {
            //     if (temp.getCode().equals(container[1])) { break; }
            // }
            // for (Student temp: siswa) {
            //     if (temp.getId().equals(container[1])) { break; }
            // }
            // for (Enrollment temp: enrol) {
            //     if (temp.getCode().equals(container[1])) { break; }
            // }
            
            container = Arrays.copyOfRange(container, 1, container.length);
            switch (order) {
                case "course-add":
                    Course temp = dupCourse(container[0]);
                    if (temp==null) {
                        Course newCourse = arrayToCourse(container);
                        addCourse(newCourse);
                        break;
                    }
                    else {
                        break;
                    }
                case "student-add":
                    Student newStudent = arrayToStudent(container);
                    addStudent(newStudent);
                    break;
                case "enrollment-add":
                    Enrollment newEnrollment = arrayToEnrollment(container);
                    addEnrollment(newEnrollment);
                    break;
            }
        }
        printAll();

        inp.close();
    }

    private static void printAll() {
        printAllCourses();
        printAllStudents();
        printAllEnrollments();
    }

    public static Course dupCourse(String CODE){
        for (Course temp : matkul){
            if (temp.getCode().equals(CODE)){
                return temp;
            }
        }
        return null;
    }
    
    
    private static void printAllCourses() {
        for (Course course : matkul) {
            System.out.println(course);
        }
    }

    private static void addCourse(Course course) {
        // for (Course temp: matkul) {
        //     if (temp.getCode().equals(course.getCode())) {
        //         System.out.println("invalid course|" + course.getCode());
        //         break;
        //     }
        //     else {
        //         matkul = Arrays.copyOf(matkul, matkul.length + 1);
        //         matkul[matkul.length - 1] = course;
        //     }
        // }
        
        matkul = Arrays.copyOf(matkul, matkul.length + 1);
        matkul[matkul.length - 1] = course;
    }

    private static Course arrayToCourse(String[] container) {
        Course course = new Course(
                container[0],
                container[1],
                container[2],
                container[3]);

        return course;
    }

    // Students
    private static void printAllStudents() {
        for (Student i : siswa) {
            System.out.println(i);
        }
    }

    private static void addStudent(Student student) {
        siswa = Arrays.copyOf(siswa, siswa.length + 1);
        siswa[siswa.length - 1] = student;
    }

    private static Student arrayToStudent(String[] container) {
        Student student = new Student(
                container[0],
                container[1],
                container[2],
                container[3]);

        return student;
    }

    // Enrollment
    private static void printAllEnrollments() {
        for (Enrollment i : enrol) {
            System.out.println(i);
        }
    }

    private static void addEnrollment(Enrollment enrollment) {
        enrol = Arrays.copyOf(enrol, enrol.length + 1);
        enrol[enrol.length - 1] = enrollment;
    }

    private static Enrollment arrayToEnrollment(String[] container) {
        Enrollment enrollment = new Enrollment(
                container[0],
                container[1],
                container[2],
                container[3]);

        return enrollment;
    }
}