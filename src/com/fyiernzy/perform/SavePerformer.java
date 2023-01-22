package com.fyiernzy.perform;

import java.io.File;
import java.io.PrintWriter;
import java.awt.Desktop;

public class SavePerformer {
	public static void performSave(StringBuilder record, StringBuilder command) {
		if(record != null) {
			try {
				String[] tmp = command.toString().split(" ");
				File file = new File("../WIX1002/src/com/fyiernzy/Assignment/Extracted_File/" + tmp[2]);
				
				if (file.createNewFile()) {
					PrintWriter writer = new PrintWriter(file);
					writer.println(record);
					writer.close();
					System.out.println("Save successful");
				} else {
					System.out.println("The file name is already existed.");
				}
				
				if(Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(file);
				}
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			
		} else {
			System.out.println("No record to save");
		}
	}
}
