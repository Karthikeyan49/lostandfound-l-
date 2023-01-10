import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server1 {
    public static void main(String[] args) throws Exception{
        ServerSocket sr = new ServerSocket(7777);
        Socket sock = sr.accept();
        BufferedReader key=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader si=new BufferedReader(new InputStreamReader(sock.getInputStream()));
        OutputStream out=sock.getOutputStream();
        PrintWriter pt=new PrintWriter(out,true);
        String send=null;
        while(true){
            if(!(send=si.readLine()).equals(""))
                System.out.println(send);
                pt.println(key.readLine());
        }
    }
}
