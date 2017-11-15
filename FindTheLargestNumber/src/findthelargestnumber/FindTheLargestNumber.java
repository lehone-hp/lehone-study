//prints the largest amongst 10 read numbers

package findthelargestnumber;
import java.util.Scanner;

public class FindTheLargestNumber {


    public static void main(String[] args) {
        // create scanner object
        Scanner input = new Scanner( System.in );
        
        //initialisation
        int counter = 1;    //counts how many numbers have been entered to ensure only 10 have been
        int number;
        int secondLargest;
        
        //processing phase
        //read first number
        System.out.print( "Enter first number: " ); //prompt
        int largest = input.nextInt();  //set first number to largest
        System.out.print("Enter next number");
        secondLargest = input.nextInt();
        
        if ( secondLargest > largest){
            number = largest;
            largest = secondLargest;
            secondLargest = number;
        }
        
        while ( counter < 9 )
        {
            System.out.print("Enter next number: ");
            number = input.nextInt();
            
            if ( number > largest ){
                secondLargest = largest;
                largest = number;
            }
            
            ++counter;  //counts up to 10
        }
        
        System.out.println("\nThe largest numbers are :" +largest+ " and :" +secondLargest);
    }
    
}
