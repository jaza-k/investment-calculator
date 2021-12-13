package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class InvestmentApp extends Application {
	Stage primaryStage;
	
	private void setupView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			Parent setupView = (Parent) loader.load(new FileInputStream("src/view/SetupView.fxml"));
			SetupController setupController = loader.getController();
			setupController.linkWithApplication(this);
			scene = new Scene(setupView,500,200);
			primaryStage.setScene(scene);
			primaryStage.show();		
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	void inputView() {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			Scene scene;
			root = (BorderPane)loader.load(new FileInputStream("src/view/InputView.fxml"));
	        scene = new Scene(root, 700,520);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void earningsView() {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			Scene scene;
			root = (BorderPane)loader.load(new FileInputStream("src/view/EarningsView.fxml"));
	        scene = new Scene(root, 500,500);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void goalsView() {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			Scene scene;
			root = (BorderPane)loader.load(new FileInputStream("src/view/GoalsView.fxml"));
	        scene = new Scene(root, 500,500);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		setupView();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}