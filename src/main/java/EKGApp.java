import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
// Application FXML klasse vi arver fra - UI
public class EKGApp extends Application {
// launch() meetode indbygget i Application - vi kalder for at starte UI.
    public static void run(){
        EKGApp.launch();
    }


    @Override
    public void start(Stage stage) throws Exception {
        // Ny instans af FXMLLoader klasse.
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/ekggui.fxml"));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane, 600,600);
        stage.setScene(scene);
        stage.show();
    }
}
