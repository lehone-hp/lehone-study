/*
Program copies any file from one location args[0]
to another location args[1]
*/
import java.io.*;

class FileStreamTest{

	public static void main(String[] args) throws IOException{

		InputStream in = null;
		OutputStream out = null;
		
		if (args.length != 2){
			throw new IllegalArgumentException("Must have two argmunets, (location, destination)");
		}
		
		try{
			out = new FileOutputStream(args[1]);
			//for(int i=0; i<bWrite.length; i++){
			//	out.write(bWrite[i]);
			//}

			in = new FileInputStream(args[0]);
			
			//int size = in.available();
			byte[] buffer = new byte[2048];
			int length = 0;
			
			while ((length = in.read(buffer)) != -1){
				System.out.println("Read of length: "+length);
				out.write(buffer, 0, length);
			}
			//for(int i=0; i<size; i++){
			//	out.write(in.read());
		}catch(IOException e){
			System.err.println("Error reading file");
		}finally{
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}//end main
}//end class
