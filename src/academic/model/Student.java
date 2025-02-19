package academic.model;

public class Student {
    private String studentId;
    private String studentName;
    private int year;
    private String major;

    public Student(String studentId, String studentName, int year, String major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.year = year;
        this.major = major;
    }

    // Necessary accessors
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }

    // No mutators needed as student details should not change once created

    @Override
    public String toString() {
        return studentId + "|" + studentName + "|" + year + "|" + major;
    }
}

enrollment
package academic.model;

public class Enrollment {
    private Course course;
    private Student student;
    private String academicYear;
    private String semester;

    public Enrollment(Course course, Student student, String academicYear, String semester) {
        if (course == null) {
            throw new IllegalArgumentException("Invalid course");
        }
        if (student == null) {
            throw new IllegalArgumentException("Invalid student");
        }
        this.course = course;
        this.student = student;
        this.academicYear = academicYear;
        this.semester = semester;
    }

    // Necessary accessors
    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return course.getCourseId() + "|" + student.getStudentId() + "|" + academicYear + "|" + semester + "|None";
    }
} 
