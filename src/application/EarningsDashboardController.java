package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Creator;

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
    	userName.setText(Creator.getInstance().getName());
    	goalAge.setText("" + Creator.getInstance().getEndingAge());
    	amountSaved.setText("" + Creator.getInstance().createEarnings());
    	chartHelper();
    }
    
    private void chartHelper() {
    	XYChart.Series<Number, Number> data = new Series<Number, Number>();
    	for (int i = 0; i <= Creator.getInstance().getEndingAge() - Creator.getInstance().getCurrentAge(); i+=2) {
    		data.getData().add(new Data<Number, Number>(i, Creator.getInstance().specificYearEarnings(i)));
    	}
    	this.lineChart.getData().add(data);
    }
}