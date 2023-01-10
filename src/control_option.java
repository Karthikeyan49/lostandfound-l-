import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class control_option {

   @FXML
   private Button feedback;
   @FXML
   private Button listfound;
   @FXML
   private Button listlost;
   @FXML
   private Button registerfound;
   @FXML
   private Button registerlost;

   App ob = new App();
   @FXML
   public void initialize(){
   }
   
   @FXML
   void onfeedback(ActionEvent event) throws Exception {
      ob.openfile("feedback");
   }

   @FXML
   void onlistfound(ActionEvent event) throws Exception {
      ob.openfile("founditempage");
   }

   @FXML
   void onlistlost(ActionEvent event) throws Exception {
      ob.openfile("lostitempage");
   }

   @FXML
   void onregisterfound(ActionEvent event) throws Exception {
      ob.openfile("founditem");
   }
   @FXML
   void logout(ActionEvent  event) throws Exception {
      ob.openfile("login");
   }

   @FXML
   void onregisterlost(ActionEvent event) throws Exception {
      ob.openfile("lostitem");
   }

   @FXML
   void onclickveiwhistory() throws Exception {
      ob.openfile("userhistorylost");
   }
}