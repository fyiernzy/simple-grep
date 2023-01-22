package Assignment.PS;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class ChartUserErrors extends Application {
    private String filePath;
    private Map<String, Integer> userCount = new HashMap<>();
    
    public ChartUserErrors(String filePath) {
        this.filePath = filePath;
        
    }
    public void start() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Username Occurrences Chart");
        // read the file and count the occurrences of each username
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\czy32\\Desktop\\WIX1002\\Group Assignment\\user_error_log_all.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[2];
                if (userCount.containsKey(username)) {
                    // increment the count of the username if already exists
                    userCount.put(username, userCount.get(username) + 1);
                } else {
                    // add the new username with count 1
                    userCount.put(username, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // set and define the x and y axis
        int highestCount = Collections.max(userCount.values()); //find highest value in userCount map
        CategoryAxis xAxis = new CategoryAxis();
        // the arguments mean that "0 is lowest range, highest value in userCount+1 as highest range, value between each major tick is 1"
        NumberAxis yAxis = new NumberAxis(0,highestCount+1,1);
        xAxis.setLabel("Username");
        yAxis.setLabel("Occurrences");

        // create the bar chart
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("User Error Occurrences Chart");

        // add data to the chart from userCount map
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (Map.Entry<String, Integer> entry : userCount.entrySet()) {
            series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }
        barChart.getData().add(series);

        // show the chart in a 1200x600 window
        Scene scene = new Scene(barChart, 1200, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
