import java.net.*;
import java.io.*;

public class GreetingClient{

	public static void main(String[] args){

		String serverName = args[0];
		int port = Integer.parseInt(args[1]);

		try{

			//create a socket
			Socket client = new Socket(serverName, port);
			System.out.println("Just connected to "
                      + client.getRemoteSocketAddress());
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out =
	                       new DataOutputStream(outToServer);

	         out.writeUTF("Hello from "
	                      + client.getLocalSocketAddress());
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in =
	                        new DataInputStream(inFromServer);
	         System.out.println("Server says " + in.readUTF());
	         client.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}//end main
}