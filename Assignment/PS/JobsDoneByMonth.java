package Assignment.PS;

import java.io.*;

public class JobsDoneByMonth {

    public static void main(String[] args) {
	    try{
	        BufferedReader reader;
	        String line;
	        String[] arr = new String[12 - 6 + 1];
	        for(int i = 6; i <= 12; i++){
	            arr[i - 6] = ((i < 10) ? "0" : "") + i;
	        }
	            
	        for(String month : arr){
	            reader = new BufferedReader(new FileReader("C:\\Users\\user\\OneDrive\\Documents\\extracted_log.txt"));
	            int count = 0;
	                
	            while ((line = reader.readLine()) != null) {
	                if (line.contains("complete") && line.contains("done") && line.contains("-" + month + "-"))
	                    count++;
	            }
	            
	            System.out.printf("%4d jobs are done in month %s\n", count, month);
	        }
	            
	        } catch (FileNotFoundException ex) {
	            
	        } catch (IOException ex) {
	            
	        }
    }
    
}
