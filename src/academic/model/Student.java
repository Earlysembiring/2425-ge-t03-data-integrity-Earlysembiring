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