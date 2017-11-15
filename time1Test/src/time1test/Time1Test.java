
package time1test;

/**
 * @author lehone_hope
 */
public class Time1Test {

    public static void main(String[] args) {
        //set and initialise a Time1 constructor
        time1 time = new time1();
        
        //time.hour = 9;
        
        // output string representations of the time
        System.out.print( "The initial universal time is: " );
        System.out.println( time.toUniversalString() );
        System.out.print( "The initial standard time is: " );
        System.out.println( time.toString() );
        System.out.println(); // output a blank line
        
        // change time and output updated time
        time.setTime( 13, 27, 6 );
        System.out.print( "Universal time after setTime is: " );
        System.out.println( time.toUniversalString() );
        System.out.print( "Standard time after setTime is: " );
        System.out.println( time.toString() );
        System.out.println(); // output a blank line
        
        //attempt to set time with invalid values
        try{
            time.setTime(99, 99, 99);
        } catch ( IllegalArgumentException e){
            System.out.printf("Exception: %s\n\n", e.getMessage());
        }
        
        // display time after attempt to set invalid values
        System.out.println( "After attempting invalid settings:" );
        System.out.print( "Universal time: " );
        System.out.println( time.toUniversalString() );
        System.out.print( "Standard time: " );
        System.out.println( time.toString() );
    }//end main method
}//end Class
