package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.*;

/**
 * Earnings Controller class, used to control the EarningsView FXML file
 * 
 * @author Richi, Jaza
 *
 */
public class EarningsController {
	// InvestmentApp instance variable to be linked to the InvestmentApp class
	private static InvestmentApp app;
	
	/**
	 * linkWithApplication method links this class to the InvestmentApp class
	 * and sets the <code>app</code> instance variable to the instance of InvestmentApp
	 * @param app the instance of InvestmentApp that <code>app</code> instance variable will be set to
	 */
	public void linkWithApplication(InvestmentApp app) {
		EarningsController.app = app;
	}
	
	//button used to go back to a previous view
    @FXML
    private Button goBackButton;
    
    //button used to go to the next view and save inputed data
    @FXML
    private Button calculateEarningsButton;
    
    //choicebox for the interest compounding choice
    @FXML
    private ChoiceBox<String> compoundPeriodChoice;
    
    //textfield to input monthly contributions
    @FXML
    private TextField monthlyContributionAmount;
    
    /**
     * getEarningsDashboard method sets the values of compound period and monthly contributions
     * to the singleton creator instance and goes to the next view when the button is pressed
     * @param event the event when the <code>calculateEarningsButton</code> is pressed
     */
    @FXML
    void getEarningsDashboard(ActionEvent event) {
    	Factory.getInstance().setMonthlyContributions(Double.parseDouble(monthlyContributionAmount.getText()));
    	Factory.getInstance().setCompoundPeriod(compoundPeriodChoice.getValue());
    	app.earningsDashboardView();
    }
    
    /**
     * initialize method sets the value of the <code>compoundPeriodChoice</code> choicebox when the
     * view for this controller is loaded
     */
    @FXML
    void initialize() {
    	String[] periods = {"Monthly", "Quarterly", "Semi-Annually", "Annually"};
    	compoundPeriodChoice.setItems(FXCollections.observableArrayList(periods));
    }
    
    /**
     * goBack method takes the user to the previous view when the <code>goBackButton</code> button is pressed
     * @param event when the <code>goBackButton</code> is pressed
     */
    @FXML
    void goBack(ActionEvent event) {
    	app.inputView();
    }

}
