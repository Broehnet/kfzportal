package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.collections.*;
import java.text.DecimalFormat;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
// import javafx.scene.chart.CategoryAxis;


public class UI extends Application {
  private final Pane root = new Pane();
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

  final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(
          xAxis, yAxis);


  public void start(Stage primaryStage) {
    final int width = 160;
    final int height = 30;
    final int xGap = 30 + width;
    final int yGap = 50 + height;
    final int xLayout = 120;
    final int yLayout = 120;
    final int xLayout2 = 1100;

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

    comboBox1.setOnAction((event) -> { comboBox1Action(); });
    comboBox2.setOnAction((event) -> { comboBox2Action(); });
    button1.setOnAction((event) -> { button1Action(); });

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

  private void display() {
    DecimalFormat df = new DecimalFormat("0.00");
    Kosten kosten = Manager.currentKosten;
    String[] auto = kosten.getAuto();
    QueueWithPointer<Double> kostenQueue = kosten.getEinzelkosten();
    String[] texts = {"Spritkosten", "Steuern", "Versicherung", "Verschleiß", "TÜV"};
    label6.setText(auto[0] + " " + auto[1] + " " + auto[2]);
    for (int i = 0; i < 5; i++) {
      ausgabeLabels[i].setText(texts[i] + "\n" + df.format(kostenQueue.getPointer().getContent()) + "€");
      kostenQueue.movePointerBack();
    }
    ausgabeLabels[5].setText("Gesamt\n" + df.format(kosten.getGesamtkosten()) + "€");
    displayDiagramm();
  }

  private void displayDiagramm() {
    Kosten kosten = Manager.currentKosten;
    xAxis.setAutoRanging(false);
    xAxis.setLowerBound(0);
    xAxis.setUpperBound((int) (kosten.getDauer() * 1.1));
    xAxis.setTickUnit((int) (0.1 * kosten.getDauer()));
    yAxis.setAutoRanging(false);
    yAxis.setLowerBound(0);
    yAxis.setUpperBound(kosten.getGesamtkosten() * 1.1);
    int price = 0;
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

