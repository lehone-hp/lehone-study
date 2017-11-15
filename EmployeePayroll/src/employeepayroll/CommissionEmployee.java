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
public class CommissionEmployee extends Employee{
    private double grossSales;
    private double commissionRate;

    //five argument constructor
    public CommissionEmployee(String fName, String lName, int month, 
            int day, int year,  String ssn, double sales, double rate) {
        super(fName, lName, month, day, year, ssn);
        setGrossSales(sales);
        setCommissionRate(rate);
    }//end constructor

    //set gross sales
    public void setGrossSales(double sales){
        if ( sales >= 0.0 )
            grossSales = sales;
        else
            throw new IllegalArgumentException(
        "Gross sales must be >= 0.0" );
    }//end method setGrossSales
    
    //get gross sales
    public double getGrossSales(){
        return grossSales;
    }//end method getGrossSales
    
    //set commision rate
    public void setCommissionRate(double rate){
        if ( rate > 0.0 && rate < 1.0 )
            commissionRate = rate;
        else
            throw new IllegalArgumentException(
                "Commission rate must be > 0.0 and < 1.0" );
    }//end method setCommissionRate
    
    //get Commission rate
    public double getCommissionRate(){
        return commissionRate;
    }//end method getCommissionRate
    
    // calculate earnings; override abstract method earnings in Employee
    @Override
    public double earnings() {
        return getCommissionRate() * getGrossSales();
    }//end method earnings
    
    // return String representation of CommissionEmployee object
    @Override
    public String toString(){
        return String.format( "%s: %s\n%s: $%,.2f; %s: %.2f",
            "commission employee", super.toString(),
            "gross sales", getGrossSales(),
            "commission rate", getCommissionRate() );
    }//end method toString
    
}
