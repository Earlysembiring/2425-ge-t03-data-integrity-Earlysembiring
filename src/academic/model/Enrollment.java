package academic.model;

public class Enrollment {
    private String code;
    private String id;
    private String period;
    private String semester;

    public Enrollment() {
        this.code = "";
        this.id = "";
        this.period = "";
        this.semester = "";
    }

    public Enrollment(String code, String id, String period, String semester) {
        this.code = code;
        this.id = id;
        this.period = period;
        this.semester = semester;
    }

    public String getCode() {
        return code;
    }

    public String getId() {
        return id;
    }

    public String getPeriod() {
        return period;
    }

    public String getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|None", code, id, period, semester);
    }
}