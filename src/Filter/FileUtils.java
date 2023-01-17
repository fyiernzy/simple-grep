package Filter;

import java.io.*;

public abstract class FileUtils {
	protected final String FILE_PATH;
	
	public static final String COUNTER = "COUNTER";
	
	public FileUtils(String filePath) {
		this.FILE_PATH = filePath;
	}
	
	public static FileUtils getUtils(String utilType, String filePath) throws FileNotFoundException, Exception {
		if (!new File(filePath).exists())
			throw new FileNotFoundException("The file is not existed");
		
		
		FileUtils util = null;
		
		switch(utilType.toUpperCase()) {
			case COUNTER -> util = new Counter(filePath);
			default      -> throw new Exception("Invalid arguments");
		}
		
		return util;
	}
	
	public StringBuilder readFile() {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(this.FILE_PATH))) {
			char[] buff = new char[8192];
			int bytesRead;
			while((bytesRead = reader.read(buff)) != -1) {
				sb.append(buff, 0, bytesRead);
			}
			
			return sb;
		} catch (Exception ex) {
			return sb;
		}
	}
}

