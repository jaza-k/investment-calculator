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
import model.Factory;

public class GoalsDashboardController {

	private static InvestmentApp app;

	public void linkWithApplication(InvestmentApp app) {
		GoalsDashboardController.app = app;
	}

	@FXML
    private Button goBackButton;

    @FXML
    private LineChart<Number, Number> lineChart;

    @FXML
    private Label monthlyAmountNeeded;

    @FXML
    private Label userName;

    @FXML
    private NumberAxis xAxis = new NumberAxis(0, Factory.getInstance().getEndingAge() - Factory.getInstance().getCurrentAge(), 2);

    @FXML
    private NumberAxis yAxis = new NumberAxis(Factory.getInstance().getStartingAmount(), Factory.getInstance().createGoals(), 0.1 * (Factory.getInstance().createGoals() - Factory.getInstance().getStartingAmount()));

    @FXML
    private Label goalAge;

    @FXML
    private Label goalSavingsAmount;
    
    @FXML
    void goBack(ActionEvent event) {
    	app.goalsInputView();
    }
    
    @FXML
    void initialize() {
    	userName.setText(Factory.getInstance().getName());
    	goalAge.setText("" + Factory.getInstance().getEndingAge());
    	goalSavingsAmount.setText("" + Factory.getInstance().getGoal());
    	monthlyAmountNeeded.setText("" + Factory.getInstance().createGoals());
    	chartHelper();
    }
    
    private void chartHelper() {
    	XYChart.Series<Number, Number> data = new Series<Number, Number>();
    	for (int i = 0; i <= Factory.getInstance().getEndingAge() - Factory.getInstance().getCurrentAge(); i+=2) {
    		data.getData().add(new Data<Number, Number>(i, Factory.getInstance().specificYearGoal(i)));
    	}
    	this.lineChart.getData().add(data);
    }

}
