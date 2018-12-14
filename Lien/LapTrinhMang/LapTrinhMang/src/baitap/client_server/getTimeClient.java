package baitap.client_server;

import java.io.DataInputStream;
import java.net.Socket;

public class getTimeClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket socket= new Socket("localhost",1207);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		String time = din.readUTF();
		System.out.println(time);
	}

}
