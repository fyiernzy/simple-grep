package Main;

import java.awt.Desktop;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		final String DEFAULT = "../WIX1002/src/com/fyiernzy/Assignment/Extracted_File/extracted_log.txt";
		
		if (Desktop.isDesktopSupported()) {
			
			File file = new File(DEFAULT);
			Desktop desktop = Desktop.getDesktop();
			
			if (file.exists()) 
				desktop.open(file);
			
		}
	}
}
