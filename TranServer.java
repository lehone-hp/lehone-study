import java.io.*;
import java.net.*;

public class TranServer{

	ServerSocket ss = null;
	Socket s = null;
	
	public static void main(String[] args){
	
		ss = new ServerSocket(40000);
		s = ss.accept();
		
		
	
	}//end main

}//end class
