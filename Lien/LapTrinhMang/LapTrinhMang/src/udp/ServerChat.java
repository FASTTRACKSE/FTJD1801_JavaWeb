package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class ServerChat {
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
            System.out.println("from Client :"+request);
           // String xlchuoi= request.toUpperCase();      
            Scanner sc = new Scanner(System.in);
            System.out.println("Server send: ");
            String send=sc.nextLine();
            sendData= send.getBytes();                  
            DatagramPacket sendPacket= new DatagramPacket(sendData,sendData.length , IP, port);
             serverSocket.send(sendPacket);
            
        }
        
    }
    
}

