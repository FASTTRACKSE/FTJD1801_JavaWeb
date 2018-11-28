package btvn.client_server.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Socket socket = new Socket("localhost", 6969);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("client: ");
			String msg = sc.nextLine();
			dos.writeUTF("Client: "+msg);
			dos.flush();
			String st = din.readUTF();
			System.out.println(st);
			sc = sc.reset();
		}
	}

}
