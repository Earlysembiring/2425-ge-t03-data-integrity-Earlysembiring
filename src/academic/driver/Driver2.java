package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        List<Course> matkul = new ArrayList<>();
        List<Student> siswa = new ArrayList<>();
        List<Enrollment> enrol = new ArrayList<>();
        List<String> notif = new ArrayList<>();

        // Read input lines
        List<String> inputLines = new ArrayList<>();
        while (inp.hasNextLine()) {
            String line = inp.nextLine();
            if (line.equals("---")) break;
            inputLines.add(line);
        }

        // Process each input line
        for (String line : inputLines) {
            String[] buff = line.split("#");
            switch (buff[0]) {
                case "course-add":
                    matkul.add(new Course(buff[1], buff[2], buff[3], buff[4]));
                    break;
                case "student-add":
                    siswa.add(new Student(buff[1], buff[2], buff[3], buff[4]));
                    break;
                case "enrollment-add":
                    addEnrollment(matkul, siswa, enrol, notif, buff[1], buff[2], buff[3], buff[4]);
                    break;
            }
        }
        inp.close();

        // Print errors
        for (String error : notif) {
            System.out.println(error);
        }

        // Print courses
        for (Course course : matkul) {
            System.out.println(course);
        }

        // Print students
        for (Student student : siswa) {
            System.out.println(student);
        }

        // Print enrollments
        for (Enrollment enrollment : enrol) {
            System.out.println(enrollment);
        }
    }

    private static void addEnrollment(List<Course> matkul, List<Student> siswa, List<Enrollment> enrol, List<String> notif, String courseId, String studentId, String academicYear, String semester) {
        boolean courseExists = matkul.stream().anyMatch(course -> course.getCode().equals(courseId));
        if (!courseExists) {
            notif.add("invalid course|" + courseId);
            return;
        }

        boolean studentExists = siswa.stream().anyMatch(student -> student.getId().equals(studentId));
        if (!studentExists) {
            notif.add("invalid student|" + studentId);
            return;
        }

        enrol.add(new Enrollment(courseId, studentId, academicYear, semester));
    }
}