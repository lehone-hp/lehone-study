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
public class BasePlusCommissionEmployee extends CommissionEmployee{
    
    private double baseSalary;
    
    //six parameter constructor
    public BasePlusCommissionEmployee
        (String fName, String lName, int month, int day, int year, 
                String ssn, double sales, double rate, double salary) {
            super(fName, lName, month, day, year, ssn, sales, rate);
            setBaseSalary(salary);  //validate and store baseSalary
    }//end constructor

    //set base salary    
    public void setBaseSalary(double salary) {
        if (salary >= 0)
            baseSalary = salary;
        else
            throw new IllegalArgumentException("Base salary must be >= 0");
    }//end method setBaseSalary
    
    public double getBaseSalary(){
        return baseSalary;
    }//end method getBaseSalary
        
    //calculate earning; Override method from CommissionEmployee class
    @Override
    public double earnings(){
        return super.earnings() + getBaseSalary();
    }//end method earnings
    
    //return string representation of object
    @Override
    public String toString(){
        return String.format("%s %s; %s: $%,.2f",
            "base-salaried", super.toString(),
            "base salary", getBaseSalary());
    }//end method toString
}//end class BasePlusCommissionEmployee
