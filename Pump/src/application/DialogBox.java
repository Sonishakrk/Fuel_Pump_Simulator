package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DialogBox {
     static String clickedButton = "Unknown";  // text from the clicked button
    public String getClickedButton() {return clickedButton; }
    
    DialogBox(String message) {
        Label lblMessage = new Label(message);
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(lblMessage);

        final Stage dialogStage = new Stage();
        dialogStage.initStyle(StageStyle.UTILITY);
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setMinWidth(300);
        borderPane.setPadding(new Insets(10));
        
        // put an OK button on the right side of the bottom pane
        Button okButton = new Button("Ok");
        AnchorPane anchorpane = new AnchorPane();
        anchorpane.getChildren().add(okButton);
        anchorpane.setRightAnchor(okButton, 8.0);
        anchorpane.setPadding(new Insets(5));
        borderPane.setBottom(anchorpane);

        okButton.setOnAction (e -> { 
            clickedButton="Ok"; 
            dialogStage.close();} );      
        okButton.setOnKeyPressed (e -> { if (((KeyEvent)e).getCode()==KeyCode.ENTER) {
                clickedButton="Ok"; dialogStage.close();} } );

        dialogStage.setScene(new Scene(borderPane));
        dialogStage.showAndWait();
    }
    
    DialogBox(BorderPane borderPane, String title, String btn1, int minWidth, int minHeight) {
        Label lblTitle = new Label(title);
        borderPane.setTop(lblTitle);
        Font font30B = Font.font("Ariel", FontWeight.BOLD, 20); // title
        lblTitle.setFont(font30B);

        final Stage dialogStage = new Stage();
        dialogStage.initStyle(StageStyle.UTILITY);
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle(title);
        dialogStage.setMinWidth(minWidth);
        dialogStage.setMinHeight(minHeight);
        borderPane.setPadding(new Insets(10));

        // buttons on the right side of the bottom pane
        HBox hbox = new HBox();
        Button button1 = new Button(btn1);
        button1.setMaxSize(80, 27);
        button1.setMinSize(80, 27);
        button1.setOnAction (e -> { clickedButton=btn1; dialogStage.close();} );  
        button1.setOnKeyPressed (e -> { if (((KeyEvent)e).getCode()==KeyCode.ENTER) {
            clickedButton=btn1; dialogStage.close();} } );
      
        hbox.getChildren().add(button1);
        hbox.setPadding(new Insets(5));

        AnchorPane anchorpane = new AnchorPane();
        anchorpane.getChildren().add(hbox);
        anchorpane.setRightAnchor(hbox, 8.0);
        borderPane.setBottom(anchorpane);            
        dialogStage.setScene(new Scene(borderPane));
        dialogStage.showAndWait();
    } 
    

    DialogBox(BorderPane borderPane, String title, String btn1, String btn2, int minWidth, int minHeight) {
        Label lblTitle = new Label(title);
        borderPane.setTop(lblTitle);
        Font font30B = Font.font("Ariel", FontWeight.BOLD, 20); // title
        lblTitle.setFont(font30B);

        final Stage dialogStage = new Stage();
        dialogStage.initStyle(StageStyle.UTILITY);
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle(title);
        dialogStage.setMinWidth(minWidth);
        dialogStage.setMinHeight(minHeight);
        borderPane.setPadding(new Insets(10));

        // buttons on the right side of the bottom pane
        HBox hbox = new HBox();
        Button button1 = new Button(btn1);
        button1.setMaxSize(80, 27);
        button1.setMinSize(80, 27);            
        button1.setOnAction (e -> { clickedButton=btn1; dialogStage.close();} );  
        button1.setOnKeyPressed (e -> { if (((KeyEvent)e).getCode()==KeyCode.ENTER) {
            clickedButton=btn1; dialogStage.close();} } );

        Button button2 = new Button(btn2);
        button2.setMaxSize(80, 27);
        button2.setMinSize(80, 27);            
        button2.setOnAction (e -> { clickedButton=btn2; dialogStage.close();} );
        button2.setOnAction (e -> { clickedButton=btn2; dialogStage.close();} );  
        button2.setOnKeyPressed (e -> { if (((KeyEvent)e).getCode()==KeyCode.ENTER) {
            clickedButton=btn2; dialogStage.close();} } );

        hbox.setPadding(new Insets(5));
        hbox.setSpacing(10.0);
        hbox.getChildren().addAll(button1, button2);

        AnchorPane anchorpane = new AnchorPane();
        anchorpane.getChildren().add(hbox);
        anchorpane.setRightAnchor(hbox, 8.0);
        borderPane.setBottom(anchorpane);            
        dialogStage.setScene(new Scene(borderPane));
        dialogStage.showAndWait();
    }    
    
}
