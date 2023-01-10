import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class control_login{

    @FXML
    private Button button1;// login button
    @FXML
    private Button button2;// sigup button
    @FXML
    private Label label1;// display the incoorect field
    @FXML
    private TextField textfield1;// username
    @FXML
    private PasswordField textfield2;// password
    @FXML
    private Circle circle;//circle
    @FXML
    private Label forgetpass;
    App ob = new App();
    public void initialize() throws SQLException {
        Image img=new Image("main_log.jpeg");
        circle.setFill(new ImagePattern(img)); 
        Main.mail=null;
    }
    @FXML
    void login_button(ActionEvent event) throws Exception {
        // database connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lostandfind", "root", "Karthi@2004");
        Statement st = con.createStatement();
        // checking whether the field is empty
        if (textfield1.getText().equals(""))
            label1.setText("enter the username");
        else if (textfield2.getText().equals(""))
            label1.setText("enter the password");
        // check whether the user has account and checking password
        else {
            // sql query for selecting password for the email id
            String s = "select password,email from user where email='" + textfield1.getText() + "';";
            ResultSet rs = st.executeQuery(s);
            if (!(rs.next())){
                label1.setText("you don't have account");
            }
            // loading the next fxml file into main Hbox(welcome)
            else if (rs.getString("password").equals(textfield2.getText())){
                Main.mail=textfield1.getText();
                ob.openfile("option");
            }
            else{
                label1.setText("password incorrect");
            }
            // colsing the connection
            con.close();
        }
    }
    @FXML
    void onpresslogin(MouseEvent event) {
        button1.setEffect(new Glow());
    }
    @FXML
    void onreleselogin(MouseEvent event) {
        button1.setEffect(new DropShadow());
    }
    @FXML
    void ondragenterlogin(MouseEvent  event) {
        button1.setEffect(new DropShadow());
    }
    @FXML
    void ondragexitlogin(MouseEvent  event) {
       button1.setEffect(null);
    }
    @FXML
    // initial sigup
    void signup_button(ActionEvent event) throws Exception {
        // loading the signup.fxml file into main borderpane
        ob.openfile("signup");
    }
}