
import java.io.FileInputStream;
import java.io.FileOutputStream; 
public class fileout { 
 public static void main(String args[]) throws Exception{ 
    /*FileOutputStream o=new FileOutputStream("abc.txt");
    byte[] b;
    String s="sk";
    b=s.getBytes();
    System.out.println(b);
    o.write(b);*/
 FileInputStream fin=new FileInputStream("abc.txt"); 
/*file should be there.*/
int i=0; 
while((i=fin.read())!=-1){ 
System.out.print((char) i);  
 }
 }
}
