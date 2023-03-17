package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.gluonhq.charm.glisten.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SigninController  implements Initializable{
	
	@FXML
    private VBox Vbox;
	
    @FXML
    private Button signInButtom;

    @FXML
    private TextField signInMail;

    @FXML
    private TextField signInPassword;

    @FXML
    private Button signInPasswordForgoten;
    
    private Parent fxml;
    @FXML
    void openHome(ActionEvent event) throws IOException {
    	String mail = signInMail.getText();
    	String password = signInPassword.getText();
    	if(mail.equals("1")&&password.equals("1")) {
    		Vbox.getScene().getWindow().hide();
    		Stage home = new Stage();
			fxml = FXMLLoader.load(getClass().getClassLoader().getResource("interfaces/Home.fxml"));
			Scene scene = new Scene(fxml);
			home.setScene(scene);
			home.show();

    	}

    }

    @FXML
    void passwordRecovery(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
