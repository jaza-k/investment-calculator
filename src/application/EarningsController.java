package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.*;

public class EarningsController {
	private static InvestmentApp app;

	public void linkWithApplication(InvestmentApp app) {
		EarningsController.app = app;
	}

    @FXML
    private Button goBackButton;
    
    @FXML
    private Button calculateEarningsButton;

    @FXML
    private ChoiceBox<String> compoundPeriodChoice;

    @FXML
    private TextField monthlyContributionAmount;

    @FXML
    void getEarningsDashboard(ActionEvent event) {
    	Factory.getInstance().setMonthlyContributions(Double.parseDouble(monthlyContributionAmount.getText()));
    	Factory.getInstance().setCompoundPeriod(compoundPeriodChoice.getValue());
    	app.earningsDashboardView();
    }
    
    @FXML
    void initialize() {
    	String[] periods = {"Monthly", "Quarterly", "Semi-Annually", "Annually"};
    	compoundPeriodChoice.setItems(FXCollections.observableArrayList(periods));
    }
    
    @FXML
    void goBack(ActionEvent event) {
    	app.inputView();
    }

}
