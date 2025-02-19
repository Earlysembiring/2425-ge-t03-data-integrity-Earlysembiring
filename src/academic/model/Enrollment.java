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

course
package academic.model;

public class Course {
    private String courseId;
    private String courseName;
    private int credits;
    private String grade;

    public Course(String courseId, String courseName, int credits, String grade) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.grade = grade;
    }

    // Necessary accessors
    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    // No mutators needed as course details should not change once created

    @Override
    public String toString() {
        return courseId + "|" + courseName + "|" + credits + "|" + grade;
    }
}
