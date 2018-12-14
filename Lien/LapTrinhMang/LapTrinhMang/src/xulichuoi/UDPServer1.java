package xulichuoi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer1 {
	private static String thuongHoa(String str) {
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				ch = (char) (ch - 32);
			}
			temp += ch;
		}
		return temp;
	}

	private static String chuoiDao(String str) {
		String temp = "";
		for (int i = str.length(); i >= 0; i--) {
			char ch = str.charAt(i);
			
			temp += ch;
		}
		return temp;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			String st = new String(receivePacket.getData());
			InetAddress IPAdress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String request = new String(receivePacket.getData(), "UTF-8");
			String s="";
			s+="Thuong hoa"+request.getBytes();
		}

	}

}
