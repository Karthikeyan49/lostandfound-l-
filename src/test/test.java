package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    Connection con;
    Statement st;
    static ResultSet rs;
    static void sample() throws Exception{
        
        //Connection con=DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com/sql12530018", "sql12530018", "cxCupzLUXq");


        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lostandfind", "root", "Karthi@2004");
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        String s="select email,id,color,image from founditem order by id desc";
        rs=st.executeQuery(s);
        rs.next();
        System.out.println(rs.getString("id")+" "+rs.getString("email"));


       /*
        Scanner sc=new Scanner(new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Desktop\\test\\test\\testpro\\src\\img.jpeg")));
        Blob blob=null;
        while(sc.hasNext()){
            byte[] bt=sc.nextLine().getBytes();
        blob=new SerialBlob(bt);
        }
        String s="insert into lostitem values(',ksjclk','jewells','2002-09-09','llkkmls','s;dmm',"+blob+",'jsaj','lksjal','kjhsa',0);";
        st.execute(s);*/
        /*File f=new File("C:\\Users\\User\\OneDrive\\Desktop\\test\\test\\testpro\\src\\main_log.jpeg");
        FileInputStream ft = new FileInputStream(f);
        byte[] b=ft.readAllBytes();
        StringBuilder sbuld=new StringBuilder(b.length *2);
        sbuld.append("0x");
        for(byte bt:b)
            sbuld.append(String.format("%02x",bt));
        String temp=sbuld.toString() ;
        String s="insert into lostitem values(',ksjclk','jewells','2002-09-09','llkkmls','s;dmm',"+temp+",'jsaj','lksjal','kjhsa',0);";
        System.out.println(s);
        st.execute(s);
        ft.close();*/

        
    }
    static void sam() throws SQLException{
        //StringBuilder s=new StringBuilder("");
        
       /*rs.next();
        System.out.println(rs.getString("email")+"  "+rs.getInt("id"));
        rs.previous();
        System.out.println(rs.getString("email")+"  "+rs.getInt("id"));*/
    }
    public static void main(String[] args) throws Exception {
        sample();
        //sam();
    }
}
  
/*
   public static void main(String[] args) throws Exception{
        //create a connection
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lostandfind", "root", "Karthi@2004");
       //create a query
        Statement st=con.createStatement();
        //excute the query
        String s="select *from user;";
        //story data
        //st.execute(s)
        ResultSet rs=st.executeQuery(s);
        while(rs.next()){
            String x=rs.getString("email");            
            System.out.println(x);
            x=rs.getString("password");
            System.out.println(x);
        }
        //close the connection
        con.close();
    }
}
*/
/*{
            "type": "java",
            "name": "Launch Current File",
            "request": "launch",
            "mainClass": "${file}",
            "vmArgs": "--module-path \"C:/Users/User/Downloads/openjfx-19_windows-x64_bin-sdk/javafx-sdk-19/lib\" --add-modules javafx.controls,javafx.fxml"
        }, */
