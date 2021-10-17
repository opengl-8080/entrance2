package entrance;

import entrance.controller.MainController;
import gl.javafx.FxWindow;
import gl.javafx.Fxml;
import javafx.application.Application;
import javafx.stage.Stage;

public class FxMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        final Fxml<?, ?> fxml = Fxml.load(MainController.class);
        FxWindow.newWindow(fxml)
                .title("Entrance")
                .show(primaryStage);
    }
}
