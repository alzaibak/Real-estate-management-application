package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.alzaibak.Real_estate_management_application.MySqlConnection;
import com.gluonhq.charm.glisten.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SigninController  implements Initializable{
	Connection cnx;
	public PreparedStatement statement;
	public ResultSet result;
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
    	String sql = "select userName,Password from admin";
    	try {
			statement = cnx.prepareStatement(sql);
	    	result = statement.executeQuery();
	    	if(result.next()) {
	    		if(mail.equals(result.getString("userName"))&&password.equals(result.getString("password"))) {
	        		Vbox.getScene().getWindow().hide();
	        		Stage home = new Stage();
	    			fxml = FXMLLoader.load(getClass().getClassLoader().getResource("interfaces/Home.fxml"));
	    			Scene scene = new Scene(fxml);
	    			home.setScene(scene);
	    			home.show();
	        		System.out.println("You are connected");

	        	}else {
	        		System.out.println("you are not authorized");
	        		Alert alert = new Alert(AlertType.ERROR, "nome de l'utilisateur ou mot de passse incorrect", javafx.scene.control.ButtonType.OK);
	        		 alert.showAndWait();
	    	}
        	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	

    }

    @FXML
    void passwordRecovery(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cnx = MySqlConnection.DBConnection();
		
	}

}
