import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class test {
    public static void main(String[] args) throws Exception{
            byte[] b1=new byte[1024];
            byte[] b2=new byte[1024];
            FileInputStream f=new FileInputStream("..\\src\\img.jpeg");
            b1=f.readAllBytes();
            File ff=new File("img.jpeg");
            DataOutputStream d=new DataOutputStream(new FileOutputStream("img.jpeg"));
            for (byte b : b1) {
                d.writeByte(b);
            }
        StringBuilder b=new StringBuilder("kalja");
        StringBuilder b3=new StringBuilder();
        b3.append(b.charAt(1));
        System.out.println(b3.toString());
    }
}
