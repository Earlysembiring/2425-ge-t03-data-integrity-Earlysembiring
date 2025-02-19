package academic.model;

public class Course {
    private String code;
    private String courseName;
    private int credit;
    private String passingGrade;

    public Course() {
        this.code = "";
        this.courseName = "";
        this.credit = 0;
        this.passingGrade = "";
    }

    public Course(String code, String courseName, String credit, String passingGrade) {
        this.code = code;
        this.courseName = courseName;
        this.credit = Integer.parseInt(credit);
        this.passingGrade = passingGrade;
    }

    public String getCode() {
        return code;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredit() {
        return credit;
    }

    public String getPassingGrade() {
        return passingGrade;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%d|%s", code, courseName, credit, passingGrade);
    }
} 