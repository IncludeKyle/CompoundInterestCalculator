/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compoundinterest;

import javafx.beans.value.ObservableDoubleValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * @author Kyle Blaha 7-19-18
 */
public class Gui extends StackPane {
    
    double sceneWidth, sceneHeight;
    ObservableDoubleValue sceneWidthProp, sceneHeightProp;
    
    // Top grid Gui objects
    Text retireLabel = new Text("Factor Retirement:");
    Text customLabel = new Text("Factor # of Years:");
    RadioButton retireRB = new RadioButton();
    RadioButton customRB = new RadioButton();
    Text currentAgeTxt = new Text("Current Age:");
    Text retireAgeTxt = new Text("Retirement Age:");
    Text customYearsTxt = new Text("# of Years:");
    TextField currentAgeField = new TextField();
    TextField retireAgeField = new TextField();
    TextField customYearsField = new TextField();
    
    // Mid grid Gui objects
    Text initialInv = new Text("Initial Investment($)");
    Text annualAdd = new Text("Annual Addition($)");
    Text assumedInt = new Text("Assumed Interest Rate(%)");
    TextField getInv = new TextField();
    TextField getAdd = new TextField();
    TextField getInt = new TextField();
    Text moneyInv = new Text("Total Money Invested($)     +");
    Text invReturn = new Text("Total Investment Return($)     =");
    Text grandTotal = new Text("Grand Total($)");
    TextField showInvest = new TextField();
    TextField showReturn = new TextField();
    TextField showTotal = new TextField();
    
    // Anchor pane Gui objects
    Button save = new Button("Save");
    Button calculate = new Button("Calculate");
    Button reset = new Button("Reset");
    Button close = new Button("Close");
    
    // Adds the top GridPane
    public GridPane addTopGrid(){
        GridPane topPane = new GridPane();
        topPane.setHgap(10);
        topPane.setVgap(10);
        topPane.setPadding(new Insets(10, 10, 10, 10));
        
        // These texts are declared at class level
        retireLabel.setId("text");
        customLabel.setId("text");
        
        // Set node, column, row
        topPane.add(retireLabel,0,0);
        topPane.add(customLabel, 0, 1);
        
        // Add the radio buttons to a toggle group and set grid positions
        ToggleGroup toggle = new ToggleGroup();
        retireRB.setToggleGroup(toggle);
        customRB.setToggleGroup(toggle);
        topPane.add(retireRB, 1, 0);
        topPane.add(customRB, 1, 1);
        
        // Set the CSS IDs and grid positions of the texts
        // Set all the texts to be invisible
        currentAgeTxt.setId("text");
        retireAgeTxt.setId("text");
        customYearsTxt.setId("text");
        topPane.add(currentAgeTxt, 2, 0);
        topPane.add(retireAgeTxt, 4, 0);
        topPane.add(customYearsTxt, 2, 1);
        
        currentAgeField.setMaxWidth(50);
        retireAgeField.setMaxWidth(50);
        customYearsField.setMaxWidth(50);
        topPane.add(currentAgeField, 3, 0);
        topPane.add(retireAgeField, 5, 0);
        topPane.add(customYearsField, 3, 1);
        
        // Set all of the texts and text fields to be invisible
        currentAgeTxt.setVisible(false);
        retireAgeTxt.setVisible(false);
        currentAgeField.setVisible(false);
        retireAgeField.setVisible(false);
        customYearsTxt.setVisible(false);
        customYearsField.setVisible(false);
        
        return topPane;
    }
    
    // Adds the mid GridPane
    public GridPane addMidGrid(){
        GridPane midPane = new GridPane();
        midPane.setHgap(10);
        midPane.setVgap(10);
        midPane.setPadding(new Insets(10, 10, 10, 10));
        
        // Set 3x texts CSS IDs
        initialInv.setId("text");
        annualAdd.setId("text");
        assumedInt.setId("text");
        // Render invisible
        initialInv.setVisible(false);
        annualAdd.setVisible(false);
        assumedInt.setVisible(false);
        // Set the position of these 3x texts to row 0
        midPane.add(initialInv, 0, 0);
        midPane.add(annualAdd, 1, 0);
        midPane.add(assumedInt, 2, 0);
      
        // Set the position of the 3x text fields to row 1
        // Render invisible
        getInv.setVisible(false);
        getAdd.setVisible(false);
        getInt.setVisible(false);
        midPane.add(getInv, 0, 1);
        midPane.add(getAdd, 1, 1);
        midPane.add(getInt, 2, 1);
        
        // Set the CSS IDs
        invReturn.setId("text");
        moneyInv.setId("text");
        grandTotal.setId("text");
        // Set the position of these 3x texts to row 2
        midPane.add(moneyInv, 0, 2);
        midPane.add(invReturn, 1, 2);
        midPane.add(grandTotal, 2, 2);
        // Render texts invisible
        moneyInv.setVisible(false);
        invReturn.setVisible(false);
        grandTotal.setVisible(false);
        
        // Prevent user from editing output results
        showInvest.setEditable(false);
        showReturn.setEditable(false);
        showTotal.setEditable(false);
        // Render invisible
        showInvest.setVisible(false);
        showReturn.setVisible(false);
        showTotal.setVisible(false);
        // Set the position of the 3x text fields to row 3
        midPane.add(showInvest, 0, 3);
        midPane.add(showReturn, 1, 3);
        midPane.add(showTotal, 2, 3);
       
        return midPane;
    }
    
    public AnchorPane addAnchorPane(){
        AnchorPane btmPane = new AnchorPane();
      
        // Create a horizontal box pane to store all of the buttons
        // and add the 4x buttons
        HBox hb = new HBox();
        hb.setPadding(new Insets(0, 10, 10, 10));
        hb.setSpacing(10);
        hb.getChildren().addAll(calculate, save, reset, close);
        
        // Debug this bottom anchor at some point:
        //hb.setPrefHeight(100.0);
        //hb.setStyle("-fx-background-color: #4286f4;");
        
        // Set the horizontal box pane to anchor at the bottom right
        btmPane.getChildren().add(hb);
        AnchorPane.setBottomAnchor(hb, 2.0);
        AnchorPane.setRightAnchor(hb, 8.0);
        
        return btmPane;
    }
    
    // Creates a vertical box pane of all 3x other panes 
    public VBox buildAllPanes(){
        VBox uiPane = new VBox();
        uiPane.setPrefSize(sceneWidth, sceneHeight);
        uiPane.getChildren().addAll(addTopGrid(), addMidGrid(), addAnchorPane());
        return uiPane;
    }
    
    // This background is never actually used, but its pretty cool
    public Rectangle addBackground(){
        Rectangle colors = new Rectangle(sceneWidth, sceneHeight,
            new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
                Stop[]{
                   new Stop(0, Color.web("#f8bd55")),
                   new Stop(0.14, Color.web("#c0fe56")),
                   new Stop(0.28, Color.web("#5dfbc1")),
                   new Stop(0.43, Color.web("#64c2f8")),
                   new Stop(0.57, Color.web("#be4af7")),
                   new Stop(0.71, Color.web("#ed5fc2")),
                   new Stop(0.85, Color.web("#ef504c")),
                   new Stop(1, Color.web("#f2660f")),}));
        colors.widthProperty().bind(sceneWidthProp);
        colors.heightProperty().bind(sceneHeightProp);
        
        return colors;
    }
    
    // Constructor
    public Gui(double getWidth, double getHeight, ObservableDoubleValue getWidthProp, ObservableDoubleValue getHeightProp)
    {
        sceneWidth = getWidth;
        sceneHeight = getHeight;
        sceneWidthProp = getWidthProp;
        sceneHeightProp = getHeightProp;
    }
}
