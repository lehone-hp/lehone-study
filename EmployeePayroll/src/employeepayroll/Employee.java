/*
 * Class Employee 
 * absratct superclass of package employeepayroll
 * private instance variable: String firstName, LastName and SocialSecurityNumber(SSN)
 * declares abrstact method earning to be overriden by all other concrete subclass  
 * in the heirachy
 */

package employeepayroll;

/**
 *
 * @author lehone_hope
 */

//declare class as abstract
public abstract class Employee {
    private String firstName;   
    private String lastName;    
    private String socialSecurityNumber;
    private Date birthDate;
    
    //three argument constructor
    public Employee(String fName, String lName, int month, int day, int year, String ssn){
        firstName = fName;
        lastName = lName;
        socialSecurityNumber = ssn;
        birthDate = new Date(month, day, year);
    }//end constructor
    
    //set date
    public void setDate(int month, int day, int year){
        birthDate.setDate(month, day, year);
    }//end set date
    
    //get date
    public String getDate(){
        return birthDate.toString();
    }//end get date
    
    //set first Name
    public void setFirstName(String fName){
        firstName = fName;
    }//end setFirstName
    
    //get first name
    public String getFirstName(){
        return firstName;
    }//end get first name
    
    //set first Name
    public void setLastName(String lName){
        lastName = lName;
    }//end setLastName
    
    //get lastName
    public String getLastName(){
        return lastName;
    }//end get lastName
    
    //set social security number
    public void setSocialSecurityNumber(String ssn){
        socialSecurityNumber = ssn;
    }//end method setSSn
    
    //get social security number
    public String getSocialSecurityNumber(){
        return socialSecurityNumber;
    }//end getSSN
    
    //return string representation of Employee object
    @Override
    public String toString(){
        return String.format("%s %s\nSocial Security Number: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber());
    }//end toString
    
    //abstract method to be overridden by subclass
    public abstract double earnings();  //no implementation of method here
    
}
