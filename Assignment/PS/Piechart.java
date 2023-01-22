package Assignment.PS;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class Piechart extends Application {

    public void start(Stage stage) {
    Scene scene = new Scene(new Group());
        stage.setTitle("Product A");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("June", 2190),
                new PieChart.Data("July", 1304),
                new PieChart.Data("August",1440),
                new PieChart.Data("September",2506),
                new PieChart.Data("October",3556),
                new PieChart.Data("November",1814),
                new PieChart.Data("December", 1102));
        
        for (PieChart.Data data : pieChartData) {
            data.setName(data.getName() + "\n" + String.format("%d", (int) data.getPieValue()) + " jobs");
        }
        
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Number Of Jobs Created By Months");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
  
    public static void main(String[] args) {
        launch();
    }
}
