package controllers;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.alzaibak.Real_estate_management_application.MySqlConnection;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


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
     	String appartID = label.getText();
        int number = Integer.parseInt(appartID);
    	String sql3 = "select * from appartements where idUser IS NULL && idAppartement  > '"+number+"'";
    	int i =0;
    	int loyer;
    	int charge;
    	byte byteImg[];
    	Blob blob;
    	try {
    		statement = cnx.prepareStatement(sql3);
    		result = statement.executeQuery();
    		if(result.next()) {
    			i = result.getInt(1);
        		label.setText(Integer.toString(i));
        		loyer = result.getInt("loyer");
        		rent.setText(Integer.toString(loyer));
        		charge = result.getInt("prix des charges");
        		charges.setText(Integer.toString(charge));
        		adresse.setText(result.getString("Adresse"));
        		region.setText(result.getString("Ville"));
        		blob = result.getBlob("image");
        		byteImg = blob.getBytes(1, (int) blob.length());
        		Image img = new Image(new ByteArrayInputStream(byteImg), image.getFitWidth(),image.getFitHeight(),true,true);
        		image.setImage(img);
        		
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void showPrevious(MouseEvent event) {
    	String appartID = label.getText();
        int number = Integer.parseInt(appartID);
    	String sql2 = "select * from appartements where idUser IS NULL && idAppartement  < '"+number+"'";
    	int i =0;
    	int loyer;
    	int charge;
    	byte byteImg[];
    	Blob blob;
    	try {
    		statement = cnx.prepareStatement(sql2);
    		result = statement.executeQuery();
    		if(result.next()) {
    			i = result.getInt(1);
        		label.setText(Integer.toString(i));
        		loyer = result.getInt("loyer");
        		rent.setText(Integer.toString(loyer));
        		charge = result.getInt("prix des charges");
        		charges.setText(Integer.toString(charge));
        		adresse.setText(result.getString("Adresse"));
        		region.setText(result.getString("Ville"));
        		blob = result.getBlob("image");
        		byteImg = blob.getBytes(1, (int) blob.length());
        		Image img = new Image(new ByteArrayInputStream(byteImg), image.getFitWidth(),image.getFitHeight(),true,true);
        		image.setImage(img);
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    void disponibilityCheck() {
    	String sql = "select * from appartements where idUser IS NULL";
    	int i =0;
    	int loyer;
    	int charge;
    	byte byteImg[];
    	Blob blob;
    	try {
    		statement = cnx.prepareStatement(sql);
    		result = statement.executeQuery();
    		if(result.next()) {
    			i = result.getInt(1);
        		label.setText(Integer.toString(i));
        		loyer = result.getInt("loyer");
        		rent.setText(Integer.toString(loyer));
        		charge = result.getInt("prix des charges");
        		charges.setText(Integer.toString(charge));
        		adresse.setText(result.getString("Adresse"));
        		region.setText(result.getString("Ville"));
        		blob = result.getBlob("image");
        		byteImg = blob.getBytes(1, (int) blob.length());
        		Image img = new Image(new ByteArrayInputStream(byteImg), image.getFitWidth(),image.getFitHeight(),true,true);
        		image.setImage(img);
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cnx = MySqlConnection.DBConnection();
		disponibilityCheck();
	}

}
