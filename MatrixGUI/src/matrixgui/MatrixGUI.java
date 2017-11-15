package matrixgui;
import java.util.ArrayList;

import java.util.Scanner;

public class MatrixGUI {

    public static void main(String[] args) {

        /**int test = 0, i, N;
        ArrayList array_one= new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Write An Integer :");
        test = sc.nextInt();
        while (test > 0){
          int mod = test % 10; // <= DON'T UNDERSTAND THE WORK OF THAT PART
                               // (i know it's the modulo of the entered value)
           test = test / 10;
           array_one.add(mod);
        }
        System.out.print(array_one);
        */
        
        int num = 123456, i=0;
        int[] a = new int[6];
        
        while (num > 0){
            a[i++] = num % 10;
            num /= 10;
        }
        
        for (int ii=0; ii<6; ii++)
            System.out.print(" "+a[ii]);
        
    }
    
}
