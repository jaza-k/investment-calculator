package application;

/**
 * EarningsDashboardController class, used to control the EarningsDashboardView FXML file
 * 
 * @author Richi, Jaza
 *
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Creator;

public class EarningsDashboardController {
	
	/** InvestmentApp instance variable to link files */
	private static InvestmentApp app;

	/** 
     * linkWithApplication() method
     * Method which links the controller file to application class
     * 
     * @param an instance of InvestmentApp class
     */
	public void linkWithApplication(InvestmentApp app) {
		EarningsDashboardController.app = app;
	}

	/** instance variables with IDs */
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

    /**
     * goBack method takes the user to the previous view when the <code>goBackButton</code> button is pressed
     * @param event when the <code>goBackButton</code> is pressed
     */
    @FXML
    void goBack(ActionEvent event) {
    	app.earningsInputView();
    }
    
    /** initialize() method
     *	Sets the text labels so that the correct information is displayed in the view
     *	Calls private helper method to create chart visualization
     */
    @FXML
    void initialize() {
    	userName.setText(Creator.getInstance().getName());
    	goalAge.setText("" + Creator.getInstance().getEndingAge());
    	amountSaved.setText("" + Creator.getInstance().createEarnings());
    	chartHelper();
<<<<<<< HEAD
    }
    
    /** chartHelper() method
     *	Private helper method which populates a LineGraph and displays the
     *	user's investment over time
     *
     *	Some references taken from: https://www.tutorialspoint.com/javafx/line_chart.htm
     */
    private void chartHelper() {
    	XYChart.Series<Number, Number> data = new Series<Number, Number>();
    	for (int i = 0; i <= Creator.getInstance().getEndingAge() - Creator.getInstance().getCurrentAge(); i+=2) {
    		data.getData().add(new Data<Number, Number>(i, Creator.getInstance().specificYearEarnings(i)));
    	}
    	this.lineChart.getData().add(data);
    	data.getNode().setStyle("-fx-stroke: #51cbff; ");
=======
>>>>>>> 6256afbed6084e29ba8e795b3e03b355fc15a8b4
    }
    
    private void chartHelper() {
    	XYChart.Series<Number, Number> data = new Series<Number, Number>();
    	for (int i = 0; i <= Creator.getInstance().getEndingAge() - Creator.getInstance().getCurrentAge(); i+=2) {
    		data.getData().add(new Data<Number, Number>(i, Creator.getInstance().specificYearEarnings(i)));
    	}
    	this.lineChart.getData().add(data);
    }
}