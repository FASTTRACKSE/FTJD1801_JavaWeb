package btvn.client_server.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class GetTimeClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		DatagramSocket clientSocket = new DatagramSocket();
		//Gắn cổng
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		sendData = "getDate".getBytes();
		//Tạo datagram có nội dung yêu cầu loại dữ liệu để gửi cho server
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,6969);
		clientSocket.send(sendPacket);
		//Gửi dữ liệu cho server
		//Tạo datagram rỗng để nhận dữ liệu
		DatagramPacket receivePacket =  new DatagramPacket(receiveData, receiveData.length);
		//Nhận dữ liệu từ server 
		clientSocket.receive(receivePacket);
		//Lấy dữ liệu từ packet nhận được
		String str = new String(receivePacket.getData());
		System.out.println(str);
		clientSocket.close();
	}

}
