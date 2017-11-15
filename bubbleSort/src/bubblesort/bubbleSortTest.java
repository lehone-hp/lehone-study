/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;
import java.util.Random;
/**
 *
 * @author lehone_hope
 */
public class bubbleSortTest {
    public static void main(String args[]){
       
        Random randomNumbers = new Random();
        BubbleSort testSort = new BubbleSort();
          
        final int[] ARRAY = new int[10];
        
        //print unsorted list
        System.out.print("Unsorted list: ");
        for (int i=0; i<ARRAY.length; i++){
            ARRAY[i] = randomNumbers.nextInt(100);
            System.out.printf("%d ", ARRAY[i]);
        }//end for
        
        //print sorted list
       System.out.print("\nsorted list:   ");
       testSort.sort(ARRAY);
    }
}
