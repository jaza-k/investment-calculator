package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;

public class InputController {
	
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
    	Factory.getInstance().setStartingAmount(Double.parseDouble(currentSavingsTextfield.getText()));
    	Factory.getInstance().setEndingAge(Integer.parseInt(retirementCashOutAgeTextfield.getText()));
    	Factory.getInstance().setInterest(Double.parseDouble(annualInterestTextfield.getText()));
    	app.earningsInputView();
    }

    @FXML
    void loadGoalView(ActionEvent event) {
    	Factory.getInstance().setStartingAmount(Double.parseDouble(currentSavingsTextfield.getText()));
    	Factory.getInstance().setEndingAge(Integer.parseInt(retirementCashOutAgeTextfield.getText()));
    	Factory.getInstance().setInterest(Double.parseDouble(annualInterestTextfield.getText()));
    	app.goalsInputView();
    }

}