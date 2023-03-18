package controllers;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.alzaibak.Real_estate_management_application.MySqlConnection;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AccueilController implements Initializable {
	Connection cnx;
	public PreparedStatement statement;
	public ResultSet result;
    @FXML
    private TextField adresse;

    @FXML
    private TextField charges;

    @FXML
    private ImageView image;

    @FXML
    private Label label;

    @FXML
    private TextField region;

    @FXML
    private TextField rent;

    @FXML
    void showNext(MouseEvent event) {
    	
    }

    @FXML
    void showPrevious(MouseEvent event) {

    }
    void disponibilityCheck() {
    	String sql = "select * from appartements where (idUser=Null)";
    	int i =0;
    	try {
    		statement = cnx.prepareStatement(sql);
    		result = statement.executeQuery();
    		if(result.next()) {
    			i = result.getInt(i);
    		}
    		label.setText(Integer.toString(i));
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
   

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cnx = MySqlConnection.DBConnection();
	}

}
