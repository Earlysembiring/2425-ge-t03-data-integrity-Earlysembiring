package academic.model;

// import java.security.Identity;

/**
 * @author 12S2018_early
 * @author 12s23032 _ seprian
 */
public class Student { 

    private static String id;
    private static String studentName;
    private static String eduYear;
    private static String stuPrg;

    public Student( ) {
        id          = "";
        studentName = "";
        eduYear     = "";
        stuPrg      = "";
    }

    public Student( String ID, String STUDENT_NAME,
                    String EDU_YEAR, String STU_PRG ) {
        id          = ID;
        studentName = STUDENT_NAME;
        eduYear     = EDU_YEAR;
        stuPrg      = STU_PRG;
    }

    public  String getId( ) { return id; }
    // public void setId( String id ) { this.id = id;  }

    public static String getStudentName( ) { return studentName; }
    // public void setName( String studentName ) { this.studentName = studentName;  }

    public static String getEduYear( ) { return eduYear; }
    // public void setYear( String eduYear ) { this.eduYear = eduYear; }

    public static String getStuPrg( ) { return stuPrg; }
    // public void setStudyProgram( String stuPrg ) { this.stuPrg = stuPrg;  }

    public String toString( ) {
        return String.format("%s|%s|%s|%s",id,studentName,eduYear,stuPrg);
    }


}