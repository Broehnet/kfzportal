package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
  private static final Pane root = new Pane();

  public static Pane getRoot() {
    return root;
  }

  private final int width = 160;
  private final int height = 30;
  private final int xGap = 30 + width;
  private final int yGap = 50 + height;
  private final int xLayout = 120;
  private final int yLayout = 120;
  private final int yLayoutVerlauf = 415;
  private final DecimalFormat df = new DecimalFormat("0.00");
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
  private final Button button4 = new Button();
  private final Label logInStatus = new Label();

  private final Label verlaufLabel = new Label();
  private final Button vor = new Button();
  private final Button weiter = new Button();

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
    int xLayout2 = 900;
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
    button2.setPrefWidth(width + xGap * 2);
    button2.setPrefHeight(height);
    button2.setLayoutX(xLayout);
    button2.setLayoutY(yLayout + 2 * yGap);
    button2.setOnAction((event) -> { button2Action(); });
    root.getChildren().add(button2);

    button3.setText("Log Out");
    button3.setPrefWidth(width);
    button3.setPrefHeight(height);
    button3.setLayoutX(xLayout);
    button3.setLayoutY(yLayout + 2 * yGap);
    button3.setOnAction((event) -> button3Action());
    button3.setVisible(false);
    root.getChildren().add(button3);

    button4.setText("Account wechseln");
    button4.setPrefWidth(width);
    button4.setPrefHeight(height);
    button4.setLayoutX(xLayout + xGap);
    button4.setLayoutY(yLayout + 2 * yGap);
    button4.setOnAction((event) -> button4Action());
    button4.setVisible(false);
    root.getChildren().add(button4);

    logInStatus.setText("Nicht eingeloggt");
    logInStatus.setPrefWidth(width * 2);
    logInStatus.setPrefHeight(height);
    logInStatus.setLayoutX(xLayout);
    logInStatus.setLayoutY(yLayout + 3 * yGap);
    root.getChildren().add(logInStatus);

    verlaufLabel.setText("Verlauf");
    verlaufLabel.setPrefWidth(width);
    verlaufLabel.setPrefHeight(height);
    verlaufLabel.setLayoutX(xLayout);
    verlaufLabel.setLayoutY(yLayoutVerlauf - 15);
    verlaufLabel.setVisible(false);
    root.getChildren().add(verlaufLabel);

    vor.setText("Vor");
    vor.setPrefWidth((width + 2 * xGap - 30) / 2);
    vor.setPrefHeight(height);
    vor.setLayoutX(xLayout);
    vor.setLayoutY(yLayoutVerlauf + 9 * height + yGap + 20);
    vor.setOnAction((event) -> vorAction());
    vor.setVisible(false);
    root.getChildren().add(vor);
    weiter.setText("Weiter");
    weiter.setPrefWidth((width + 2 * xGap - 30) / 2);
    weiter.setPrefHeight(height);
    weiter.setLayoutX(xLayout + (width + 2 * xGap - 30) / 2 + 30);
    weiter.setLayoutY(yLayoutVerlauf + 9 * height + yGap + 20);
    weiter.setOnAction((event) -> weiterAction());
    weiter.setVisible(false);
    root.getChildren().add(weiter);


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
      displayVerlaufElements();
    }
    catch (NumberFormatException e) {
      return;
    }
    display();
  }

  private void button2Action() {
    openLogInWindow();
  }

  private TextField usernameField;
  private TextField passwordField;
  private Label labelMessage;
  private Button logIn;
  private Button register;

  private void openLogInWindow() {
    usernameField = new TextField();
    passwordField = new TextField();
    labelMessage = new Label();
    int logInYLayout = 60;
    Pane root2 = new Pane();
    Stage stage = new Stage();
    stage.setScene(new Scene(root2, 600, 350));
    logIn = new Button();
    register = new Button();
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
    if (account != null)  successfulRegister(account);
    labelMessage.setText(AccountManager.getMessage());
  }

  private void successfulRegister(Account account) {
    successDisplay(account.getUsername());
    Manager.setAccount(account);
    Manager.setVerlauf(account.getVerlauf());
    displayVerlaufElements();
  }

  private void logInAction() {
    Account account = null;
    try {
      account = AccountManager.logIn(usernameField.getText(), passwordField.getText());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    if (account != null) successfulLogIn(account);
    labelMessage.setText(AccountManager.getMessage());
  }

  private void successfulLogIn(Account account) {
    successDisplay(account.getUsername());
    Manager.setAccount(account);
    Manager.setVerlauf(account.getVerlauf());
    for (int i = 0; i < length; i++) root.getChildren().remove(root.getChildren().size()-1);
    Manager.setCurrentVerlaufIndex(0);
    displayVerlaufElements();
  }

  private void successDisplay(String username) {
    usernameField.setVisible(false);
    passwordField.setVisible(false);
    logIn.setVisible(false);
    register.setVisible(false);
    labelMessage.setTextFill(Color.GREEN);
    labelMessage.setLayoutY(yLayout);
    button2.setVisible(false);
    button3.setVisible(true);
    button4.setVisible(true);
    logInStatus.setText("Eingeloggt als: " + username);
    verlaufLabel.setVisible(true);
  }

  private void button3Action() {
    Manager.setAccount(null);
    button3.setVisible(false);
    button4.setVisible(false);
    button2.setVisible(true);
    deleteVerlaufElements();
    logInStatus.setText("Nicht eingeloggt");
  }

  private void deleteVerlaufElements() {
    verlaufLabel.setVisible(false);
    if (buttonList.length == 0) return;
    else {
      for (Button button : buttonList) button.setVisible(false);
    }
    vor.setVisible(false);
    weiter.setVisible(false);
  }

  private void button4Action() {
    openLogInWindow();
  }

  private void display() {
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

  private Button[] buttonList;
  private static int length = 0;

  public static int getLength() {
    return length;
  }

  private void displayVerlaufElements() {
    QueueWithPointer<Verlauf> verlauf = Manager.getVerlauf();
    if (verlauf.getLength() - Manager.getCurrentVerlaufIndex() <= 5) {
      length = verlauf.getLength() - Manager.getCurrentVerlaufIndex();
      weiter.setVisible(false);
    }
    else {
      length = 5;
      weiter.setVisible(true);
    }
    if (verlauf.getLength() > 0) verlaufLabel.setText("Verlauf   " + (Manager.getCurrentVerlaufIndex() + 1) + " - "  + (Manager.getCurrentVerlaufIndex() + length));
    else verlaufLabel.setText("Verlauf");
    vor.setVisible(Manager.getCurrentVerlaufIndex() != 0);
    verlaufLabel.setVisible(true);
    buttonList = new Button[length];
    for (int i = 0; i < length; i++) {
      final int index = Manager.getCurrentVerlaufIndex() + i;
      final Verlauf verlaufElement = verlauf.getItem(index).getContent();
      buttonList[i] = new Button();
      buttonList[i].setText(verlaufElement.getAuto()[0] + " " + verlaufElement.getAuto()[1] + " " +  verlaufElement.getAuto()[2] + "      " + verlaufElement.getKmProJahr() + " km/Jahr      " + verlaufElement.getDauer() + (verlaufElement.getKmProJahr() <= 1 ? " Jahr" : " Jahre") + "      " + df.format(verlaufElement.getGesamtKosten()) + "€");
      buttonList[i].setPrefWidth(width + 2 * xGap);
      buttonList[i].setPrefHeight(height * 2);
      buttonList[i].setLayoutX(xLayout);
      buttonList[i].setLayoutY(yLayoutVerlauf + height + i * (height * 2));
      buttonList[i].setOnAction((event) -> {
        Manager.setCurrentKosten(new Kosten(verlaufElement.getAuto(), verlaufElement.getDauer(), verlaufElement.getKmProJahr()));
        display();
      });
    }
    displayVerlauf();
  }

  private void displayVerlauf() {
    for (Button button : buttonList) root.getChildren().add(button);
  }

  private void vorAction() {
    for (int i = 0; i < length; i++) root.getChildren().remove(root.getChildren().size()-1);
    Manager.setCurrentVerlaufIndex(Manager.getCurrentVerlaufIndex() - 5);
    displayVerlaufElements();
  }

  private void weiterAction() {
    for (int i = 0; i < 5; i++) root.getChildren().remove(root.getChildren().size()-1);
    Manager.setCurrentVerlaufIndex(Manager.getCurrentVerlaufIndex() + 5);
    displayVerlaufElements();
  }

  public static void main(String[] args) {
    launch(args);
  }

}

