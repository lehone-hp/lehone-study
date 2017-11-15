import java.io.*;

public class ReadDir{

	public static void main(String[] args){

		File dir = null;
		String[] paths;

		try{
			dir = new File("SchoolWork/fileCopyTextDir");
			paths = dir.list();

			for (String s : paths){
				System.out.print(s+"\n");
			}
		}catch(Exception e){}
	}//end main
}//end class