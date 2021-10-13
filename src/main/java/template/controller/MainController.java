package template.controller;

import gl.javafx.FxmlPath;
import gl.javafx.control.Dialog;
import gl.javafx.control.ValidationTextField;
import gl.javafx.control.Validator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

@FxmlPath("/fxml/main.fxml")
public class MainController implements Initializable {
    @FXML
    private ValidationTextField textField;
    @FXML
    private Button button;
    
    @FXML
    public void onClickButton() {
        final String text = textField.getText();
        Dialog.confirm("text=" + text);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 半角英字のみ可
        textField.addValidator(Validator.patternOf(Pattern.compile("^[a-zA-Z]+$")));
        
        // テキストの有効状態とボタンの押下可否を連動させる
        button.disableProperty().bind(textField.validProperty().not());
    }
}
