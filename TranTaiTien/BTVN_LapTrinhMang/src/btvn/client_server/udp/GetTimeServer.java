package btvn.client_server.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class GetTimeServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// Gắn cổng 6969 cho chương trình
		DatagramSocket serverSocket = new DatagramSocket(6969);
		// Tạo các mảng byte để chứa dữ liệu gửi và nhận
		System.out.println("Server is started");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while (true) {
			// Tạo gói rỗng để nhận dữ liệu từ client
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			// Nhận dữ liệu từ client
			serverSocket.receive(receivePacket);
			// Lấy địa chỉ IP của máy client
			InetAddress IPAddress = receivePacket.getAddress();
			// Lấy port của chương trình client
			int port = receivePacket.getPort();
			// Lay ngày giờ để gửi ngược lại client
			String request = new String(receivePacket.getData());
			System.out.println(request);
			if (request.trim().equals("getDate")) {
				sendData = new Date().toString().getBytes();
			} else {
				sendData = "Server not know what you want?".getBytes();
			}
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			// Gửi dữ liệu lại cho client
			serverSocket.send(sendPacket);
		}
	}

}
