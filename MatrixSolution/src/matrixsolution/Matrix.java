package matrixsolution;

import static java.lang.Math.pow;
import java.util.Scanner;

public class Matrix {
    
    //read values for matrix and column vector from command line
    public static void getMatrix(double[][] A, double[] b){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter Matrix: ");
        for (double[] A1 : A) {
            for (int j = 0; j<A.length; j++) {
                A1[j] = input.nextDouble();
            }
        }
        
        System.out.print("Enter vector b: ");
        for (int i=0; i<b.length; i++)
            b[i] = input.nextDouble();
            
    }//end mathod

    /**
     * displayMatrix, displays the matrix in the parameter list
     * @param A, matrix to be displayed
     */
    public static void displayMatrix(double A[][]){
            
        for (double[] A1 : A) {
            for (int column = 0; column<A.length; column++) {
                System.out.printf("%8.2f   ", A1[column]);
            }
            System.out.printf("\n");
        } //end outer for
    }//end displayMatrix for double matrics/
    
    /**
     * displayMatrix, displays the matrix in the parameter list
     * @param A, matrix to be displayed
     */
    private static void displayAug(double A[][]){
        for (double[] A1 : A) {
            for (int column = 0; column<A.length+1; column++) {
                System.out.printf("%5.1f  ", A1[column]);
            }
            System.out.printf("\n");
        } //end outer for
    }//end displayMatrix for double matrics/
    
    /**
     * Method minor functions is returning the minor of a given 
     * matrix at a given index, (i,j)
     * @param indexI, the i index 
     * @param indexJ, the j index
     * @param B
     * @return returns the minor matrix of Aij
     */
 
    private static double[][] minor( int indexI, int indexJ, double B[][]){
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

    /**
     *method multiplyColumn
     * @param A, is the matrix whose row-I is to be multiplied by column-J of B
     * @param rowI, is the row of matrix A which is to be multiplied
     * @param B, matrix whose column J is to be multiplied
     * @param columnJ, represent the index of column J of Matrix B
     * @return product of rowI of A and column J of B 
     */
    private static double multiplyRowColumn
        (double A[][], int rowI, double B[][], int columnJ ){   //param list
            double sum = 0; //holds the SOP
            
            for( int i=0; i<A.length; i++)
                sum += (A[rowI][i] * B[i][columnJ]);
        return sum;
    }//end multiply Method multiplyRowColumn
    
    /**
     * method is to multiply nxn matrices A and B.
     * we pass matrix A and B by value and not reference
     * @param A, matrix a of order n
     * @param B, matrix B of order n
     * @return the product of A and B, an nxn matrix of order n
     * calls method multiplyRowColumn
     */    
    public static double[][] multiplyMatrices(double A[][], double B[][]){
        //store the product on matrix C or order A.length(=B.length)
        double[][] C = new double [A.length][B.length];
        
        for (int row=0; row<C.length; row++)    //access the rows of C
            for (int column=0; column<C.length; column++)   //access the columns
                C[row][column] = multiplyRowColumn(A, row, B, column);
        
        return C;
    }//end method multiplyMatrices
    
    /**
     * method multiplies row-I of a matrix by a vector b, order A.length
     * @param A, nxn matrix
     * @param rowI, row of matrix A to be multiplied with vector
     * @param b, vector b
     * @return  the product of the multiplication
     */
    private static double multiplyRowVector(double A[][], int rowI, double b[]){
        //variable holds the multiple
        double x = 0;
        
        for (int column=0; column<b.length; column++)
            x += (A[rowI][column] * b[column]);
        
        return x;
    }//end method
    
    public static double[] multiplyMatrixVector(double A[][], double b[]){
        //create a new vector of order b.length to hold the product
        double[] X = new double[b.length];
        
        for (int index=0; index<X.length; index++)
            X[index] = multiplyRowVector(A, index, b);
        
        return X;
    }//end method

    /*  METHODS FOR L U DECOMPOSITION   */
    
    /**
     * method reduceMatrix reduced matrix A to L and U
     * @param A, matrix to be reduced
     * 
     */
    public static void reduceMatrix(double A[][], double b[]){
        //create matrix L and U to hold the multipliers 
        //and the reduced A respectively
        double[][] L = new double[A.length][A.length+1];
        double[][] U = new double[A.length][A.length+1];
        double[] y = new double[A.length];
        double[] X = new double[A.length];
        
        //assign values of A to U
        for (int row=0; row<A.length; row++)
            for (int col=0; col<A.length; col++)
                U[row][col] = A[row][col];
        
        //initialise the diagonal of L with 1
        for (int i=0; i<A.length; i++)
            L[i][i] = 1;
        
        boolean swapped = false;
        //reduce A to U
        for (int i=0; i<U.length; i++){
            //swap row 1 with any other row if the first entry is 0
            if (U[0][0] == 0)
                for (int idx=1; idx<U.length; idx++)
                    if (U[idx][0] != 0.0){
                        swapRows(0, idx, U);
                        break;
                    }
            if (U[i][i] == 0.0)
                swapped = true;
            
            for (int j=i+1; j<U.length; j++){
                L[j][i] = U[j][i]/U[i][i];
                reduce(j, i, U, L[j][i]);
            }//end for
        }//end outer for
        if (swapped == false){
            System.out.println("Matrix L");
            displayMatrix(L);
            System.out.println("Matrix U");
            displayMatrix(U);
            System.out.println("To proof the L and U are valide: Matrix A is:");
            displayMatrix(multiplyMatrices(L, U));
            
            //solve the system Ly = b
            //add b to L to form the augmented matrix L|b
            for (int row=0; row<L.length; row++)
                L[row][L.length] = b[row];
            
            //peform forward substitution
            y[0] = L[0][L.length]/L[0][0];
            
            for (int i=1; i<L.length; i++){
                double sum = 0.0;
                for (int j=0; j<i; j++)
                    sum += L[i][j]*y[j];
                y[i] = (L[i][L.length] - sum)/L[i][i];
            }//end outer for
            
            //solve the system UX = y
            //add y to augment U forming U|y
            for (int row=0; row<U.length; row++)
                U[row][U.length] = y[row];
            
            //start backward substitution
            X[U.length-1] = 
                    U[U.length-1][U.length]/U[U.length-1][U.length-1];
            
            for(int i=U.length-2; i>=0; i--){
                double sum = 0.0;
                for (int j=i+1; j<U.length; j++)
                    sum += U[i][j] * X[j];
                X[i] = (U[i][U.length] - sum)/U[i][i];
            }//end for
            for (int i=0; i<X.length; i++)
                System.out.printf("X[%d]=%5.2f   ", i+1, X[i]);
           
        } else {
            System.out.println("System has no unique solution");
        }//end if...else...
        
    }//end method reduce matrix

    //peforms row reduction between two rows
    //reduce row2 by row1 of matrix A using the multiplier 
    private static void reduce
        (int row2, int row1, double[][] A, double multiplier){
            //access the columns of row2 and row1
            for (int i=0; i<A.length; i++)//+1 for augmented matrix
                A[row2][i] = (A[row2][i]) - (multiplier*A[row1][i]);
    }//end method reduce  
        
    //Swaps two rows of a matrix
    //pass the matrix A by reference
    private static void swapRows(int row1, int row2, double A[][]){
        //loop through the columns A.length+1 since it is an augmented matrix
        for (int j=0; j<=A.length; j++){
            double temp = A[row1][j];
            A[row1][j] = A[row2][j];
            A[row2][j] = temp;
        }//end for
    }//end method swapRows

    private static int I = -1;
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

       
    //peform echelon row reduction on matrix A
    public static void elimination(double[][] A, double[] b){
        //create vector to hold x1, x2,...xn
        double[] X = new double[b.length];
        
        //create augmented matrix to hold A and b
        double[][] Aug = new double[A.length][A.length+1];
        
        //assign values of A ang b to augmented matrix Aug
        for (int i=0; i<Aug.length; i++){
            int j;
            for ( j=0; j<Aug.length; j++){
                if (j < (Aug.length))
                    Aug[i][j] = A[i][j];
            }//after execution here, the value of j is incremented automatically
            Aug[i][j] = b[i];   //initialises the A.length+1th columns at i
        }//end for
        
        //create a matrix of multiplier
        double[][] multiplier = new double[A.length][A.length];
        
        int counter = 0;    
        boolean breakage = false;
        
        //peforms the Guassian elimination
        for (int i=0; i<Aug.length; i++){   //row index of augmented matrix
            //check if element in index Aug[i][i] = 0
            if (Aug[i][i] == 0){
                //check if it the last element of the diagonal
                if (i == Aug.length-1 & Aug[i][i+1] != 0){
                        System.out.println("System has no solutions");
                        breakage = true;
                        break;
                    } //end if
                
                //swap current row with another below it
                for (int idx=i+1; idx<Aug.length; idx++){
                    //if first entry of next row is not equal to zero, 
                    //swap row-idx and row-i
                    if (Aug[idx][i] != 0){
                        swapRows(idx, i, Aug);
                        break;
                    }//end if
                    //if the next element below the leading entry is zero
                    if (Aug[idx][i] == 0){
                        counter++;
                    }
                }//end for
            }//end if
            
            if (counter >= (Aug.length-i)){
                System.out.println("System has infinitely many solutions");
                breakage = true;
                break;
            } else {
                //peform an elimination on rowI+1
                for (int j=i+1; j<Aug.length; j++){
                    //set the multiplier
                    multiplier[j][i] = Aug[j][i]/Aug[i][i];
                    reduce(j, i, Aug, multiplier[j][i]);
                }//end inner for    
            }//end if...else...   
        }//end for
        if (breakage == false){
            System.out.println("The Augmented matrix:");
            displayAug(Aug);
            System.out.println("The matrix of multipliers");
            displayMatrix(multiplier);
            
            //start backward substitution
            X[Aug.length-1] = 
                    Aug[Aug.length-1][Aug.length]/Aug[Aug.length-1][Aug.length-1];
            
            for(int i=Aug.length-2; i>=0; i--){
                double sum = 0.0;
                for (int j=i+1; j<Aug.length; j++)
                    sum += Aug[i][j] * X[j];
                X[i] = (Aug[i][Aug.length] - sum)/Aug[i][i];
            }//end for
            
            //display the solution X
            System.out.print("\nThe solution X, is: ");
            for (int i=0; i<X.length; i++)
                System.out.printf("X[%d]=%5.2f   ", i+1, X[i]);
            System.out.println();
        }//end if
    }//end method elimination
   
    public static double[][] inverseOf(double[][] A){
        double determinant = det(A);
        
        //create matrix of cofactors
        double[][] cofactor = new double[A.length][A.length];
        
        //assign the cofactors of A to matrix cofactor
        for (int i=0; i<A.length; i++)
            for (int j=0; j<A.length; j++)
                cofactor[j][i] = (1/determinant)*pow(-1, i+j+2)*det(minor(i, j, A));
        
        //displayMatrix(cofactor);
        return cofactor;
    }

    public static void inverse(double[][] A, double[] b){
        if (det(A) == 0.0)
            System.out.println("\n   System has no unique solution"
                    + "\n    determinant = 0");
        else {
        System.out.println("The invese of A is:");
        displayMatrix(inverseOf(A));
        double[] solution = multiplyMatrixVector(inverseOf(A), b);
        
        System.out.print("\nThe solution set is: ");
        for (int i=0; i<solution.length; i++)
            System.out.printf("X[%d]=%5.2f   ", i, solution[i]);
        }
        
    }//end inverse
    
    public static void cramers(double[][] A, double[] b){
        if (det(A) == 0.0)
            System.out.println("\n   System has no unique solution"
                    + "\n    determinant = 0");
        else {
            double[] sol = new double[A.length];
            
            for (int j=0; j<A.length; j++)
                sol[j] = det(replace(b, A, j)) / det(A);
            
            System.out.print("\nThe solution set is: ");
            for (int i=0; i<sol.length; i++)
                System.out.printf("X[%d]=%5.2f   ", i, sol[i]);
        }
    }
    
}//end main class
