package test;

import java.io.*;

public class sample {
    public static void main(String[] args) throws IOException {
        File f=new File("C:\\Users\\User\\OneDrive\\Desktop\\test\\test\\testpro\\src\\img.jpeg");
        try (FileInputStream ft = new FileInputStream(f)) {
            byte[] b=ft.readAllBytes();
            StringBuilder str=new StringBuilder("");
            for(byte bt:b)
            str.append((bt));
        
           System.out.println(b);
        }
    }
}
