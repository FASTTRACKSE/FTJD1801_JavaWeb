package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class ServerTime  {
    public static void main(String[] args) throws Exception{
        DatagramSocket serverSocket = new DatagramSocket(9876);
        System.out.println("Server is started!!");
        byte[] reciveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true){
            DatagramPacket recivePacket = new DatagramPacket(reciveData,reciveData.length);
            serverSocket.receive(recivePacket);
            InetAddress IP = recivePacket.getAddress();
            int port = recivePacket.getPort();
            String request = new String(recivePacket.getData());
            System.out.println(request);
            if(request.trim().equals("getDate"))
                sendData= new Date().toString().getBytes();
            else 
                sendData="Server is not know !!".getBytes();
            DatagramPacket sendPacket= new DatagramPacket(sendData,sendData.length , IP, port);
             serverSocket.send(sendPacket);
            
        }
        
    }
    
}
