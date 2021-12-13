package application;

/**
 * InputController class which loads the second scene of the application
 * 
 * @author Jaza Khan
 * @author Richi Patel
 *
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;

public class InputController {
	
	/** InvestmentApp instance variable to link files */
	static InvestmentApp app;
	
	/**
	 * linkWithApplication method links this class to the InvestmentApp class
	 * and sets the <code>app</code> instance variable to the instance of InvestmentApp
	 * @param app the instance of InvestmentApp that <code>app</code> instance variable will be set to
	 */
	public void linkWithApplication(InvestmentApp app) {
		InputController.app = app;
	}
	
	//button used to go to a previous view
    @FXML
    private Button goBackButton;
    
    //Textfield to input the interest rate
    @FXML
    private TextField annualInterestTextfield;
    
    //button used to save the input and go to the earnings view
    @FXML
    private Button pickedEarningsButton;
    
    //header label
    @FXML
    private Label header;
    
    //Textfield to input the investment cashout age
    @FXML
    private TextField retirementCashOutAgeTextfield;

    //button used to save the input and go to the goals view
    @FXML
    private Button pickedGoalsButton;
    
    //Textfield to input the current amount invested
    @FXML
    private TextField currentSavingsTextfield;
    
    /**
     *  goBack method takes the user to the previous view when the <code>goBackButton</code> button is pressed
     * @param event when the <code>goBackButton</code> is pressed
     */
    @FXML
    void goBack(ActionEvent event) {
    	app.setupView();
    }
    
    /**
     * loadEarningsView method sets the input to the singleton instance of
     * the creator class and goes to the earnings view
     * @param event event when the <code>pickedEarningsButton</code> is pressed
     */
    @FXML
    void loadEarningsView(ActionEvent event) {
    	setCreatorVariables();
    	app.earningsInputView();
    }
    
    /**
     * loadEarningsView method sets the input to the singleton instance of
     * the creator class and goes to the earnings view
     * @param event event when the <code>pickedGoalsButton</code> is pressed
     */
    @FXML
    void loadGoalView(ActionEvent event) {
    	setCreatorVariables();
    	app.goalsInputView();
    }
    
    /**
     * setCreatorVariables, helper method to set the input values to the singleton instance of the creator class
     */
    void setCreatorVariables() {
    	Creator.getInstance().setStartingAmount(Double.parseDouble(currentSavingsTextfield.getText()));
    	Creator.getInstance().setEndingAge(Integer.parseInt(retirementCashOutAgeTextfield.getText()));
    	Creator.getInstance().setInterest(Double.parseDouble(annualInterestTextfield.getText()));
    }

}