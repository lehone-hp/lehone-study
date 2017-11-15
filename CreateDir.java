import java.io.*;

public class CreateDir{

	public static void main(String[] args){

		String dirPath = "Hope/Nembi/kuzuki";

		File d = new File(dirPath);
		d.mkdirs();

		File c = new File("hp.jpeg");
		c.mkdir();
	}//end main
}//end classs