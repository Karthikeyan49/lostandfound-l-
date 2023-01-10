import java.net.*;
import java.io.*;
import java.util.*;

class client {
    public static void main(String[] args) throws SocketException,IOException {
        DatagramSocket s = new DatagramSocket();
        Scanner ob = new Scanner(System.in);
        System.out.println("enter the String: ");
        String str = ob.nextLine();
        byte[] send = new byte[str.length()];
        byte[] receive = new byte[1];
        send = str.getBytes();
        DatagramPacket dpsend = new DatagramPacket
(send,send.length,InetAddress.getLocalHost(),1234);
        s.send(dpsend);
        DatagramPacket dpreceive = new DatagramPacket
(receive,receive.length);
        s.receive(dpreceive);
        System.out.println("String has "+receive[0] + " consonants");
        s.close();
        ob.close();
    }
}