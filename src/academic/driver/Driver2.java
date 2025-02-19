package academic.driver;
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.*;

/**
 * @author 12S2018_early
 * @author 12s23032 _ seprian
 */
 
public class Driver2
{
    public static void main( String[ ] _args ) {

        try ( Scanner inp = new Scanner( System.in ) )
        {
            ArrayList < Student    > siswa  = new ArrayList<>( );
            ArrayList < Course     > matkul = new ArrayList<>( );
            ArrayList < Enrollment > enrol  = new ArrayList<>( );
            ArrayList < String     > notif  = new ArrayList<>( );
            String line;
            String[ ] buff=null;
            boolean cStu=false, cMat=false;

            while ( !( line = inp.nextLine( ) ).equals("---") )
            {
                buff = line.split( "#" );

                if ( buff[0].equals( "course-add" ) )
                {
                    Student siswaNew = new Student(
                                                    buff[1],
                                                    buff[2],
                                                    buff[3],
                                                    buff[4]
                                                     );
                    siswa.add( siswaNew );
                }

                else if ( buff[0].equals( "course-add" ) )
                {
                    Course matkulNew = new Course (
                                                    buff[1],
                                                    buff[2],
                                                    buff[3],
                                                    buff[4]
                                                     );
                    matkul.add( matkulNew );
                }

                else if ( buff[0].equals( "enrollment-add" ) )
                {
                    try {
                        
                        for ( int temp=0 ; temp<siswa.size( ); ) {
                            if ( siswa.get( temp ).getId( ).equals( buff[2] ) ) {
                                cStu = true; break;
                            }
                            else {
                                throw new Exception( "invalid student|" + buff[2] );
                            }
                        }
                        
                        for ( int temp=0;  temp<matkul.size( ); ) {
                            if ( matkul.get( temp ).getCode( ).equals( buff[1] ) ) {
                                cMat = true; break;
                            }
                            else {
                                throw new Exception( "invalid course|" + buff[1] );
                            }
                        }

                        if ( cMat && cStu ) {
                            Enrollment temp = new Enrollment( buff[1],
                                                              buff[2],
                                                              buff[3],
                                                              buff[4]
                                                               );
                            enrol.add( temp );
                        }
                    }

                    catch( Exception _err ) { notif.add( _err.getMessage( ) ); }
                }
            }

            // stdout
            for ( String message : notif )
                { System.out.println( message ); }

            for ( int i= siswa.size()-1; i>=0; i-- )
                { System.out.println( siswa.get( i ).toString( ) ); }

            for ( int i= matkul.size()-1; i>=0; i-- )
                { System.out.println( matkul.get( i ).toString( ) ); }
            
            for ( Enrollment temp : enrol )
                { System.out.println( temp.toString( ) ); }
            
        }

    }

}