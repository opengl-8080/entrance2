package template;

import gl.javafx.FxWindow;
import gl.javafx.Fxml;
import javafx.application.Application;
import javafx.stage.Stage;
import template.controller.MainController;

public class Main extends Application {
    public static void main(String[] args) {
        launch(Main.class, args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        final Fxml<?, ?> fxml = Fxml.load(MainController.class);
        FxWindow.newWindow(fxml)
                .title("Template")
                .show(primaryStage);
    }
}