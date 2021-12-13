package application;

/**
 * Investment Tracker app which allows user to input information and calculate financial estimates
 * @author Richi Patel
 * @author Jaza Khan
 *
 */
	
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
	
	/** Stage instance variable for the class*/
	Stage primaryStage;
	
	
	/** 
	 *  setupView() method
	 *  Loads the SetupController class and sets the <code>primaryStage</code>
	 *  instance variable. Links this instance of InvestmentApp with the SetupController
	 *  Displays the first view on application startup.
	 *  Precondition: none
	 *  Postcondition: SetupView will be loaded, primaryStage will be set, and an instance of InvestmentApp
	 *  will be linked to the SetupController.
	 */
	void setupView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			// load the SetupView FXML file and its controller
			Parent setupView = (Parent) loader.load(new FileInputStream("src/view/SetupView.fxml"));
			SetupController setupController = loader.getController();
			// link the application to controller
			setupController.linkWithApplication(this);
			scene = new Scene(setupView,475,225);
			// use the primaryStage instance variable to display scene
			primaryStage.setScene(scene);
			primaryStage.show();		
		} 
		// exception handling
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/** 
	 *  inputView() method
	 *  Loads the InputController class and sets the <code>primaryStage</code>
	 *  instance variable. Links this instance of InvestmentApp with the InputController
	 *  Displays the second view of application, through ActionEvent on first view.
	 *  Precondition: none
	 *  Postcondition: InputView will be loaded, primaryStage will be set, and an instance of InvestmentApp
	 *  will be linked to the InputController
	 */
	void inputView() {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			Scene scene;
			// load the InputView FXML file and its controller
			root = (BorderPane)loader.load(new FileInputStream("src/view/InputView.fxml"));
			InputController inputController = loader.getController();
			// link the application to controller
			inputController.linkWithApplication(this);
	        scene = new Scene(root, 700,520);
	        // use the primaryStage instance variable to display scene
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} 
		// exception handling
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 *  earningsInputView() method
	 *  Loads the EarningsController class and sets the <code>primaryStage</code>
	 *  instance variable. Links this instance of InvestmentApp with the EarningsController
	 *  Only displays if user has selected the earnings button from previous view.
	 *  Precondition: none
	 *  Postcondition: EarningsView will be loaded, primaryStage will be set, and an instance of InvestmentApp
	 *  will be linked to the EarningsController.
	 */
	void earningsInputView() {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			Scene scene;
			// load the EarningsView FXML file and its controller
			root = (BorderPane)loader.load(new FileInputStream("src/view/EarningsView.fxml"));
			EarningsController earningsController = loader.getController();
			// link application to controller
			earningsController.linkWithApplication(this);
	        scene = new Scene(root, 530,250);
	        // use the primaryStage instance variable to display scene
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} 
		// exception handling
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 *  goalsInputView() method
	 *  Loads the GoalsController class and sets the <code>primaryStage</code>
	 *  instance variable. Links this instance of InvestmentApp with the GoalsController
	 *  Only displays if the user has selected the goals button from previous view.
	 *  Precondition: none
	 *  Postcondition: GoalsView will be loaded, primaryStage will be set, and an instance of InvestmentApp
	 *  will be linked to the GoalsController.
	 */
	void goalsInputView() {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			Scene scene;
			// load the GoalsView FXML file and its controller
			root = (BorderPane)loader.load(new FileInputStream("src/view/GoalsView.fxml"));
			GoalsController goalsController = loader.getController();
			// link application to controller
			goalsController.linkWithApplication(this);
	        scene = new Scene(root, 550,190);
	        // use the primaryStage instance variable to display scene
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} 
		// exception handling
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 *  earningsDashboardView() method
	 *  Loads the EarningsDashboardController class and sets the <code>primaryStage</code>
	 *  instance variable. Links this instance of InvestmentApp with the EarningsDashboardController
	 *  Precondition: none
	 *  Postcondition: EarningsDashboardView will be loaded, primaryStage will be set, and an instance of InvestmentApp
	 *  will be linked to the EarningsDashboardController.
	 *  */
	void earningsDashboardView() {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			Scene scene;
			// load the EarningsDashboardView FXML file and its controller
			root = (BorderPane)loader.load(new FileInputStream("src/view/EarningsDashboardView.fxml"));
			EarningsDashboardController earningsDashboardController = loader.getController();
			// link application to controller
			earningsDashboardController.linkWithApplication(this);
	        scene = new Scene(root, 550,550);
	        // use the primaryStage instance variable to display scene
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} 
		// exception handling
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 *  goalsDashboardView() method
	 *  Loads the GoalsDashboardController class and sets the <code>primaryStage</code>
	 *  instance variable. Links this instance of InvestmentApp with the GoalsDashboardController
	 *  Precondition: none
	 *  Postcondition: GoalsDashboardView will be loaded, primaryStage will be set, and an instance of InvestmentApp
	 *  will be linked to the GoalsDashboardController.
	 */
	void goalsDashboardView() {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			Scene scene;
			// loads the GoalsDashboardView FXML file and its controller
			root = (BorderPane)loader.load(new FileInputStream("src/view/GoalsDashboardView.fxml"));
			GoalsDashboardController goalsDashboardController = loader.getController();
			// links application to controller
			goalsDashboardController.linkWithApplication(this);
	        scene = new Scene(root, 550,550);
	        // use the primaryStage instance variable to display scene
	        primaryStage.setScene(scene);
	        primaryStage.show();
		}
		// exception handling
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * start() method
	 * Sets the <code>primaryStage</code> instance variable to the parameter
	 * Calls setupView method in order to start the application
	 * Precondition: primaryStage must be of type Stage
	 * Postcondition: <code>primaryStage</code> instance variable will be set, and setupView will be called
	 * 
	 * @param primaryStage the Stage that the instance variable should be set to
	 */
	@Override
	public void start(Stage primaryStage) {
		// set the primaryStage instance variable
		this.primaryStage = primaryStage;
		setupView();
	}
	
	
	/**
	 * main() method
	 * Launches the application
	 * @param args String array
	 */
	public static void main(String[] args) {
		launch(args);
	}
}