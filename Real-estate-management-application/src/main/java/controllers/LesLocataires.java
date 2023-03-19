package controllers;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.alzaibak.Real_estate_management_application.MySqlConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import models.Locataires;

public class LesLocataires implements Initializable{
	Connection cnx;
	public PreparedStatement statement;
	public ResultSet result;

    @FXML
    private TextField LastnameText;

    @FXML
    private TableView<Locataires> allUsersTable;
    
    @FXML
    private TableColumn<Locataires, Integer> idColumn;
    
    @FXML
    private TableColumn<Locataires, Date> birthdayColumn;

    @FXML
    private TextField birthdayText;

    @FXML
    private TableColumn<Locataires, String> firstnameColumn;

    @FXML
    private TextField firstnameText;

    @FXML
    private TableColumn<Locataires, String> lastnameColumn;

    @FXML
    private TableColumn<Locataires, Integer> phoneNumberColumn;

    @FXML
    private TextField phoneNumberText;

    @FXML
    private TableColumn<Locataires, Integer> soldeColumn;

    @FXML
    private TextField upToDateText;

    @FXML
    private TableColumn<Locataires, Boolean> upToDdateColumn;

    @FXML
    private TextField userId;

    @FXML
    private TextField userSolde;
    
    
    //Searching existing user
    @FXML
    void searchButton(MouseEvent event) {
    	String sql = "select * from users where firstName = '"+firstnameText.getText()+"' && lastName = '"+LastnameText.getText()+"'";
    	try {
    		statement = cnx.prepareStatement(sql);
    		result = statement.executeQuery();
    		if(result.next()) {
    			userId.setText(result.getString("idUser"));
    			upToDateText.setText(result.getString("upToDatePayements"));
    			userSolde.setText(result.getString("userSold"));
    			phoneNumberText.setText(result.getString("phoneNumber"));
    			Date date = result.getDate("birthDay");
    			birthdayText.setText((date).toString());
    		}else {
    			Alert alert = new Alert(AlertType.ERROR, "Aucun locataire de nom: '"+firstnameText.getText()+"' et prénom:'"+LastnameText.getText()+"' est trouvé", javafx.scene.control.ButtonType.OK );
    			alert.showAndWait();
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void userAdding(MouseEvent event) {

    }

    @FXML
    void userDeleting(MouseEvent event) {

    }

    @FXML
    void userModifing(MouseEvent event) {

    }
    
    //fetching all users information
    public ObservableList<Locataires> data = FXCollections.observableArrayList();
    public void ShowLocataires() {
    	String sql = "select * from users"; 
    	try {
    		statement = cnx.prepareStatement(sql);
    		result = statement.executeQuery();
    		while(result.next()) {
    			data.add(new Locataires (result.getInt("idUser"), result.getString("firstName"), result.getString("lastName"), result.getDate("birthDay"), result.getInt("phoneNumber"), result.getString("upToDatePayements"), result.getInt("userSold")));
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	idColumn.setCellValueFactory(new PropertyValueFactory<Locataires,Integer>("id"));
    	firstnameColumn.setCellValueFactory(new PropertyValueFactory<Locataires,String>("firstN"));
    	lastnameColumn.setCellValueFactory(new PropertyValueFactory<Locataires,String>("lastN"));
    	birthdayColumn.setCellValueFactory(new PropertyValueFactory<Locataires,Date>("BirthD"));
    	phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Locataires,Integer>("phoneN"));
    	upToDdateColumn.setCellValueFactory(new PropertyValueFactory<Locataires,Boolean>("upToDate"));
    	soldeColumn.setCellValueFactory(new PropertyValueFactory<Locataires,Integer>("sold"));
    	allUsersTable.setItems(data);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cnx = MySqlConnection.DBConnection();
		ShowLocataires();
		
	}

}
