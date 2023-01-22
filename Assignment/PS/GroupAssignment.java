package Assignment.PS;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class GroupAssignment {
    private static final String pathway="C:\\Users\\czy32\\Desktop\\WIX1002\\Group Assignment\\user_error_log_all.txt";
    private int errorCount;
    public static void main(String[] args) throws Exception {
        writeAllUserError();
        ChartUserErrors chart = new ChartUserErrors(pathway);
        chart.start();
        printAllUserError(pathway);
        writeErrorByMonth(monthSet());
        printTimeRange(pathway);
        printAUser(pathway);
    }
    
    //reads extracted_log and writes all user errors into a txt file
    public static void writeAllUserError() throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\czy32\\Desktop\\WIX1002\\Group Assignment\\extracted_log"));
        PrintWriter writer = new PrintWriter(new FileOutputStream("C:\\Users\\czy32\\Desktop\\WIX1002\\Group Assignment\\user_error_log_all.txt"));
        String line;
        //set regex pattern to extract date, association number, username, qos type
        Pattern pattern = Pattern.compile("\\[(.*)-([0-9]{2})-([0-9]{2}).*\\] error:.*association (.*)\\(.*user='(.*)',.*qos (.*)");
        while ((line = input.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                //writes into txt file in the form of "date,number,username,qos"
                writer.println(matcher.group(3) + "/" + matcher.group(2) + "/" + matcher.group(1) + "," + matcher.group(4) + "," + matcher.group(5) + "," + matcher.group(6));
            }
        }
        writer.close();
        input.close();
    }
    
    //creates a set of months that has user error
    public static HashSet<String> monthSet() throws Exception {
        HashSet<String> months = new HashSet<>();
        BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\czy32\\Desktop\\WIX1002\\Group Assignment\\user_error_log_all.txt"));
        String line;
        Pattern pattern = Pattern.compile(".*/([0-9]{2})/.*");
        while ((line = input.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                //adds the month into the set
                months.add(matcher.group(1));
            }
        }
        input.close();
        return months;

    }
    
    //takes the months set as argument, writes user error into txt file seperated by months
    public static void writeErrorByMonth(HashSet<String> monthSet) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\czy32\\Desktop\\WIX1002\\Group Assignment\\extracted_log"));
        //change month set to arraylist to sort it in ascending order
        ArrayList<String> monthArray = new ArrayList(monthSet);
        Collections.sort(monthArray);
        for (int i = 0; i < monthArray.size(); i++) {
            int errorCount = 0;
            input = new BufferedReader(new FileReader("C:\\Users\\czy32\\Desktop\\WIX1002\\Group Assignment\\extracted_log"));
            String month = monthArray.get(i);
            //writes to a txt file with current loop's month
            PrintWriter writer = new PrintWriter(new FileOutputStream("C:\\Users\\czy32\\Desktop\\WIX1002\\Group Assignment\\user_error_log_month_" + month + ".txt"));
            Pattern pattern = Pattern.compile("\\[(.*)-(" + month + ")-([0-9]{2}).*\\] error:.*association (.*)\\(.*user='(.*)',.*qos(.*)");
            String line;
            while ((line = input.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    writer.println(matcher.group(3) + "/" + matcher.group(2) + "/" + matcher.group(1) + "," + matcher.group(4) + "," + matcher.group(5) + "," + matcher.group(6));
                    errorCount++;
                }
            }
            System.out.println("User error in month " + month + ": " + errorCount);
            writer.close();
        }
        input.close();
    }
    
    //print out all user error in table form
    public static void printAllUserError(String path) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader(path));
        String line;
        while ((line = input.readLine()) != null) {
            for (String s : line.split(",")) {
                System.out.printf("|%s", middleString(s, 30));
            }
            System.out.println("|");
        }
    }
    
    //method to align elements in table to center
    public static String middleString(String s, int width) {
        int space = (width - s.length()) / 2;
        int fac = (width - s.length()) % 2;
        return " ".repeat(space) + s + " ".repeat(fac + space);
    }
    
    //reads start date & end date, then prints out user error in that range
    public static void printTimeRange(String path) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(path));
        //sets the date format
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Please enter start date (in dd/mm/yyyy format):");
        //reads user inputs as Date objects
        Date startDate = format.parse(sc.nextLine());
        System.out.println("Please enter end date (in dd/mm/yyyy format):");
        Date endDate = format.parse(sc.nextLine());
        String line;
        while ((line = reader.readLine()) != null) {
            String[] dataLine = line.split(",");
            //takes element at [0] as Date object, the current date
            Date lineDate = format.parse(dataLine[0]);
            //compare if current date is larger than start date and less than end date
            if (lineDate.compareTo(startDate) >= 0 && lineDate.compareTo(endDate) <= 0) {
                for (String s : dataLine) {
                    System.out.printf("|%s", middleString(s, 30));
                }
                System.out.println("|");
            }
        }
    }
    
    //reads a username, then prints out error associated with that name
    public static void printAUser(String path) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(path));
        System.out.println("Enter user ID:");
        String user = sc.nextLine();
        String line;
        int longCount = 0, normalCount = 0, extendedCount = 0;
        while ((line = reader.readLine()) != null) {
            String[] dataLine = line.split(",");
            //dataLine[2] is username
            if (user.equals(dataLine[2])) {
                for (String s : dataLine) {
                    System.out.printf("|%s", middleString(s, 30));
                }
                System.out.println("|");
                //increment the type of qos of this username
                switch (dataLine[3]) {
                    case "long" ->
                        longCount++;
                    case "normal" ->
                        normalCount++;
                    case "extended" ->
                        extendedCount++;
                    default -> {
                    }
                }
            }
        }
        System.out.printf("qos long: %d\nqos normal: %d\nqos extended:%d\n", longCount, normalCount, extendedCount);
    }
}
