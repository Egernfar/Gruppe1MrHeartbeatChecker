import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EKGApp extends Application {

    public static void run(){
        EKGApp.launch();
    }


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/ekggui.fxml"));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane, 600,600);
        stage.setScene(scene);
        stage.show();
    }
}
