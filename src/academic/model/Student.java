package academic.model;

public class Student {
    private String id;
    private String studentName;
    private String eduYear;
    private String stuPrg;

    public Student() {
        this.id = "";
        this.studentName = "";
        this.eduYear = "";
        this.stuPrg = "";
    }

    public Student(String id, String studentName, String eduYear, String stuPrg) {
        this.id = id;
        this.studentName = studentName;
        this.eduYear = eduYear;
        this.stuPrg = stuPrg;
    }

    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEduYear() {
        return eduYear;
    }

    public String getStuPrg() {
        return stuPrg;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s", id, studentName, eduYear, stuPrg);
    }
}