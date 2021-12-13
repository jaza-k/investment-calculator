package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Factory;

public class InputController {
	private static InvestmentApp app;

	public void linkWithApplication(InvestmentApp app) {
		InputController.app = app;
	}

    @FXML
    private Button GoalButton;

    @FXML
    private TextField annualInterestTextfield;

    @FXML
    private TextField currentSavingsTextfield;

    @FXML
    private Button earningsButton;

    @FXML
    private Label header;

    @FXML
    private TextField retirementCashOutAgeTextfield;

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
