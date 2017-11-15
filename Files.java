import java.io.*;

class Files{

	public static void main(String[] args) throws IOException{
		
		FileReader in = null;
		FileWriter out = null;

		try{
			in = new FileReader("jhtp.pdf");
			out = new FileWriter("jhtp");

			int c = 0;
			while((c = in.read()) != -1){
				if ((c == 10))
					continue;
				out.write(c);
			}

		}catch(Exception e){}
		finally{
			if (in != null)
				in.close();
			if (out != null)	
				out.close();
		}			
	}
}
