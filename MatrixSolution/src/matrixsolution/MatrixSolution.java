/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixsolution;
import java.util.Scanner;
/**
 *
 * @author lehone_hope
 */
public class MatrixSolution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double[][] A = null;
        double[] b = null;
        int n;
        
        System.out.printf("          Welcome to solving System of Linear equation by"
                + "direct methods\n"
                + "**********************************************************"
                + "***********************\n\n\n");
        
        //displayMenue
        System.out.printf("%10s", "1: Cramers Method\n");
        System.out.printf("%10s", "2: LU Decomposition\n");
        System.out.printf("%10s", "3: Gaussian Elimination\n");
        System.out.printf("%10s", "4: Inverse Method\n");
        System.out.printf("%5s", "5: Exit");
        System.out.print("\n\nSelect a method of choice: ");
        int option = input.nextInt();
        
        if (option >= 1 && option < 5){
            System.out.print("\nEnter order of matrix: ");
            n = input.nextInt();
            A = new double[n][n];
            b = new double[n];
            Matrix.getMatrix(A, b);
        }//end if
        
        switch(option){
            case 1:
                Matrix.cramers(A, b);
                break;
            case 2:
                Matrix.reduceMatrix(A, b);
                break;
            case 3:
                Matrix.elimination(A, b);
                break;
            case 4:
                Matrix.inverse(A, b);
                break;
            case 5:
                System.out.print("\n\nBye Bye");
                break;
            default:
                ;                
        }//end switch
        
    }//end main
    
}//end class
