/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payableheirachy;

/**
 *
 * @author lehone_hope
 */
public class SalariedEmployee extends Employee{

    private double weeklySalary;
    
    // four-argument constructor
    public SalariedEmployee( String first, String last, String ssn,
        double salary )
    {
        super( first, last, ssn ); // pass to Employee constructor
        setWeeklySalary( salary ); // validate and store salary
    } // end four-argument SalariedEmployee constructor
    
    // set salary
    public void setWeeklySalary( double salary )
    {
        if ( salary >= 0.0 )
            weeklySalary = salary;
        else
            throw new IllegalArgumentException("Weekly salary must be >= 0.0" );
    } // end method setWeeklySalary
    
    // return salary
    public double getWeeklySalary()
    {
        return weeklySalary;
    } // end method getWeeklySalary
    
    // calculate earnings; implement interface Payable method that was
    // abstract in superclass Employee
    @Override
    public double getPaymentAmount()
    {
        return getWeeklySalary();
    } // end method getPaymentAmount
    
    // return String representation of SalariedEmployee object
    @Override
    public String toString()
    {
        return String.format( "salaried employee: %s\n%s: $%,.2f",
            super.toString(), "weekly salary", getWeeklySalary() );
    } // end method toString
}
