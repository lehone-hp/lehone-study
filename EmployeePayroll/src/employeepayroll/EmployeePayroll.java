//driver class
package employeepayroll;
import java.util.*;
        
public class EmployeePayroll {

    public static void main(String[] args) {
        
        // create subclass objects
        SalariedEmployee salariedEmployee =
            new SalariedEmployee( "John", "Smith",  4, 12, 1993, "111-11-1111", 800.00 );
        
        HourlyEmployee hourlyEmployee =
            new HourlyEmployee( "Karen", "Price", 10, 27, 1990, "222-22-2222", 16.75, 40 );
        
        CommissionEmployee commissionEmployee =
            new CommissionEmployee("Sue", "Jones", 7, 11, 1982, "333-33-3333", 10000, .06 );
        
        BasePlusCommissionEmployee basePlusCommissionEmployee =
            new BasePlusCommissionEmployee(
                    "Bob", "Lewis", 9, 3, 1991, "444-44-4444", 5000, .04, 300 );
        
        System.out.println( "Employees processed individually:\n" );
        
        
        System.out.printf( "%s\n%s: $%,.2f\n\n",
            salariedEmployee, "earned", salariedEmployee.earnings() );
        System.out.printf( "%s\n%s: $%,.2f\n\n",
            hourlyEmployee, "earned", hourlyEmployee.earnings() );
        System.out.printf( "%s\n%s: $%,.2f\n\n",
            commissionEmployee, "earned", commissionEmployee.earnings() );
        System.out.printf( "%s\n%s: $%,.2f\n\n",
            basePlusCommissionEmployee,
            "earned", basePlusCommissionEmployee.earnings() );
        
        //create four-element Empolyee array
        Employee[] employees = new Employee[4];
        
        //initialise array with the respective employees intantiated above
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
                
        //employees processes polymorpically
        for (Employee currentEmployee : employees){
            System.out.println(currentEmployee);    //invoke toString
            
            // determine whether element is a BasePlusCommissionEmployee
            if ( currentEmployee instanceof BasePlusCommissionEmployee )
            {
                // downcast Employee reference to
                // BasePlusCommissionEmployee reference
                BasePlusCommissionEmployee employee =
                    ( BasePlusCommissionEmployee ) currentEmployee ;
                
                employee.setBaseSalary( 1.10 * employee.getBaseSalary() );
                
                System.out.printf(
                    "new base salary with 10%% increase is: $%,.2f\n",
                    employee.getBaseSalary() );
            } // end if
            
            System.out.printf(
                "earned $%,.2f\n\n", currentEmployee.earnings() );
        }//end enhanced for
        
        // get type name of each object in employees array
        for ( int j = 0; j < employees.length; j++ )
            System.out.printf( "Employee %d is a %s\n", j+1,
                employees[ j ].getClass().getName());
        
    }//end main
}//end driver class EmployeePayroll