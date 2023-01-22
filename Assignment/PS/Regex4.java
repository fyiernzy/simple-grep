package Assignment.PS;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Regex4 extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Bar Chart Example");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
        bc.setTitle("Number of Jobs Done Within a Time Range (By Month)");
        xAxis.setLabel("Months");
        yAxis.setLabel("Number of jobs");

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Number of jobs done by month");
        series1.getData().add(new XYChart.Data<>("June", 1893));
        series1.getData().add(new XYChart.Data<>("July", 1139));
        series1.getData().add(new XYChart.Data<>("August", 1186));
        series1.getData().add(new XYChart.Data<>("September", 1153));
        series1.getData().add(new XYChart.Data<>("October", 1564));
        series1.getData().add(new XYChart.Data<>("November", 1092));
        series1.getData().add(new XYChart.Data<>("December", 438));

        bc.getData().add(series1);
        Scene scene = new Scene(bc, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
