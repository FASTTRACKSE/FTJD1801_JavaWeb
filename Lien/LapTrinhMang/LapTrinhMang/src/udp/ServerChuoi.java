package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class ServerChuoi {
    public String dao_chuoi(String st){
       //st=st.trim();
       String s=" ";
       for (int i = st.length()-1; i >=0; i--) {
           s +=st.charAt(i);
       }
      // System.out.println("Chuoi sau khi dao la : "+s);
       return s;
   }
   public String thuong_hoa(String st1){      
      st1= st1.toUpperCase();
    //  System.out.println("Chuoi sau khi in hoa la : "+st1);
      return st1;
   }
   public void hoa_va_thuong(String st2){
       
   }
}