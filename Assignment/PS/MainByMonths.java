package Assignment.PS;

import java.util.HashMap;
import java.util.Map;

import Assignment.OOP.DataExtractor;
import Assignment.OOP.DataTime;
import Assignment.OOP.*;

public class MainByMonths {

    public static void main(String[] args) {
        final String DEFAULT = "../WIX1002/src/com/fyiernzy/Assignment/Extracted_File/extracted_log.txt";
        HashMap<String, DataTime> map = new DataExtractor(DEFAULT).extractData().getMap();
        DataTable table = new DataTable(map);
        table.setHeader("Start Time", "End Time", "Duration");
        String[] months = {"07"};
        table.printTable(months);
        table.printAnalysis();
        
    }

}
