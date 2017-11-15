/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeepayroll;

/**
 *
 * @author lehone_hope
 */
public class SalariedEmployee extends Employee{

    private double weeklySalary;
    
    //four argument constructor
    public SalariedEmployee(String fName, String lName, int month, int day, int year,
            String ssn, double salary) {
        super(fName, lName, month, day, year, ssn);
        setWeeklySalary(salary);
    }//end constructor
    
    //set weekly salary
    public void setWeeklySalary(double salary){
        if (salary >= 0)
            weeklySalary = salary;
        else
            throw new IllegalArgumentException("Weekly salary must be greater than 0");
    }//end setWeeklySalary
    
    //get weekly salary
    public double getWeeklySalary(){
        return weeklySalary;
    }//end method getWeeklySalary
    
    //calculate and get weekely earning and override abstract constructor 
    @Override
    public double earnings() {
        return getWeeklySalary();
    }//end method earning
    
    //return string representation of salriedEmployeeobject
    @Override
    public String toString(){
        return String.format("Salaried Employee : %s\n%s : %,.2fXFA",  
                super.toString(), "weeklySalary", getWeeklySalary());
    }//end toString
}
