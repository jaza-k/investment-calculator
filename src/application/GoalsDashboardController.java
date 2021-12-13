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

/**
 * GoalsDashboardController class, used to control the GoalsDashboard FXML file
 * @author Richi, Jaza
 *
 */
public class GoalsDashboardController {
	// InvestmentApp instance variable to be linked to the InvestmentApp class
	private static InvestmentApp app;

	/**
	 * linkWithApplication method links this class to the InvestmentApp class
	 * and sets the <code>app</code> instance variable to the instance of InvestmentApp
	 * @param app the instance of InvestmentApp that <code>app</code> instance variable will be set to
	 */
	public void linkWithApplication(InvestmentApp app) {
		GoalsDashboardController.app = app;
	}
	
	//button that goes to the previous view
	@FXML
    private Button goBackButton;
	
	//chart that displays investment earnings over a time period
    @FXML
    private LineChart<Number, Number> lineChart;

    //label indicating the monthly contribution needed to hit the goal
    @FXML
    private Label monthlyAmountNeeded;

    //label displaying the users name
    @FXML
    private Label userName;

    //x axis of the line chart
    @FXML
    private NumberAxis xAxis;

    //y axis of the line chart
    @FXML
    private NumberAxis yAxis;

    //label showing the age of the user at cashout
    @FXML
    private Label goalAge;

    //label showing the savings goal
    @FXML
    private Label goalSavingsAmount;
    
    /**
     * goBack method takes the user to the previous view when the <code>goBackButton</code> button is pressed
     * @param event when the <code>goBackButton</code> is pressed
     */
    @FXML
    void goBack(ActionEvent event) {
    	app.goalsInputView();
    }
    
    /**
     * initialize method is run when the FXML file for this controller is loaded
     * this method sets the labels to their required values and calls
     * chartHelper method to create the chart
     */
    @FXML
    void initialize() {
    	userName.setText(Creator.getInstance().getName());
    	goalAge.setText("" + Creator.getInstance().getEndingAge());
    	goalSavingsAmount.setText("" + Creator.getInstance().getGoal());
    	monthlyAmountNeeded.setText("" + Creator.getInstance().createGoals());
    	chartHelper();
    }
    
    /**
     * chartHelper method used to create the line chart and display the data
     * 
     * Citation: some references used from this website
     * 
     * https://www.tutorialspoint.com/javafx/line_chart.htm
     * 
     */
    private void chartHelper() {
    	XYChart.Series<Number, Number> data = new Series<Number, Number>();
    	//set monthly contributions and compound period to be set 
    	Creator.getInstance().setMonthlyContributions(Creator.getInstance().createGoals());
    	Creator.getInstance().setCompoundPeriod("Annually");
    	//put all the data points into the data variable
    	for (int i = 0; i <= Creator.getInstance().getEndingAge() - Creator.getInstance().getCurrentAge(); i+=2) {
    		data.getData().add(new Data<Number, Number>(i, Creator.getInstance().specificYearEarnings(i)));
    	}
    	//set all the data on the line chart
    	this.lineChart.getData().add(data);
    	data.getNode().setStyle("-fx-stroke: #51cbff; ");
    }
}
