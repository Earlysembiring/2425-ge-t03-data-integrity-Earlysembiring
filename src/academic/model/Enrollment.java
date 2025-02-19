package academic.model;


/**
 * @author 12S2018_early
 * @author 12s23032 _ seprian
 */

public class Enrollment {

    private static String code;
    private static String id;
    private static String period;
    private static String semester;
    // private String grade;

    public Enrollment( ) {
        code        = "";
        id          = "";
        period      = "";
        semester    = "";
        // grade       = "None";
    }

    public Enrollment(  String CODE, String ID,
                        String PERIOD, String SEMESTER ) {
        code        = CODE;
        id          = ID;
        period      = PERIOD;
        semester    = SEMESTER;
    }

    public  String getCode( ) { return code; }
    // public void setCode( String code ) { this.code = code; }

    public static String getId( ) { return id; }
    // public void setId( String id ) { this.id = id; }

    public static String getPeriod( ) { return period; }
    // public void setPeriod( String period ) { this.period = period; }

    public static String getSemester( ) { return semester; }
    // public void setSemester( String semester ) { this.semester = semester; }

    public String toString( ) {
        return String.format("%s|%s|%s|%s|None",code,id,period,semester);
    }


}