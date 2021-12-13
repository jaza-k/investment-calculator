package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.*;

/**
 * GoalsController class, used to control the GoalsView FXML file
 * @author Richi, Jaza
 *
 */
public class GoalsController {
	// InvestmentApp instance variable to be linked to the InvestmentApp class
	private static InvestmentApp app;
	
	/**
	 * linkWithApplication method links this class to the InvestmentApp class
	 * and sets the <code>app</code> instance variable to the instance of InvestmentApp
	 * @param app the instance of InvestmentApp that <code>app</code> instance variable will be set to
	 */
	public void linkWithApplication(InvestmentApp app) {
		GoalsController.app = app;
	}
	
	//TextField to input the goal amount to save for
    @FXML
    private TextField savingsGoalAmount;
    
    //button used to go to the next view and save inputed data
    @FXML
    private Button calculateGoalsButton;
    
    //button used to go back to a previous view
    @FXML
    private Button goBackButton;
    
    /**
     * getGoalsDashboard method sets the value of the <code>savingsGoalAmount</code> in the
     * creator class and goes to the next view when the <code>calculateGoalsButton</code> button is pressed
     * @param event when the <code>calculateGoalsButton</code> is pressed
     */
    @FXML
    void getGoalsDashboard(ActionEvent event) {
    	Factory.getInstance().setGoal(Double.parseDouble(savingsGoalAmount.getText()));
    	app.goalsDashboardView();
    }
    
    /**
     * goBack method takes the user to the previous view when the <code>goBackButton</code> button is pressed
     * @param event when the <code>goBackButton</code> is pressed
     */
    @FXML
    void goBack(ActionEvent event) {
    	app.inputView();
    }
}
