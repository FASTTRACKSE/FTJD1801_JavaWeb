package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Administrator
 */
public class ClientTime {
    public static void main(String[] args) throws Exception{
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IP = InetAddress.getByName("localhost");
        byte[] reciveData = new byte[1024];
        byte[] sendData = new byte[1024];
        sendData ="getDate".getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, 9876);
        clientSocket.send(sendPacket);
        DatagramPacket recivePacket = new DatagramPacket(reciveData,reciveData.length);
        clientSocket.receive(recivePacket);
        String Str = new String(recivePacket.getData());
        System.out.println(Str);
        clientSocket.close();
        
        
    }
    
}
