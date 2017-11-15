package increment;

/**
 * @author lehone_hope
 */
public class Increment {

    public static void main(String[] args) {
        int c;
        
        //demonstate postfix increment operator
        c = 5;
        System.out.println( c );    //prints 5
        System.out.println( c++ );  //prints 5 then postincrement
        System.out.println( c );    //prints 6
        
        System.out.println();
        
        //demonstate prefix increment operator
        c = 5;
        System.out.println( c );    //prints 5
        System.out.println( ++c );  //preincrements then prints 6
        System.out.println( c );    //prints 6
    }//end main
}//end class
