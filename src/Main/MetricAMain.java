package Main;

import java.util.Scanner;

import Filter.*;

public class MetricAMain {
	public void run() throws Exception {
		final String SOURCE = "../WIX1002/src/com/fyiernzy/Assignment/Extracted_File/extracted_log.txt";
		Counter counter = (Counter) FileUtils.getUtils(FileUtils.COUNTER, SOURCE);
		System.out.printf("The number of lines contained in log file: %5d\n", counter.countAllLines());
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("Enter the month to job complete: ");
			String date = scanner.nextLine();
			System.out.printf("The erros in %s is: %d\n", date, counter.countIfContainsAll("complete", "done", date));
		}
	}
    
}