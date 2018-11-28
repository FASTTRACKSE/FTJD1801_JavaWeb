package btvn.client_server.tcp;

import java.io.DataInputStream;
import java.net.Socket;

public class GetTimeClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket socket = new Socket("localhost", 6969);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		String time = din.readUTF();
		System.out.print(time);
	}

}
