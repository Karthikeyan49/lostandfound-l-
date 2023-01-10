import java.util.Scanner;

class thead1 extends Thread{
    public void run(){
        try {
            Thread.sleep(1000);           
        } catch (Exception e) {
            System.out.println(e);
        }
        while(true){
            System.out.print("1");
        }    
    }
    
}

class thead2 extends Thread{ z
    public void run(){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.exit(1);
    }
}

public class threadtest {
    public static void main(String[] args) throws Exception{
        thead1 t2=new thead1();
        t2.run();
        thead2 t1=new thead2();
        t1.run();
    }
}
