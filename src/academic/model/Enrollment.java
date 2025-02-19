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