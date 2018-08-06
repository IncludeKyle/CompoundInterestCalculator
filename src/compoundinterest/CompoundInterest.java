/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compoundinterest;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableDoubleValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.paint.Color;

/**
 * @author Kyle Blaha : 7-16-18
 */

public class CompoundInterest extends Application{
    
    double sceneWidth, sceneHeight;
    ObservableDoubleValue sceneWidthProp, sceneHeightProp;
    boolean retireBool = true;
    
    double retireAge = 0.0, currentAge = 0.0, customYears = 0.0;
    double initialInvest = 0.0, annualAdd = 0.0, assumeInt = 0.0;
    double moneySaved = 0.0, investReturn = 0.0, grandTotal = 0.0;
    
    double total, invested, earned;
    
    // Pass in the dimensions
    Gui gui = new Gui(sceneWidth, sceneHeight, sceneWidthProp, sceneHeightProp);
    
    Control mgmt = new Control();
    
    // Official double rounding method from StackOverflow.com
    public static double round(double d, int decimalPlace)
    {
        System.out.println("Before rounding method: " + d);
        BigDecimal bd = new BigDecimal(d);
        bd = bd.setScale(decimalPlace, RoundingMode.HALF_UP);
        System.out.println("After rounding method: " + bd);
        return bd.doubleValue();
    }
    
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        
        // Create the main window of the application, 
        // set the dimensions and title
        Scene scene = new Scene(root, 900, 260, Color.BLACK);
        primaryStage.setTitle("Compounding Interest Calculator");
        primaryStage.setScene(scene);
        
        // Set up the dimensions to pass into the Gui constructor
        sceneWidth = scene.getWidth();
        sceneHeight = scene.getHeight();
        sceneWidthProp = scene.widthProperty();
        sceneHeightProp = scene.heightProperty();
        
        // Add background and vertical box pane of 3x other panes
        //root.getChildren().add(gui.addBackground());
        root.getChildren().add(gui.buildAllPanes());
        
        // Set up radio button action events
        gui.retireRB.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e)
            {
                // Toggle retireBool to true
                retireBool = true;    
                
                // Make the top row visible to the user
                gui.currentAgeTxt.setVisible(true);
                gui.retireAgeTxt.setVisible(true);
                gui.currentAgeField.setVisible(true);
                gui.retireAgeField.setVisible(true);
                // Turn the bottom row invisible
                gui.customYearsTxt.setVisible(false);
                gui.customYearsField.setVisible(false);
                
                gui.initialInv.setVisible(true);
                gui.annualAdd.setVisible(true);
                gui.assumedInt.setVisible(true);
                gui.assumedInt.setVisible(true);
                gui.getInv.setVisible(true);
                gui.getAdd.setVisible(true);
                gui.getInt.setVisible(true);
            }
        });
        gui.customRB.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e)
            {
                // Toggle retireBool to false
                retireBool = false;
                
                // Turn the top row invisible to the user
                gui.currentAgeTxt.setVisible(false);
                gui.retireAgeTxt.setVisible(false);
                gui.currentAgeField.setVisible(false);
                gui.retireAgeField.setVisible(false);
                // Make the bottom row visible
                gui.customYearsTxt.setVisible(true);
                gui.customYearsField.setVisible(true);
                
                gui.initialInv.setVisible(true);
                gui.annualAdd.setVisible(true);
                gui.assumedInt.setVisible(true);
                gui.getInv.setVisible(true);
                gui.getAdd.setVisible(true);
                gui.getInt.setVisible(true);
            }
        });
        // Set up the bottom row of buttons action events
        gui.calculate.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e)
            {
                // If the user decides they want to use the retirement option
                if (retireBool)
                {
                    // Grab current age user input
                    String grab = gui.currentAgeField.getText();
                    // Try to convert input to a double
                    try{
                    currentAge = Double.parseDouble(grab);
                    } catch(java.lang.NumberFormatException error){
                        System.err.println(error.getMessage());
                        // Rectify user input to a valid state if not a double
                        currentAge = 0.0;
                        gui.currentAgeField.setText("0.0");
                    }
                    System.out.println(currentAge);
                    
                    // Grab retire age user input
                    grab = gui.retireAgeField.getText();
                    // Try to convert input to a double
                    try{
                        retireAge = Double.parseDouble(grab);
                    } catch(java.lang.NumberFormatException error){
                        System.err.println(error.getMessage());
                        // Rectify user input to a valid state if not a double
                        retireAge = 1.0;
                        gui.retireAgeField.setText("1.0");
                    }
                    System.out.println(retireAge);
                            
                    // Grab initial investment amount user input
                    grab = gui.getInv.getText();
                    // Try to convert input to a double
                    try{
                        initialInvest = Double.parseDouble(grab);
                    } catch(java.lang.NumberFormatException error){
                        System.err.println(error.getMessage());
                        // Rectify user input to a valid state if not a double
                        initialInvest = 1.0;
                        gui.getInv.setText("1.0");
                    }
                    System.out.println(initialInvest);

                    // Grab annual addition amount user input
                    grab = gui.getAdd.getText();
                    // Try to convert input to a double
                    try{
                        annualAdd = Double.parseDouble(grab);
                    } catch(java.lang.NumberFormatException error){
                        System.err.println(error.getMessage());
                        // Rectify user input to a valid state if not a double
                        annualAdd = 1.0;
                        gui.getAdd.setText("1.0");
                    }
                    System.out.println(annualAdd);

                    // Grab annual interest amount user input
                    grab = gui.getInt.getText();
                    // Try to convert input to a double
                    try{
                        assumeInt = Double.parseDouble(grab);
                    } catch(java.lang.NumberFormatException error){
                        System.err.println(error.getMessage());
                        // Rectify user input to a valid state if not a double
                        assumeInt = 1.0;
                        gui.getInt.setText("1.0");
                    }
                    System.out.println(assumeInt);
                    
                    // Display the grand total of money invested + earned
                    total = mgmt.grandTotal(currentAge, retireAge, initialInvest, annualAdd, assumeInt);
                    total = round(total, 2);
                    String getTotal = ""+total;
                    gui.showTotal.setText(getTotal);
                    gui.showTotal.setVisible(true);
                    
                    // Display total money invested
                    Double years = retireAge - currentAge;
                    invested = mgmt.moneyInvested(initialInvest, annualAdd, years);
                    String getInvest = ""+invested;
                    gui.showInvest.setText(getInvest);
                    gui.showInvest.setVisible(true);
                    
                    // Display total money earned off the investment
                    earned = mgmt.totalEarned(total, invested);
                    earned = round(earned, 2);
                    String getEarned = ""+earned;
                    gui.showReturn.setText(getEarned);
                    gui.showReturn.setVisible(true);
                    
                    // Make the texts visible
                    gui.grandTotal.setVisible(true);
                    gui.moneyInv.setVisible(true);
                    gui.invReturn.setVisible(true);
                    System.out.println("bc Money Invested: $" + invested);
                    System.out.println("bc Investment Return: $" + earned);
                    System.out.println("bc Grand Total: $" + total);
                }
                else if (!retireBool)
                {
                    String grab;
                    // Grab custom # of years user input
                    grab = gui.customYearsField.getText();
                    // Try to convert input to a double
                    try{
                        customYears = Double.parseDouble(grab);
                    } catch(java.lang.NumberFormatException error){
                        System.err.println(error.getMessage());
                        // Rectify user input to a valid state if not a double
                        customYears = 1.0;
                        gui.customYearsField.setText("1.0");
                    }
                    System.out.println(customYears);
                    
                    // Grab initial investment amount user input
                    grab = gui.getInv.getText();
                    // Try to convert input to a double
                    try{
                        initialInvest = Double.parseDouble(grab);
                    } catch(java.lang.NumberFormatException error){
                        System.err.println(error.getMessage());
                        // Rectify user input to a valid state if not a double
                        initialInvest = 1.0;
                        gui.getInv.setText("1.0");
                    }
                    System.out.println(initialInvest);

                    // Grab annual addition amount user input
                    grab = gui.getAdd.getText();
                    // Try to convert input to a double
                    try{
                        annualAdd = Double.parseDouble(grab);
                    } catch(java.lang.NumberFormatException error){
                        System.err.println(error.getMessage());
                        // Rectify user input to a valid state if not a double
                        annualAdd = 1.0;
                        gui.getAdd.setText("1.0");
                    }
                    System.out.println(annualAdd);

                    // Grab annual interest amount user input
                    grab = gui.getInt.getText();
                    // Try to convert input to a double
                    try{
                        assumeInt = Double.parseDouble(grab);
                    } catch(java.lang.NumberFormatException error){
                        System.err.println(error.getMessage());
                        // Rectify user input to a valid state if not a double
                        assumeInt = 1.0;
                        gui.getInt.setText("1.0");
                    }
                    System.out.println(assumeInt);
                    
                    // Display the grand total of money invested + earned
                    total = mgmt.grandTotal(customYears, initialInvest, annualAdd, assumeInt);
                    total = round(total, 2);
                    // Send total to the add comma method to improve readability before output
                    mgmt.addCommas(total);
                    String getTotal = ""+total;
                    gui.showTotal.setText(getTotal);
                    gui.showTotal.setVisible(true);
                    
                    // Display total money invested
                    invested = mgmt.moneyInvested(initialInvest, annualAdd, customYears);
                    String getInvest = ""+invested;
                    gui.showInvest.setText(getInvest);
                    gui.showInvest.setVisible(true);
                    
                    // Display total money earned off the investment
                    earned = mgmt.totalEarned(total, invested);
                    earned = round(earned, 2);
                    String getEarned = ""+earned;
                    gui.showReturn.setText(getEarned);
                    gui.showReturn.setVisible(true);
                    
                    // Make the texts visible
                    gui.grandTotal.setVisible(true);
                    gui.moneyInv.setVisible(true);
                    gui.invReturn.setVisible(true);
                }
            }
        });
        gui.save.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e)
            {
                String filename = "default.txt";
                
                // Generate a dialog box to collect file name from user
                TextInputDialog getFile = new TextInputDialog("");
                getFile.setTitle("System File Input");
                getFile.setHeaderText("Enter a text file name to save calculation data.");
                getFile.setContentText("File name: ");

                // Get the input from the box, set filename variable
                Optional<String> result = getFile.showAndWait();
                if(result.isPresent())
                {
                    System.out.println("Save file name: " + result.get());
                    filename = result.get();
                }
                
                // Try to write to user specified file
                try (PrintWriter writer = new PrintWriter(filename))
                {
                    writer.println("Current Age: " + currentAge);
                    writer.println("Retire Age: " + retireAge);
                    writer.println("Custom Years: " + customYears);
                    writer.println("Initial Invest: $" + initialInvest);
                    writer.println("Annual Addition: $" + annualAdd);
                    writer.println("Assumed Interest: " + assumeInt + "%");
                    writer.println("Money Invested: $" + invested);
                    writer.println("Investment Return: $" + earned);
                    writer.println("Grand Total: $" + total);
                    
                    // Close the file after writing
                    writer.close();
                } 
                // Catch any issues with file opening
                catch(java.io.FileNotFoundException exception)
                {
                    System.err.println(exception.getMessage());
                }

            }
        });
        gui.reset.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e)
            {
                // Turn all texts and text fields invisible
                gui.currentAgeTxt.setVisible(false);
                gui.retireAgeTxt.setVisible(false);
                gui.currentAgeField.setVisible(false);
                gui.retireAgeField.setVisible(false);
                gui.customYearsTxt.setVisible(false);
                gui.customYearsField.setVisible(false);
                gui.initialInv.setVisible(false);
                gui.annualAdd.setVisible(false);
                gui.assumedInt.setVisible(false);
                gui.getInv.setVisible(false);
                gui.getAdd.setVisible(false);
                gui.getInt.setVisible(false);
                gui.showInvest.setVisible(false);
                gui.showReturn.setVisible(false);
                gui.showTotal.setVisible(false);
                // Make bottom row texts invisible
                gui.grandTotal.setVisible(false);
                gui.invReturn.setVisible(false);
                gui.moneyInv.setVisible(false);
                // Clear any input or output from the 9x text fields
                gui.currentAgeField.setText("");
                gui.retireAgeField.setText("");
                gui.customYearsField.setText("");
                gui.getInv.setText("");
                gui.getAdd.setText("");
                gui.getInt.setText("");
                gui.showInvest.setText("");
                gui.showReturn.setText("");
                gui.showTotal.setText("");
                // Reset the retirement and custom radio buttons
                gui.retireRB.setSelected(false);
                gui.customRB.setSelected(false);
            }
        });
        gui.close.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e)
            {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("System Alert");
                alert.setHeaderText("Close compounding interest calculator?");
                alert.setContentText("All unsaved calculations will be lost!");
                //alert.showAndWait();
                Optional<ButtonType> result = alert.showAndWait();
                if(result.get() == ButtonType.OK)
                {
                    // Close the app
                    Platform.exit();
                }
                else if(result.get() == ButtonType.CANCEL)
                {
                    // Cancel, do nothing
                }
                
            }
        });

        // Adds the CSS stylesheet
        scene.getStylesheets().add(CompoundInterest.class.getResource("StyleSheet.css").toExternalForm());
        
        // Display results to user
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
