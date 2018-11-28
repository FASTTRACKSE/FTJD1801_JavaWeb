package btvn.client_server.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(6969);
		System.out.println("Server is started");
		Socket socket = server.accept();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		Scanner sc = new Scanner(System.in);
		while(true) {
			String st = din.readUTF();
			System.out.println(st);
			System.out.println("Server: ");
			String msg = sc.nextLine();
			dos.writeUTF("Server: "+msg);
			dos.flush();
			sc = sc.reset();
		}
	}
}
