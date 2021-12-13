package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class EarningsController {
	private static InvestmentApp app;

	public void linkWithApplication(InvestmentApp app) {
		EarningsController.app = app;
	}

    @FXML
    private Button calculateEarningsButton;

    @FXML
    private ChoiceBox<String> compoundPeriodChoice;

    @FXML
    private TextField monthlyContributionAmount;

    @FXML
    void getEarningsDashboard(ActionEvent event) {
    	app.earningsDashboardView();
    }

}
