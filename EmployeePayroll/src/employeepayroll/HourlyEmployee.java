
package employeepayroll;

/**
 *
 * @author lehone_hope
 */
public class HourlyEmployee extends Employee{

    private double wage;
    private double hours;
    
    //five argument constructor
    public HourlyEmployee
        (String fName, String lName, int month, int day, int year, 
                String ssn, double hourlyWage, double hoursWorked) {
            super(fName, lName, month, day, year, ssn);
            setWage(hourlyWage);
            setHours(hoursWorked);
    }//end constructor
    
    //set wage
    public void setWage(double hourlyWage){
        if (hourlyWage >= 0)
            wage = hourlyWage;
        else
            throw new IllegalArgumentException("Hourly wage must be >= 0");
    }//end method setWage    
    
    public double getWage(){
        return wage;
    }//end method getWage
    
    //set hours
    public void setHours(double hoursWorked){
        if ((hoursWorked >= 0.0) && (hoursWorked <= 168.0))
            hours = hoursWorked;
        else
            throw new IllegalArgumentException("Hours worked must be >= 0 and <= 168");
    }//end method setHours
    
    //get hours worked
    public double getHours(){
        return hours;
    }//end method getHours

    //calculate hourlyEmployee's earnings and override abstract earnings method
    @Override
    public double earnings() {
        if (getHours() < 40)
            return getWage() * getHours();
        else
            return 40 * getWage() + ( getHours() - 40 ) * getWage() * 1.5;
    }//end method earning
    
    //return string representation of object
    @Override
    public String toString(){
        return String.format("Hourly Employee : %s\n%s : %,.2f", 
                super.toString(), "Hourly Wage", getWage());
    }//end method toString
}
