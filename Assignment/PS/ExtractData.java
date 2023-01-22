package Assignment.PS;
import java.io.*;
import java.util.regex.*;

public class ExtractData {

    public static final String PARENT_PATH = "C:\\Users\\User\\Downloads\\WIX1002 FOP";
    public static final String FILE_TYPE = ".txt";
    
    public static void main(String[] args) throws Exception{
    try{
        // read data from file
        BufferedReader inputStream = new BufferedReader(new FileReader(PARENT_PATH + "\\" + "jobstart" + FILE_TYPE));
        PrintWriter outputStream = new PrintWriter(new FileOutputStream(PARENT_PATH + "\\" + "job_start(extractedlog)" + FILE_TYPE));
        int count = 0;
        String input;
        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "Date", "Job Id", "Node List", "#CPUs", "Partition");
        System.out.printf("+----------------------------------------------------------------------+\n");
        
        // extract date, job id, node list, #CPUs, Partition
        Pattern pattern = Pattern.compile("\\[([0-9]{4}-[0-9]{2}-[0-9]{2})T.\\].*JobId=(.)\\s+NodeList=(.)\\s+#CPUs=(.)\\s+Partition=(.*)");
        while ((input = inputStream.readLine()) != null) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                String format = String.format("%-15s%-15s%-15s%-15s%-15s", matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4), matcher.group(5));
                
                // remove "," 
                String line = format;
                line = line.replace(",", " ");
                
                // print extracted data
                outputStream.println(line);
                System.out.println(line);
                }
            }
        outputStream.close();      
    }catch(FileNotFoundException e){
        System.out.println("File Not Found");    
    }catch(IOException e){
        System.out.println("Error reading");
    }
} 
    

}
