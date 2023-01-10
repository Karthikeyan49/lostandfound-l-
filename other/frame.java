import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 class frame{
    public JButton b=null;
    public JLabel l1;
    public JCheckBox c1,c2,c3;
    frame(){
        JFrame j=new JFrame("muthu");
        j.setSize(400, 400);
        j.setVisible(true);
        l1=new JLabel("enter the name : ");
        l1.setBounds(300,300,100,20);
        b=new JButton("button");
        b.setBounds(250, 200, 100, 30);
        c1 = new JCheckBox("kumar");
        j.setLayout(null);
        j.add(b);
        j.add(l1);
        j.add(c1);
    }
    public static void main(String[] args) {
        frame d=new frame();
    }
}
