package Assignment.PS;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Barchart extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bar Chart Example");

        // Create the axes
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Months");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Numbers");

        // Create the chart
        BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);

        // Create the data for the chart
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Number of jobs created according to month");
        
        series.getData().add(new XYChart.Data("june", 2190));
        series.getData().add(new XYChart.Data("july", 1304));
        series.getData().add(new XYChart.Data("august", 1440));
        series.getData().add(new XYChart.Data("september", 2506));
        series.getData().add(new XYChart.Data("october", 3556));      
        series.getData().add(new XYChart.Data("november", 1814));      
        series.getData().add(new XYChart.Data("december", 1102));   
        chart.getData().add(series);
        
        //Change color of the bar
        series.getData().get(0).getNode().setStyle("-fx-bar-fill: red;");
        series.getData().get(1).getNode().setStyle("-fx-bar-fill: orange;");
        series.getData().get(2).getNode().setStyle("-fx-bar-fill: yellow;");
        series.getData().get(3).getNode().setStyle("-fx-bar-fill: green;");
        series.getData().get(4).getNode().setStyle("-fx-bar-fill: blue;");
        series.getData().get(5).getNode().setStyle("-fx-bar-fill: violet;");
        series.getData().get(6).getNode().setStyle("-fx-bar-fill: purple;");
        
        // Add the chart to the Scene
        Scene scene = new Scene(chart, 600, 400);

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
