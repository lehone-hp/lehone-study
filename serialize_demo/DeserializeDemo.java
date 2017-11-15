import java.io.*;

public class DeserializeDemo{

	public static void main(String[] args){

		Employee hope = null;

		try{
			FileInputStream fileIn = new FileInputStream("output.ser");
			ObjectInputStream objIn = new ObjectInputStream(fileIn);

			hope = (Employee) objIn.readObject();
			
			fileIn.close();
			objIn.close();
		}catch(Exception e){
			e.printStackTrace();
		}//end try...catch...

		if (hope != null){
			System.out.println(hope.name);
			System.out.println(hope.address);
			System.out.println(hope.SSN);
			System.out.println(hope.number);
		}else{
			System.out.println("hope is NULL");
		}//end if...else...


	}//end main
}//end class