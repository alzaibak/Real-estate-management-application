package com.alzaibak.Real_estate_management_application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class App extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Main.fxml"));
			Scene scene = new Scene(root);
			scene.setFill(Color.TRANSPARENT);
			//scene.getStylesheets().add(getClass().getResource("App.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.show();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
    
    public static void main(String[] args) {
        launch(args);
    }


	

}