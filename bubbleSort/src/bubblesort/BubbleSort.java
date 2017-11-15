/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

/**
 *
 * @author lehone_hope
 */
public class BubbleSort {
    int swapCount = 0;  //hold number of swaps peformed for each sort
    
    //swap elements in an array
    private void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }//end method bubble sort
    
    //method bubble
    private boolean bubble(int a[]){
        boolean swap = false;   //if no swap occured
        
        //moves thiugh the list once from index[0] to index[a.length-1]
        for (int i=0; i<a.length - 1; i++){
            if (a[i] > a[i+1]){
                swap(a, i, i+1);    //call method swap
                swapCount++;    //count number of swaps for the entire sorting
                swap = true;    //true if an element was swapped
            }//end if           
        }//end for
        return swap;    
    }//end method bubble

    //peforms the bubble sort operation
    public void sort(int a[]){
        boolean arraySwap = true; 
        int bubbleCounter = 0;
       
        //while loop ends only if we move through the list 
        //without any swapping. If swap occured method bubble returns true
        while (arraySwap != false){
            bubbleCounter++;
            arraySwap = bubble(a);
        }
        for (int i=0; i<a.length; i++)
            System.out.print(a[i]+ " ");
        System.out.printf("\n\nlist  bubbled %d times.\n"
                + "and swapped %d times,\n", bubbleCounter, swapCount);
    }//end method sort
}//end class bubble
