package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.collections.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
// import javafx.scene.chart.CategoryAxis;


public class UI extends Application {
  private final Pane root = new Pane();
  private final int width = 160;
  private final int height = 30;
  private final int xGap = 30 + width;
  private final int yGap = 50 + height;
  private final int xLayout = 120;
  private final int yLayout = 120;
  private final int xLayout2 = 1100;
  // Komponenten für die Eingabe
  private final ComboBox<String> comboBox1 = new ComboBox<>();
  private final ObservableList<String> comboBox1ObservableList =
          FXCollections.observableArrayList();
  private final ComboBox<String> comboBox2 = new ComboBox<>();
  private final ObservableList<String> comboBox2ObservableList =
          FXCollections.observableArrayList();
  private final ComboBox<String> comboBox3 = new ComboBox<>();
  private final ObservableList<String> comboBox3ObservableList =
          FXCollections.observableArrayList();
  private final Button button1 = new Button();
  private final TextField textField1 = new TextField();
  private final TextField textField2 = new TextField();
  private final Label label1 = new Label();
  private final Label label2 = new Label();
  private final Label label3 = new Label();
  private final Label label4 = new Label();
  private final Label label5 = new Label();
  // Komponenten für die Ausgabe
  private final Label label6 = new Label();
  private final Label label7 = new Label();
  private final Label label8 = new Label();
  private final Label label9 = new Label();
  private final Label label10 = new Label();
  private final Label label11 = new Label();
  private final Label label12 = new Label();
  private final Label[] ausgabeLabels = {label7, label8, label9, label10, label11, label12};
  // Komponenten Diagramm
  private final NumberAxis xAxis = new NumberAxis();
  private final NumberAxis yAxis = new NumberAxis();
  private final XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
  private final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(
          xAxis, yAxis);
  // Komponenten logIn
  private final Button button2 = new Button();
  private final Button button3 = new Button();

  public void start(Stage primaryStage) {

    primaryStage.setResizable(false);
    Scene scene = new Scene(root, 1920, 1080);
    comboBox1.setLayoutX(xLayout);
    comboBox1.setLayoutY(yLayout);
    comboBox1.setPrefHeight(height);
    comboBox1.setPrefWidth(width);
    comboBox1.setItems(comboBox1ObservableList);
    comboBox2.setLayoutX(xLayout + xGap);
    comboBox2.setLayoutY(yLayout);
    comboBox2.setPrefHeight(height);
    comboBox2.setPrefWidth(width);
    comboBox2.setItems(comboBox2ObservableList);
    comboBox3.setLayoutX(xLayout + (2 * xGap));
    comboBox3.setLayoutY(yLayout);
    comboBox3.setPrefHeight(height);
    comboBox3.setPrefWidth(width);
    comboBox3.setItems(comboBox3ObservableList);
    button1.setLayoutX(xLayout + (2 * xGap));
    button1.setLayoutY(yLayout + yGap);
    button1.setPrefHeight(height);
    button1.setPrefWidth(width);
    button1.setText("Suchen");
    textField1.setLayoutX(xLayout);
    textField1.setLayoutY(yLayout + yGap);
    textField1.setPrefHeight(height);
    textField1.setPrefWidth(width);
    textField2.setLayoutX(xLayout + xGap);
    textField2.setLayoutY(yLayout + yGap);
    textField2.setPrefHeight(height);
    textField2.setPrefWidth(width);
    label1.setText("Marke");
    label2.setText("km pro Jahr");
    label3.setText("Motor");
    label4.setText("Nutzungsdauer");
    label5.setText("Modell");
    root.getChildren().add(comboBox1);
    root.getChildren().add(comboBox2);
    root.getChildren().add(comboBox3);
    root.getChildren().add(button1);
    root.getChildren().add(textField1);
    root.getChildren().add(textField2);
    Label[] labelList = {label1, label2, label3, label4, label5};
    for (int i = 0; i < 5; i++) {
      labelList[i].setLayoutX(xLayout + ((i % 3) * xGap));
      labelList[i].setLayoutY(((i % 2) * yGap) + yLayout - 30);
      labelList[i].setPrefWidth(width);
      labelList[i].setPrefHeight(height);
      root.getChildren().add(labelList[i]);
    }
    int c = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 2; j++) {
        ausgabeLabels[c].setLayoutX(xLayout + xLayout2 + xGap * j);
        ausgabeLabels[c].setLayoutY(yLayout + yGap * (i + 1));
        c++;
      }
    }
    label6.setLayoutX(xLayout + xLayout2);
    label6.setLayoutY(yLayout);
    label6.setPrefWidth(width * 2 + xGap);
    label6.setPrefHeight(height);
    root.getChildren().add(label6);
    for (int i = 0; i < 6; i++) {
      ausgabeLabels[i].setPrefWidth(width);
      ausgabeLabels[i].setPrefHeight(height);
      root.getChildren().add(ausgabeLabels[i]);
    }

    // Diagramm
    xAxis.setLabel("Jahr");
    lineChart.setTitle("Kosten");
    lineChart.setPrefWidth(width * 3);
    lineChart.setPrefHeight(height * 9);
    lineChart.setLayoutX(xLayout + xLayout2 - 70);
    lineChart.setLayoutY(yLayout + yGap * 4);
    lineChart.getData().add(series);
    lineChart.setVisible(false);
    lineChart.setCreateSymbols(false);
    lineChart.setLegendVisible(false);
    root.getChildren().add(lineChart);

    // logIn
    button2.setText("Log In / Register");
    button2.setPrefWidth(width + xGap + width);
    button2.setPrefHeight(height);
    button2.setLayoutX(xLayout);
    button2.setLayoutY(yLayout + 2 * yGap);
    button2.setOnAction((event) -> { button2Action(); });
    root.getChildren().add(button2);
    /*
    button3.setPrefWidth(width);
    button3.setPrefHeight(height);
    button3.setLayoutX(xLayout + xGap);
    button3.setLayoutY(yLayout + 2 * yGap);
    button3.setOnAction((event) -> button3Action());
    root.getChildren().add(button3);
     */

    comboBox1.setOnAction((event) -> comboBox1Action());
    comboBox2.setOnAction((event) -> comboBox2Action());
    button1.setOnAction((event) -> button1Action());

    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("KFZ Portal");
    primaryStage.setScene(scene);
    primaryStage.show();

    for (String s : AutoList.distinct(AutoList.list, 0)) comboBox1.getItems().add(s);

  }

  private void comboBox1Action() {
    AutoList.currentListModel = AutoList.slice(AutoList.list, 0, comboBox1.getValue());
    comboBox2.getItems().clear();
    comboBox3.getItems().clear();
    for (String s : AutoList.distinct(AutoList.currentListModel, 1)) comboBox2.getItems().add(s);
  }

  private void comboBox2Action() {
    AutoList.currentListTrim = AutoList.slice(AutoList.currentListModel, 1, comboBox2.getValue());
    comboBox3.getItems().clear();
    for (String[] s : AutoList.currentListTrim) comboBox3.getItems().add(s[2]);
  }

  private void button1Action() {
    int index = comboBox3.getSelectionModel().getSelectedIndex();
    if (comboBox3.getItems().size() == 0 || index < 0) return;
    try {
      Manager.search(Integer.parseInt(textField2.getText()), Integer.parseInt(textField1.getText()), index);
    }
    catch (NumberFormatException e) {
      System.out.println("Wrong input");
      return;
    }
    display();
  }

  private void button2Action() {
    openLogInWindow();
  }

  private final TextField usernameField = new TextField();
  private final TextField passwordField = new TextField();
  private final Label labelMessage = new Label();

  private void openLogInWindow() {
    int logInYLayout = 60;
    Pane root2 = new Pane();
    Stage stage = new Stage();
    stage.setScene(new Scene(root2, 600, 350));
    Button logIn = new Button();
    Button register = new Button();
    usernameField.setPromptText("Username");
    usernameField.setPrefWidth(width);
    usernameField.setPrefHeight(height);
    usernameField.setLayoutX(xLayout);
    usernameField.setLayoutY(logInYLayout);
    root2.getChildren().add(usernameField);
    passwordField.setPromptText("Password");
    passwordField.setPrefWidth(width);
    passwordField.setPrefHeight(height);
    passwordField.setLayoutX(xLayout);
    passwordField.setLayoutY(logInYLayout + yGap);
    root2.getChildren().add(passwordField);
    logIn.setText("Log In");
    logIn.setPrefWidth(width);
    logIn.setPrefHeight(height);
    logIn.setLayoutX(xLayout);
    logIn.setLayoutY(logInYLayout + yGap * 2);
    logIn.setOnAction((event) -> logInAction());
    root2.getChildren().add(logIn);
    register.setText("Register");
    register.setPrefWidth(width);
    register.setPrefHeight(height);
    register.setLayoutX(xLayout + xGap);
    register.setLayoutY(logInYLayout + yGap * 2);
    register.setOnAction((event) -> registerAction());
    root2.getChildren().add(register);
    labelMessage.setPrefWidth(width + xGap + width);
    labelMessage.setPrefHeight(height);
    labelMessage.setLayoutX(xLayout);
    labelMessage.setLayoutY(logInYLayout + yGap * 3);
    root2.getChildren().add(labelMessage);
    stage.show();
  }

  private void registerAction() {
    Account account = null;
    try {
      account = AccountManager.register(usernameField.getText(), passwordField.getText());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    if (account == null) labelMessage.setText(AccountManager.getMessage());
    else Manager.setAccount(account);
  }

  private void logInAction() {
    Account account = null;
    try {
      account = AccountManager.logIn(usernameField.getText(), passwordField.getText());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    if (account == null) labelMessage.setText(AccountManager.getMessage());
    else Manager.setAccount(account);
  }

  private void button3Action() {

  }

  private void display() {
    DecimalFormat df = new DecimalFormat("0.00");
    Kosten kosten = Manager.getCurrentKosten();
    Auto auto = kosten.getAuto();
    QueueWithPointer<Double> kostenQueue = kosten.getEinzelkosten();
    String[] texts = {"Spritkosten", "Steuern", "Versicherung", "Verschleiß", "TÜV"};
    label6.setText(auto.getMarke() + " " + auto.getModel() + " " + auto.getTrim());
    for (int i = 0; i < 5; i++) {
      ausgabeLabels[i].setText(texts[i] + "\n" + df.format(kostenQueue.getPointer().getContent()) + "€");
      kostenQueue.movePointerBack();
    }
    ausgabeLabels[5].setText("Gesamt\n" + df.format(kosten.getGesamtkosten()) + "€");
    displayDiagramm();
  }

  private void displayDiagramm() {
    Kosten kosten = Manager.getCurrentKosten();
    xAxis.setAutoRanging(false);
    xAxis.setLowerBound(0);
    xAxis.setUpperBound((int) (kosten.getDauer() * 1.1));
    xAxis.setTickUnit((int) (0.1 * kosten.getDauer()));
    yAxis.setAutoRanging(false);
    yAxis.setLowerBound(0);
    yAxis.setUpperBound(kosten.getGesamtkosten() * 1.1);
    int price = 0;
    series.getData().clear();
    for (int i = 0; i <= kosten.getDauer(); i++) {
      series.getData().add(new XYChart.Data<Number, Number>(i, price));
      price += kosten.getGesamtkosten() / kosten.getDauer();
    }
    lineChart.setVisible(true);

  }

  public static void main(String[] args) {
    launch(args);
  }

}

