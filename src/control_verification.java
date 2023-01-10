import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class control_verification {

    App ob = new App();
    Connection con;
    Statement st;
    static ResultSet rs;
    String s;

    control_foundpage ob1 = new control_foundpage();
    @FXML
    private TextArea descrip;

    @FXML
    private Label email_of_founder;

    @FXML
    private TextField pdf;

    @FXML
    private Button submit;

    @FXML
    private TextField type;

    @FXML
    AnchorPane dialogid;

    public void initialize() {
        email_of_founder.setText(control_foundpage.str);
    }
    StringBuilder sbuld;
    @FXML
    void onbrowse(ActionEvent event) throws IOException {
        final FileChooser dirchoose = new FileChooser();
        Stage stage = (Stage) dialogid.getScene().getWindow();
        File file = dirchoose.showOpenDialog(stage);
        pdf.setText(file.getAbsolutePath());
        File f=new File(file.getAbsolutePath());
        FileInputStream ft = new FileInputStream(f);
        byte[] b=ft.readAllBytes();
        sbuld=new StringBuilder(b.length *2);
        sbuld.append("0x");
        for(byte bt:b)
            sbuld.append(String.format("%02x",bt));
            
        sbuld.toString();  
        ft.close(); 
    }

    @FXML
    void onsubmit(ActionEvent event) throws Exception {
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lostandfind", "root", "Karthi@2004");
        st = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        s = "insert into verification values(" + control_foundpage.id + ",'" + Main.mail + "','"
                + descrip.getText() + "'," +sbuld.toString()+ "," + type.getText()
                + "','');";
        st.execute(s);
        ob.openfile("option");
    }

}
