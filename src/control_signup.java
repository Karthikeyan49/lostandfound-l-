import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import packages.user;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class control_signup implements Initializable{
    
    // =========================================================================================================================
    // signup page
    // ==========================================================================================================================
    @FXML
    private TextField emailID;
    @FXML
    private PasswordField password;
    @FXML
    private TextField name;
    @FXML
    private TextField locat;
    @FXML
    private TextField phonenumber;
    @FXML
    private Button signup;
    @FXML
    private Label strongpassword;// display whether if the password is not Stong
    @FXML
    private Label emptyfield;// display error text if textfields has error
    @FXML
    private Circle circle;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Image img=new Image("main_log.jpeg");
        circle.setFill(new ImagePattern(img));
    }
    @FXML
    void signup(ActionEvent event) throws Exception {
        App ob = new App();
        user b = new user();
        // database connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lostandfind", "root", "Karthi@2004");
        Statement st = con.createStatement();
        // sql query for getting the email id and mobile number if any of this ready has
        // by otther user
        String s = "select email,mobile_number from user where email='" + emailID.getText() + "'or mobile_number='"
                + phonenumber.getText() + "';";
        ResultSet rs = st.executeQuery(s);
        // string for assigning the email and number
        String mail = null, num = null;
        if (rs.next()) {
            mail = rs.getString("email");
            num = rs.getString("mobile_number");
        }
        // asingning the details with datamembers of class user using object b
        b.name = name.getText();
        b.password = password.getText();
        b.email = emailID.getText();
        b.mobile_number = phonenumber.getText();
        String ss = phonenumber.getText();
        // checking whether the field is empty except loaction
        if (b.name.equals("") || b.password.equals("") || b.mobile_number.equals("") || b.email.equals("")) {
            emptyfield.setText("enter the required field");
        }
        // checking password strenth
        else if (!(b.password_validate(b.password))) {
            strongpassword.setText("enter the strong password");
        }
        // checking email whether the user has already account
        else if (b.email.equals(mail)) {
            strongpassword.setText("");
            emptyfield.setText("email id is already available");
        }
        // checking mobile number whether the user has already account
        else if (b.mobile_number.equals(num)) {
            emptyfield.setText("mobile number is already available");
        }
        // whether the number has length 10
        else if (ss.length() != 10) {
            strongpassword.setText("");
            emptyfield.setText("enter the mobile number with 10 digit");
        }
        // check whether it is mobile number
        else if (!(b.numbervalidate(ss))) {
            emptyfield.setText("enter 10 digits of mobile number");
        }
        // clearing lables and giving data to the database
        else {
            emptyfield.setText("");
            Main.mail=emailID.getText();
            // inserting values to datbase
            s = "insert into user values('" + name.getText() + "','" + emailID.getText() + "','" + password.getText()
                    + "','" + phonenumber.getText() + "','" + locat.getText() + "')";
            st.execute(s);
            con.close();
            ob.openfile("option");
            
        }
    }
}

