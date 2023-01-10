import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.*;

public class server{
    public static void main(String[] args) throws Exception{
        BufferedReader ui=new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket d=new DatagramSocket(4444);
        byte[] b1=new byte[1024];
        byte[] b2=new byte[1024];
        DatagramPacket dp1=new DatagramPacket(b2, b2.length);
        d.receive(dp1);
        String s1=new String(dp1.getData());
        System.out.println(s1);
        InetAddress i=dp1.getAddress();
        int port=dp1.getPort();
        String s="hi";
        b1=s.getBytes();
        DatagramPacket dp=new DatagramPacket(b1,b1.length, i,port);
        d.send(dp);
    }
}