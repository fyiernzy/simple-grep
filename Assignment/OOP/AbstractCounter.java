package Assignment.OOP;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.*;
import java.io.*;
import java.util.function.*;

public abstract class AbstractCounter {
	protected final String SOURCE;
	
	AbstractCounter(String source) {
		this.SOURCE = source;
	}
	
	protected Stream<String> getLines() throws IOException {
		return Files.lines(Paths.get(this.SOURCE));
	}
	
	public int countAllLines() {
		try(Stream<String> lines = this.getLines()){ 
	        return (int) lines.count(); 
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}
	
	protected int countIfContainsAll(String[] keywords, Predicate<String> predicate) {
	    try(Stream<String> lines = this.getLines()) { 
	        return (int) lines
	                .filter(predicate) 
	                .count(); 
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

}
