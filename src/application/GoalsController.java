package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.*;

public class GoalsController {
	
	private static InvestmentApp app;

	public void linkWithApplication(InvestmentApp app) {
		GoalsController.app = app;
	}

    @FXML
    private TextField savingsGoalAmount;

    @FXML
    private Button calculateGoalsButton;
    
    @FXML
    private Button goBackButton;

    @FXML
    void getGoalsDashboard(ActionEvent event) {
    	Factory.getInstance().setGoal(Double.parseDouble(savingsGoalAmount.getText()));
    	app.goalsDashboardView();
    }

    @FXML
    void goBack(ActionEvent event) {
    	app.inputView();
    }

}
