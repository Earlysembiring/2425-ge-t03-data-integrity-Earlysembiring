package academic.model;


/**
 * @author 12S2018_early
 * @author 12s23032 _ seprian
 */

public class Course {

    private static String code;
    private static String courseName;
    private static int    credit;
    private static String passingGrade;

    public Course( ) {
        code        = "";
        courseName  = "";
        credit      = 0;
        passingGrade= "";
    }

    public Course( String CODE, String COURSE_NAME,
                   String CREDIT, String PASSING_GRADE ) {
        code         = CODE;
        courseName   = COURSE_NAME;
        credit       = Integer.parseInt(CREDIT);
        passingGrade = PASSING_GRADE;
    }

    public String getCode( ) { return code; }
    // public void setCode( String code ) { this.code = code; }

    public static String getCourseName( ) { return courseName; }
    // public void setCourseName( String courseName ) { this.courseName = courseName; }

    public static int getCredit( ) { return credit; }
    // public void setCredit( int credit ) { this.credit = credit; }

    public static String getPassingGrade( ) { return passingGrade; }
    // public void setPassingGrade( String passingGrade ) { this.passingGrade = passingGrade; }

    public String toString( ) {
        return String.format("%s|%s|%d|%s",code,courseName,credit,passingGrade);
        // return this.code + "|" + this.courseName + "|" + this.credit + "|" + this.passingGrade;
    }

    

}