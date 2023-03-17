package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class MainController implements Initializable {
    @FXML
    private Button connectionButton;

    @FXML
    private Button signUpButton;

    @FXML
    private VBox vBox;

    @FXML
    void openSignUp() {
    	TranslateTransition t = new TranslateTransition(Duration.seconds(1), vBox);
		t.setToX(5);
		t.play();
		t.setOnFinished(e->{
			try {
				fxml = FXMLLoader.load(getClass().getClassLoader().getResource("interfaces/SignUp.fxml"));
				vBox.getChildren().removeAll();
				vBox.getChildren().setAll(fxml);
			}catch (Exception e1){
				e1.printStackTrace();
			}
		});
		
    }
    private Parent fxml;
    @FXML
    void openSignin() {
    	TranslateTransition t = new TranslateTransition(Duration.seconds(1), vBox);
		t.setToX(270);
		t.play();
		t.setOnFinished(e->{
			try {
				fxml = FXMLLoader.load(getClass().getClassLoader().getResource("interfaces/Signin.fxml"));
				vBox.getChildren().removeAll();
				vBox.getChildren().setAll(fxml);
			}catch (Exception e1){
				e1.printStackTrace();
			}
		});
		

    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TranslateTransition t = new TranslateTransition(Duration.seconds(1), vBox);
		t.setToX(270);
		t.play();
	}

}
