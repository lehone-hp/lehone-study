import java.io.*;

public class PrintBytes{

	public static void main(String[] args){
		FileReader fileIn = null;
		FileWriter fileOut = null;

		if (args.length != 2)
			throw new IllegalArgumentException("Main takes two arguments");

		try{
			fileIn = new FileReader(args[0]);
			fileOut = new FileWriter(args[1]);
                        
                        int c;
			while((c = fileIn.read())  != -1){
				System.out.println(c);
				fileOut.write(c);

			}
			fileIn.close();
			fileOut.close();
		}catch(IOException e){e.printStackTrace();}

	}				
}