package Assignment.PS;

import java.io.*;

public class JobsCreated {
    
    public static final String PARENT_PATH = "C:\\Users\\User\\Downloads\\WIX1002 FOP\\";
    public static final String FILE_TYPE = ".txt";
        
    public static void main(String[] args) throws Exception{
        
        try{
            
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(PARENT_PATH + "jobCreated" + FILE_TYPE));
            
            // declare and initialize variable line and total count
            String line = " ";
            int totalCount = 0;
             
            // put timelines into array
            String[] timelines = {"2022-06","2022-07","2022-08","2022-09","2022-10","2022-11","2022-12"};
            
            // read timelines from file to count them according to each month
            for(String timeline : timelines){
                BufferedReader inputStream = new BufferedReader(new FileReader(PARENT_PATH + "job_start(extractedlog)" + FILE_TYPE));
                int count = 0;
                while((line = inputStream.readLine())!= null){
                    if(line.contains(timeline)){
                        count++;
                    }
                }
                // add all the count together to find total count for all months)
                totalCount += count;
                
                // print the output
                System.out.print(timeline);
                System.out.println(" --> " + "Number of jobs created : " + count );
                
            }
            System.out.println("\nTotal number of jobs created (June - December) : " + totalCount);  
            outputStream.close();      
        }catch(FileNotFoundException e){
            System.out.println("File Not Found");    
        }catch(IOException e){
            System.out.println("Error reading");
        }
    } 
}
