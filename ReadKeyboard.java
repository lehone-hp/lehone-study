import java.io.*;

public class ReadKeyboard{
	
	public static void main(String[] args){
		
		BufferedReader keyboard = 
			new BufferedReader(new InputStreamReader(System.in));	
			
		String line;
		try{
			while(true){
				line = keyboard.readLine();
				System.err.println(line);
		
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}
