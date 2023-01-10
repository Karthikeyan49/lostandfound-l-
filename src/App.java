import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class App extends Application{
    
    public Stage primaryStage;
    public static BorderPane board=new BorderPane();
    public HBox bo;  
    public Scene s1;
    @Override
    public void start(Stage stg) throws Exception{

        this.primaryStage=stg;
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("fxpack/login.fxml"));
        bo=loader.load();  
        board.setCenter(bo);
        s1=new Scene(board);
        primaryStage.setTitle("lostandfind");
        primaryStage.setScene(s1);
        primaryStage.show(); 

    } 
    
    public void openfile(String file) throws Exception{

        /*root=FXMLLoader.load(getClass().getResource("welcome.fxml"));*/
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("fxpack/"+file+".fxml")); 
        bo=loader.load();
        board.setCenter(bo);

    }
    public static void main(String[] args) throws SQLException {
        launch(args);
    }
}

