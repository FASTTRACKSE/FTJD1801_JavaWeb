package xulichuoi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
DatagramSocket serverSocket= new DatagramSocket(9876);
byte[] receiveData = new byte[1024];
byte[] sendData = new byte[1024];
while(true)
{
	DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
	serverSocket.receive(receivePacket);
	String st = new String(receivePacket.getData());
	InetAddress IPAdress = receivePacket.getAddress();
	int port = receivePacket.getPort();
	String st1 = st.toUpperCase();
	sendData = st1.getBytes();
	DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAdress,port);
	serverSocket.send(sendPacket);
	}
	}

}
