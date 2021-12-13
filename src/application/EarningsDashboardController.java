package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Factory;

public class EarningsDashboardController {
	private static InvestmentApp app;

	public void linkWithApplication(InvestmentApp app) {
		EarningsDashboardController.app = app;
	}

    @FXML
    private Label amountSaved;

    @FXML
    private Button goBackButton;

    @FXML
    private Label goalAge;

    @FXML
    private LineChart<Number, Number> lineChart;

    @FXML
    private Label userName;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    void goBack(ActionEvent event) {
    	app.earningsInputView();
    }
    
    @FXML
    void initialize() {
    	userName.setText(Factory.getInstance().getName());
    	goalAge.setText("" + Factory.getInstance().getEndingAge());
    	amountSaved.setText("" + Factory.getInstance().createGoals());
    }
}

