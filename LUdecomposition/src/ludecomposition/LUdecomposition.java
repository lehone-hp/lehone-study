/*
 * peforming LU decomposition using 
 * row reduction without row interchanging
 * 
 */
package ludecomposition;

/**
 *
 * @author lehone_hope
 */
public class LUdecomposition {

    public static void main(String[] args) {
    
                double[][] A = { {-2, 1, 0, 0},
                                 {1, -2, 1, 0},
                                 {0, 1, -2, 1},
                                 {0, 0, 1, -2}};
                double[] b = {0, 1, 0, 1};
        reduceMatrix(A, b);
    }//end main


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
    public static void reduce
        (int row2, int row1, double[][] A, double multiplier){
            //access the columns of row2 and row1
            for (int i=0; i<A.length; i++)//+1 for augmented matrix
                A[row2][i] = (A[row2][i]) - (multiplier*A[row1][i]);
    }//end method reduce  
        
    //Swaps two rows of a matrix
    //pass the matrix A by reference
    public static void swapRows(int row1, int row2, double A[][]){
        //loop through the columns A.length+1 since it is an augmented matrix
        for (int j=0; j<=A.length; j++){
            double temp = A[row1][j];
            A[row1][j] = A[row2][j];
            A[row2][j] = temp;
        }//end for
    }//end method swapRows
    
    /**
     * displayMatrix, displays the matrix in the parameter list
     * @param A, matrix to be displayed
     */
    public static void displayMatrix(double A[][]){
            
        for (double[] A1 : A) {
            for (int column = 0; column<A.length; column++) {
                System.out.printf("%5.1f   ", A1[column]);
            }
            System.out.printf("\n");
        } //end outer for
    }//end displayMatrix for double matrics/

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
     *method multiplyColumn
     * @param A, is the matrix whose row-I is to be multiplied by column-J of B
     * @param rowI, is the row of matrix A which is to be multiplied
     * @param B, matrix whose column J is to be multiplied
     * @param columnJ, represent the index of column J of Matrix B
     * @return product of rowI of A and column J of B 
     */
    public static double multiplyRowColumn
        (double A[][], int rowI, double B[][], int columnJ ){   //param list
            double sum = 0; //holds the SOP
            
            for( int i=0; i<A.length; i++)
                sum += (A[rowI][i] * B[i][columnJ]);
        return sum;
    }//end multiply Method multiplyRowColumn
    
    
        /**
     * displayMatrix, displays the matrix in the parameter list
     * @param A, matrix to be displayed
     */
    public static void displayAug(double A[][]){
        for (double[] A1 : A) {
            for (int column = 0; column<A.length+1; column++) {
                System.out.printf("%5.1f  ", A1[column]);
            }
            System.out.printf("\n");
        } //end outer for
    }//end displayMatrix for double matrics/

}//end class