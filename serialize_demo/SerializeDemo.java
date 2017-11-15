import java.io.*;

public class SerializeDemo{

	public static void main(String[] args){

		Employee hope = new Employee();
		hope.name = "Lenya Hope";
		hope.address = "Sandpit, Buea";
		hope.SSN = 15117;
		hope.number = 675230094;

		try{
			FileOutputStream fileOut = new FileOutputStream("output.ser");
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

			objOut.writeObject(hope);
			objOut.close();
			fileOut.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}