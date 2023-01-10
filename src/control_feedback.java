import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class control_feedback {

    @FXML
    private RadioButton a;
    @FXML
    private RadioButton a1;
    @FXML
    private RadioButton b;
    @FXML
    private RadioButton b1;
    @FXML
    private Button button;
    @FXML
    private RadioButton c;
    @FXML
    private RadioButton c1;
    @FXML
    private RadioButton d;
    @FXML
    private RadioButton d1;
    @FXML
    private TextArea txt;

    StringBuilder s=new StringBuilder("");
    App ob=new App();

    @FXML
    void onclick(ActionEvent event) throws Exception {
        if (a.isSelected())
            s = s.append("," + a.getText());
        if (b.isSelected())
            s = s.append("," + a.getText());
        if (c.isSelected())
            s = s.append("," + c.getText());
        if (d.isSelected())
            s = s.append("," + d.getText());
        if (a1.isSelected())
            s = s.append("," + a1.getText());
        if (b1.isSelected())
            s = s.append("," + b1.getText());
        if (c1.isSelected())
            s = s.append("," + c1.getText());
        if (d1.isSelected())
            s = s.append("," + d1.getText());
        s.deleteCharAt(0);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lostandfind", "root", "Karthi@2004");
        Statement st = con.createStatement();
        String str="insert into feedback values('"+s+"','"+txt.getText()+"','"+Main.mail+"')";
        System.out.println(str);
        st.execute(str);
        ob.openfile("option");
    }
}
