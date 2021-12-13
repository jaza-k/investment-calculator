package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GoalsDashboardController {

	private static InvestmentApp app;

	public void linkWithApplication(InvestmentApp app) {
		GoalsDashboardController.app = app;
	}

  @FXML
    private Button goBackButton;

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private Label monthlyAmountNeeded;

    @FXML
    private Label userName;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    void goBack(ActionEvent event) {

    }

}
