/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package determinant;

import static java.lang.Math.pow;

/**
 * @author lehone_hope
 */
public class Determinant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    
                double[][] A = { {1, 4, 3},
                                 {6, 5, 4},
                                 {9, 7, 8}};
                double[] b = {2, 1, 0, 3};       
        System.out.printf(" %5.2f", det(A));
    }//end main
    
    static int I = -1;
    public static double det(double A[][]){
        if (A.length == 2)
            return det2x2(A);
        else{
            double sum = 0;
            for (int j=0; j<A.length; j++)
                sum += pow(-1, j+2) * A[I+1][j] * det(minor(I+1, j, A));
            return sum;
        }//end if else   
    }//end method det
    
    /**
     * @param A matrix of order 2
     * @return the determinant of a 2x2 matrix
     */
    private static double det2x2(double A[][]){
        return (A[1][1]*A[0][0]) - (A[0][1]*A[1][0]);
    }//end method det2x2

    /**
     * Method minor functions is returning the minor of a given 
     * matrix at a given index, (i,j)
     * @param indexI, the i index 
     * @param indexJ, the j index
     * @param B
     * @return returns the minor matrix of Aij
     */
 
    public static double[][] minor( int indexI, int indexJ, double B[][]){
        //holds the minor of the index ij
        double[][] minor = new double[B.length-1][B.length-1];
        
        /* i = row index and 
           j = column index*/
        for(int i=0; i<B.length; i++){//access the rows of B
            //if we are in row indexI, go to next column iteration
            if (i == indexI)
                continue;
            for (int j=0; j<B.length; j++){ //access the columns of B
                //if on column indexJ, go to next row iteration 
                if(j == indexJ)
                    continue;
                //assign to the minor matrix its respective values
                if (i>indexI){
                    //when the row index in B is larger than the row to be eliminatd
                    if (j>indexJ)
                        minor[i-1][j-1] = B[i][j];
                    if (j<indexJ)
                        minor[i-1][j] = B[i][j];
                }else{
                    if (i<indexI){
                        if (j>indexJ)
                            minor[i][j-1] = B[i][j];
                        if (j<indexJ)
                            minor[i][j] = B[i][j];
                    }
                }//end if...else..statement
            }//end for, for the column counter
        }//end of for, for the row counter        
        
        return minor;   //returns the minor of Aij
    }//end method minor
    
    public static double[][] replace(double[] b, double A[][], int column){
        //create a matrix to hold A temporarily to pass it by value
        double[][] temp = new double[A.length][A.length];
        
        //initialisation phase
        for (int i=0; i<temp.length; i++)
            for (int j=0; j<temp.length; j++)
                temp[i][j] = A[i][j];
        
        for (int row=0; row<temp.length; row++)
            temp[row][column] = b[row];
        
        return temp;
    }//end method
    
    public static void displayMatrix(double A[][]){
            
        for (double[] A1 : A) {
            for (int column = 0; column<A.length; column++) {
                System.out.printf("%5.1f   ", A1[column]);
            }
            System.out.printf("\n");
        } //end outer for
    }//end displayMatrix for double matrics/
         
}//end class
