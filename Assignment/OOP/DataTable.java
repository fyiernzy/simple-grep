package Assignment.OOP;

import java.util.*;

public class DataTable {

    private final static String[] MONTHS = {"06", "07", "08", "09", "10", "11", "12"};
    private HashMap<String, DataTime> map;
    private String[] header;
    public static int width = 30;

    public DataTable(HashMap<String, DataTime> map) {
        this.map = map;
    }

    public void setHeader(String... labels) {
        this.header = labels;
    }

    public void printTable() {
        this.printTable(MONTHS);
    }
    

    public void printTable(String... startMonths) {
        if (this.header != null) {
            for (String label : this.header) {
                System.out.printf("|%s", middleString(label, width));
            }
            System.out.println("|");
            System.out.printf(" |%s|%s|%s|\n", "-".repeat(30), "-".repeat(30), "-".repeat(30));
        }

        for (DataTime data : this.getList(startMonths)) {
            System.out.printf(" |%s|%s|%s|\n",
                    middleString(data.getStartTime(), 30), middleString(data.getEndTime(), 30), middleString(data.getDuration() + "", 30));
        }

        System.out.printf(" |%s|%s|%s|\n", "-".repeat(30), "-".repeat(30), "-".repeat(30));
    }

    private ArrayList<DataTime> getList(String... startMonths) {
        List<String> monthLs = Arrays.asList(startMonths);
        ArrayList<DataTime> ls = new ArrayList<>();

        for (var entry : map.entrySet()) {
            DataTime data = entry.getValue();
            if (data.getDuration() > 0 && monthLs.contains(data.getStartMonth())) {
                ls.add(data);
            }
        }

        Collections.sort(ls);

        return ls;
    }

    public void printAnalysis() {
        this.printAnalysis(MONTHS);
    }
    
    public void printAnalysis(String... startMonths) {
        int totalCount = 0;
        long totalTime = 0;
        
        for(DataTime data : this.getList(startMonths)){
            totalTime += data.getDuration();
            totalCount++;
        }
        System.out.println("The average execution time is: " + convertTime(totalTime / totalCount));
    }

    public String convertTime(long milliseconds) {
        long hour = milliseconds / (3600 * 1000);
        int millis = (int) milliseconds % 1000;
        int minute = (int) (milliseconds - hour * 3600 * 1000) / (60 * 1000);
        int second = (int) (milliseconds - hour * 3600 * 1000 - minute * 60 * 1000) / 1000;
        return hour + " hour(s) " + minute + " minute(s) " + second + " second(s) " + millis + " milliseconds";
    }

    public String middleString(String str, int width) {
        // Align the the string to the middle
        int space = (width - str.length()) / 2;
        int fac = (width - str.length()) % 2; // factor
        return " ".repeat(space) + str + " ".repeat(space + fac);
    }

}
