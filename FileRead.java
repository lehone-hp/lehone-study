import java.io.*;

public class FileRead{

	public static void main(String[] args) throws IOException{

		FileReader reader = null;
		FileWriter writer = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));	//read from the keyboard
		String readFrom = "";
		String writeTo = "";
		Boolean success = false;
		
		
		do{
			try{
				System.out.print("Enter the file to read from: ");
				readFrom = keyboard.readLine();
				
				System.out.print("Enter destination filename: ");
				writeTo = keyboard.readLine();
			
				reader = new FileReader(new File(readFrom));
				writer = new FileWriter(new File(writeTo));

				br = new BufferedReader(reader);
				bw = new BufferedWriter(writer);
				String line = "";

				//int c;
				/*Read the character stream from the output file and write them to the input file using the 
				FileReader and FileWriter objecs: reader, writer*/
				while ((line=br.readLine()) != null){	
					System.out.println(line);
					bw.write(line+"\n");
					bw.flush();
				}
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			}
	
		}while(success == false);	
	}
}
