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
    private NumberAxis xAxis = new NumberAxis(0, Creator.getInstance().getEndingAge() - Creator.getInstance().getCurrentAge(), 2);

    @FXML
    private NumberAxis yAxis = new NumberAxis(Creator.getInstance().getStartingAmount(), Creator.getInstance().getGoal(), (int) 0.1 * (Creator.getInstance().getGoal()));

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
    	userName.setText(Creator.getInstance().getName());
    	goalAge.setText("" + Creator.getInstance().getEndingAge());
    	goalSavingsAmount.setText("" + Creator.getInstance().getGoal());
    	monthlyAmountNeeded.setText("" + Creator.getInstance().createGoals());
    	chartHelper();
    }
    
    private void chartHelper() {
    	XYChart.Series<Number, Number> data = new Series<Number, Number>();
    	Creator.getInstance().setMonthlyContributions(Creator.getInstance().createGoals());
    	Creator.getInstance().setCompoundPeriod("Annually");
    	for (int i = 0; i <= Creator.getInstance().getEndingAge() - Creator.getInstance().getCurrentAge(); i+=2) {
    		data.getData().add(new Data<Number, Number>(i, Creator.getInstance().specificYearEarnings(i)));
    	}
    	this.lineChart.getData().add(data);
    }

}
