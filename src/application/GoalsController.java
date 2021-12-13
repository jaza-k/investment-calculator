package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class GoalsController {
	
	private static InvestmentApp app;

	public void linkWithApplication(InvestmentApp app) {
		GoalsController.app = app;
	}

    @FXML
    void getGoalsDashboard(ActionEvent event) {
    	app.goalsDashboardView();
    }

}
