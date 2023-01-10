import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class client1{
    public static void main(String[] args) throws Exception{
        BufferedReader ui=new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket d=new DatagramSocket();
        byte[] b1=new byte[1024];
        byte[] b2=new byte[1024];
        InetAddress intet=InetAddress.getLocalHost();
        String s="hello";
        b1=s.getBytes();
        DatagramPacket dp=new DatagramPacket(b1,b1.length, intet, 4444);
        d.send(dp);
        DatagramPacket dp1=new DatagramPacket(b2, b2.length);
        d.receive(dp1);
        String s1=new String(dp1.getData());
        System.out.println(s1);
    }
}
