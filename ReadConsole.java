import java.io.*;

class ReadConsole{

    public static void main(Strin[] args) throws IOException{
      InputStreamReader in = null;

      try{
        in = new InputStreamReader(System.in);
        System.out.println("Enter q to quit")

        char c;
        do{
          c = (char) in.read();
          System.out.print(c +"  "+(int)c);
        }while(c != 'q');
      }catch(Exception e){}
        finally{
          if (in != null)
            in.close();
        }
    }//end main

}
