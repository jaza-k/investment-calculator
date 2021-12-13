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
	
	void setupView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			Parent setupView = (Parent) loader.load(new FileInputStream("src/view/SetupView.fxml"));
			SetupController setupController = loader.getController();
			setupController.linkWithApplication(this);
			scene = new Scene(setupView,475,225);
			primaryStage.setScene(scene);
			primaryStage.show();		
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();SetupController setupController = loader.getController();
			setupController.linkWithApplication(this);
		}
	}

	void inputView() {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			Scene scene;
			root = (BorderPane)loader.load(new FileInputStream("src/view/InputView.fxml"));
			InputController inputController = loader.getController();
			inputController.linkWithApplication(this);
	        scene = new Scene(root, 700,520);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void earningsInputView() {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			Scene scene;
			root = (BorderPane)loader.load(new FileInputStream("src/view/EarningsView.fxml"));
			EarningsController earningsController = loader.getController();
			earningsController.linkWithApplication(this);
	        scene = new Scene(root, 530,215);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void goalsInputView() {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			Scene scene;
			root = (BorderPane)loader.load(new FileInputStream("src/view/GoalsView.fxml"));
			GoalsController goalsController = loader.getController();
			goalsController.linkWithApplication(this);
	        scene = new Scene(root, 550,190);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void earningsDashboardView() {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			Scene scene;
			root = (BorderPane)loader.load(new FileInputStream("src/view/EarningsDashboardView.fxml"));
			EarningsDashboardController earningsDashboardController = loader.getController();
			earningsDashboardController.linkWithApplication(this);
	        scene = new Scene(root, 550,550);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void goalsDashboardView() {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			Scene scene;
			root = (BorderPane)loader.load(new FileInputStream("src/view/GoalsDashboardView.fxml"));
			GoalsDashboardController goalsDashboardController = loader.getController();
			goalsDashboardController.linkWithApplication(this);
	        scene = new Scene(root, 550,550);
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