package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.collections.*;


public class UI extends Application {
  // Anfang Attribute
  // Ende Attribute
  private ComboBox<String> comboBox1 = new ComboBox<>();
  private ObservableList<String> comboBox1ObservableList =
          FXCollections.observableArrayList();
  private ComboBox<String> comboBox2 = new ComboBox<>();
  private ObservableList<String> comboBox2ObservableList =
          FXCollections.observableArrayList();
  private ComboBox<String> comboBox3 = new ComboBox<>();
  private ObservableList<String> comboBox3ObservableList =
          FXCollections.observableArrayList();


  public void start(Stage primaryStage) {
    final int width = 120;
    final int height = 30;
    final int distance = 30 + width;
    final int xLayout = 120;
    final int yLayout = 120;
    Pane root = new Pane();
    Scene scene = new Scene(root, 1920, 1080);
    comboBox1.setLayoutX(xLayout);
    comboBox1.setLayoutY(yLayout);
    comboBox1.setPrefHeight(height);
    comboBox1.setPrefWidth(width);
    comboBox1.setItems(comboBox1ObservableList);
    comboBox2.setLayoutX(xLayout + distance);
    comboBox2.setLayoutY(yLayout);
    comboBox2.setPrefHeight(height);
    comboBox2.setPrefWidth(width);
    comboBox2.setItems(comboBox2ObservableList);
    comboBox3.setLayoutX(xLayout + (2 * distance));
    comboBox3.setLayoutY(yLayout);
    comboBox3.setPrefHeight(height);
    comboBox3.setPrefWidth(width);
    comboBox3.setItems(comboBox3ObservableList);
    root.getChildren().add(comboBox1);
    root.getChildren().add(comboBox2);
    root.getChildren().add(comboBox3);
    for (String s : AutoList.distinct(AutoList.list, 0)) comboBox1.getItems().add(s);
    comboBox1.setOnAction((event) -> {
      AutoList.currentListModel = AutoList.slice(AutoList.list, 0, comboBox1.getValue());
      comboBox2.getItems().clear();
      for (String s : AutoList.distinct(AutoList.currentListModel, 1)) comboBox2.getItems().add(s);
    });
    comboBox2.setOnAction((event) -> {
      AutoList.currentListTrim = AutoList.slice(AutoList.currentListModel, 1, comboBox2.getValue());
      comboBox3.getItems().clear();
      for (String[] s : AutoList.currentListTrim) comboBox3.getItems().add(s[2]);
    });

    // Anfang Komponenten

    // Ende Komponenten
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("UI");
    primaryStage.setScene(scene);
    primaryStage.show();

  } // end of public UI
  // Anfang Methoden
  
  public static void main(String[] args) {
    launch(args);
  } // end of main
  
  // Ende Methoden
} // end of class UI

