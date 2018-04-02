/*
Date : 30-03-2018
Author : Sietze min
Desc : Try event handling and event listeners
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class MultipleWindow extends Application{

  @Override
  public void start(final Stage primaryStage) {
    Button btn = new Button("User statistics");
    //Button btn3 = new Button("Personality traits");

    btn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event){

        Label secondLabel = new Label("hello");
        Button btn2 = new Button("Go back");

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().addAll(secondLabel, btn2);

        Scene secondScene = new Scene (secondaryLayout, 200, 500);
        Stage secondStage = new Stage();
        secondStage.setTitle("User statistics");
        secondStage.setScene(secondScene);
        btn2.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent event){
            secondStage.close();
          }
        });
        // set the position of the second window related to the primary window
        secondStage.setX(primaryStage.getX() + 250);
        secondStage.setY(primaryStage.getY() + 100);

        secondStage.show();
      }
    });

    StackPane root = new StackPane();
    root.getChildren().add(btn);
    Scene scene = new Scene(root, 300, 250);
    primaryStage.setTitle("primary stage");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
