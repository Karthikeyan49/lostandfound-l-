import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class control_lostpage {
    ObservableList<String> itemlist = FXCollections.observableArrayList("electronics", "jewells", "lkey", "books");
    @FXML
    private Label brandname;
    @FXML
    private TextField brandname_tf;
    @FXML
    private ChoiceBox<String> category;
    @FXML
    private Label colour;
    @FXML
    private TextField colour_tf;
    @FXML
    private Label description1;
    @FXML
    private Label filter;
    @FXML
    private DatePicker fromdate;
    @FXML
    private Label location_l;
    @FXML
    private TextField location_tf;
    @FXML
    private Label lostdate;
    @FXML
    private TextField lostdate_tf;
    @FXML
    private Button moreinfo;
    @FXML
    private Label name;
    @FXML
    private TextField name_tf;
    @FXML
    private Button nxtbutton;
    @FXML
    private Rectangle rectangle;
    @FXML
    private Button previousbutton;
    @FXML
    private TextArea textarea1;
    @FXML
    private Button refreshbut;
    @FXML
    private DatePicker tilldate;
    @FXML
    private Label title;
    @FXML
    private Button showless;

    Connection con;
    Statement st;
    static ResultSet rs;
    String s;

    @FXML
    void initialize() throws Exception {
        // choices
        category.setItems(itemlist);
        // database managing using both scrolling option
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lostandfind", "root", "Karthi@2004");
        st = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        s = "select *from lostitem order by id desc";
        setresultset();
    }

    @FXML
    void morbutt(ActionEvent event) {
        showless.setVisible(true);
        visibility(true);
    }

    @FXML
    void nextbutton(ActionEvent event) throws Exception {
        if (rs.next())
            load();
    }

    @FXML
    void previousbut(ActionEvent event) throws Exception {
        if (rs.previous())
            load();
    }

    @FXML
    void refreshaction(ActionEvent event) throws Exception {
        if (!(category.getValue() == null) && !(fromdate.getValue() == null)
                && !(tilldate.getValue() == null)) {
            s = "select *from lostitem where (catagory='" + category.getValue() + "') and (lostdate between  '"
                    + fromdate.getValue() + "' and '" + tilldate.getValue() + "') order by id desc";
            setresultset();
        } else if (!(category.getValue() == null) && fromdate.getValue() == null && tilldate.getValue() == null) {
            s = "select *from lostitem where catagory='" + category.getValue() + "' order by id desc";
            setresultset();
        } else if (!(fromdate.getValue() == null) && !(tilldate.getValue() == null) && category.getValue() == null) {
            s = "select *from lostitem where lostdate between '" + fromdate.getValue() + "' and '"
                    + tilldate.getValue()
                    + "' order by id desc";
            setresultset();
        }

    }

    @FXML
    void onshowless(ActionEvent event) {
        showless.setVisible(false);
        visibility(false);
    }

    void setresultset() throws Exception {
        rs = st.executeQuery(s);
        if (rs.next())
            load();
    }
    
    @FXML
    void ongohome(ActionEvent event) throws Exception{
        App ob=new App();
        ob.openfile("option");
    }
    
    void visibility(boolean trf) {
        name.setVisible(trf);
        lostdate.setVisible(trf);
        location_l.setVisible(trf);
        brandname.setVisible(trf);
        colour.setVisible(trf);
        name_tf.setVisible(trf);
        lostdate_tf.setVisible(trf);
        location_tf.setVisible(trf);
        brandname_tf.setVisible(trf);
        colour_tf.setVisible(trf);
    }

    void load_dbimg_to_img() throws Exception {
        // fteching image from database and converting to image
        InputStream is = rs.getBinaryStream("image");// converting into binary
        OutputStream os = new FileOutputStream(
                new File("C:/Users/User/OneDrive/Desktop/test/test/testpro/src/img.jpeg"));
        byte[] b = new byte[1024];
        int size = 0;
        while ((size = is.read(b)) != -1) {
            os.write(b, 0, size);
        }
        os.close();
        is.close();
    }

    void load() throws Exception {
        File f = new File("C:/Users/User/OneDrive/Desktop/test/test/testpro/src/img.jpeg");
        f.delete();

        load_dbimg_to_img();
        // loading image into rectangle
        Image im = new Image("C:/Users/User/OneDrive/Desktop/test/test/testpro/src/img.jpeg");
        rectangle.setFill(new ImagePattern(im));

        // setting up the feilds
        textarea1.setText(rs.getString("descriptions"));
        name_tf.setText(rs.getString("itemname"));
        lostdate_tf.setText(rs.getString("lostdate"));
        location_tf.setText(rs.getString("location"));
        brandname_tf.setText(rs.getString("brandname"));
        colour_tf.setText(rs.getString("color"));
    }

}
