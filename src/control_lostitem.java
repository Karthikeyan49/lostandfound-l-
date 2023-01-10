import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class control_lostitem {
    static String temp=null;
    ObservableList<String> itemlist = FXCollections.observableArrayList("electronics", "jewells", "lkey", "books");
    @FXML
    private TextField Brand_name_textfield;
    @FXML
    private ChoiceBox<String> Category_choicebox;
    @FXML
    private TextField Description_textfield;
    @FXML
    private TextField Item_name_textfield;
    @FXML
    private TextField Location_textfield;
    @FXML
    private TextField Lost_date_textfield;
    @FXML
    private RadioButton Register_item_rbutton;
    @FXML
    private RadioButton chat_rbutton;
    @FXML
    private TextField color_textfield;
    @FXML
    private RadioButton feedback_rbutton;
    @FXML
    private RadioButton founditemlist_rbutton;
    @FXML
    private RadioButton lostitemlist_rbutton;
    @FXML
    private Button register;
    @FXML
    private Button upload;
    @FXML
    private AnchorPane dialogid;
    @FXML
    private TextField Image_textfield;

    @FXML
    private void initialize() {
        Category_choicebox.setItems(itemlist);
    }

    StringBuilder sbuld;
    
    @FXML
    void ongohome(ActionEvent event) throws Exception{
        App ob=new App();
        ob.openfile("option");
    }
    
    @FXML
    void upload_button(ActionEvent event) throws Exception {
        final FileChooser dirchoose = new FileChooser();
        Stage stage = (Stage) dialogid.getScene().getWindow();
        File file = dirchoose.showOpenDialog(stage);
        Image_textfield.setText(file.getAbsolutePath());
        File f = new File(file.getAbsolutePath());
        FileInputStream ft = new FileInputStream(f);
        byte[] b = ft.readAllBytes();
        sbuld = new StringBuilder(b.length * 2);
        sbuld.append("0x");
        for (byte bt : b)
            sbuld.append(String.format("%02x", bt));
   
        temp=sbuld.toString();
        ft.close();
    }

    @FXML
    void register_button(ActionEvent event) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lostandfind", "root", "Karthi@2004");
        Statement st = con.createStatement();
        String s = "insert into lostitem values('" + Item_name_textfield.getText() + "','"
                + Category_choicebox.getValue() + "','" + Lost_date_textfield.getText()
                + "','" + Location_textfield.getText() + "','" + Brand_name_textfield.getText() + "',"+temp+",'"
                + color_textfield.getText() + "','" + Description_textfield.getText() + "','" + Main.mail + "',0);";
        st.execute(s);
        App app = new App();
        app.openfile("option");
        con.close();
    }

}