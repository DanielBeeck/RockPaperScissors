package GUI;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CloseStageExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // create a label to display a message
        Label label = new Label("Closing in 3 seconds...");

        // create a stack pane and add the label to it
        StackPane root = new StackPane();
        root.getChildren().add(label);

        // create a scene and set it on the stage
        Scene scene = new Scene(root, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();

        // create a task to close the stage after 3 seconds
        Task<Void> closeTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(3000);
                return null;
            }
        };

        // set the task to run when the application is idle
        closeTask.setOnSucceeded(event -> primaryStage.close());
        new Thread(closeTask).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
