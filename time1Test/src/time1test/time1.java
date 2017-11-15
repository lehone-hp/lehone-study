package time1test;

/**
 * @author lehone_hope
 */
public class time1 {
    private int hour;
    private int minute;
    private int second;
    
    // set a new time value using universal time; throw an
    // exception if the hour, minute or second is invalid
    public void setTime(int h, int m, int s){
        if ( (h>=0 && h<23) && (m>=0 && m<60) && (s>=0 && s<60) ){
            hour = h;
            minute = m;
            second = s;
        } else {
            throw new IllegalArgumentException(
                    "hour, minute and/or second was out of range" );
        }
    }//end method
    
    //convert to String in unversal time format{H:M:S)
    public String toUniversalString(){
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }//end method
    
    //convert to String in Standart time format(H:M:S AM or PM)
    @Override
    public String toString(){
        return String.format("%02d:%02d:%02d %s", 
                ( (hour == 0 || hour == 24) ? 12 : hour%12),
                minute, second, (hour<12 ? "AM" : "PM") );
    }//end method toString
    
}//end class
