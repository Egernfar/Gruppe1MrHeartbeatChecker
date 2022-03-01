import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class JavaFXApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label l = new Label("Hello, JavaFX!");
        Label l2 = new Label("Its a fine day!");
        FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
        flowPane.getChildren().add(l);
        flowPane.getChildren().add(l2);
        Scene scene = new Scene(flowPane,640,480);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
