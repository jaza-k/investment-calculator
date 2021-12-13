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

	public void linkWithApplication(InvestmentApp app) {
		InputController.app = app;
	}

    @FXML
    private Button goBackButton;

    @FXML
    private TextField annualInterestTextfield;

    @FXML
    private Button pickedEarningsButton;

    @FXML
    private Label header;

    @FXML
    private TextField retirementCashOutAgeTextfield;

    @FXML
    private Button pickedGoalsButton;

    @FXML
    private TextField currentSavingsTextfield;
    
    @FXML
    void goBack(ActionEvent event) {
    	app.setupView();
    }
    
    @FXML
    void loadEarningsView(ActionEvent event) {
    	setFactoryVariables();
    	app.earningsInputView();
    }

    @FXML
    void loadGoalView(ActionEvent event) {
    	setFactoryVariables();
    	app.goalsInputView();
    }
    
    
    void setFactoryVariables() {
    	Factory.getInstance().setStartingAmount(Double.parseDouble(currentSavingsTextfield.getText()));
    	Factory.getInstance().setEndingAge(Integer.parseInt(retirementCashOutAgeTextfield.getText()));
    	Factory.getInstance().setInterest(Double.parseDouble(annualInterestTextfield.getText()));
    }

}