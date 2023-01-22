package Assignment.PS;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.*;
import java.io.*;
import java.util.*;

public class WaitingTime {
	public static void main(String[] args) throws Exception {
		final String SOURCE = "../WIX1002/src/com/fyiernzy/Assignment/Extracted_File/extracted_log.txt";
		BufferedReader reader = new BufferedReader(new FileReader(SOURCE));
		Pattern pattern = Pattern.compile("\\[(.*)\\].*JobId=(.*) [NI].*");
		Pattern submit = Pattern.compile("\\[(.*)\\].*JobId=(.*) InitPrio=(.*) usec=(.*)");
		HashMap<String, SubmitData> map = new HashMap<>();
		String line; Matcher matcher; Matcher spare;
		while((line = reader.readLine()) != null) {
			matcher = pattern.matcher(line);
			
			if (matcher.matches()) {
				
				if (!map.containsKey(matcher.group(2)))
					map.put(matcher.group(2), new SubmitData());
				
				if(line.contains("_slurm_rpc_submit_batch_job")) {
					spare = submit.matcher(line); spare.matches();
					map.get(matcher.group(2)).setSubmitTime(matcher.group(1));
					map.get(matcher.group(2)).setInitPrio(spare.group(3));
					continue;
				}
				
				if(line.contains("Allocate")) {
					map.get(matcher.group(2)).setAllocateTime(matcher.group(1));
				}
					
			}
			
			
		}
		
//		ArrayList<SubmitData> ls = new ArrayList<>();
		// PrintWriter writer = new PrintWriter("./initPrioAndDuration.csv");
		for(Map.Entry<String, SubmitData> entry : map.entrySet()) {
			SubmitData data = entry.getValue();
			System.out.printf("| %5s | %25s | %25s | %10d | %10s |\n", entry.getKey(), data.getSubmitTime(), data.getAllocateTime(), data.getDuration(), data.getInitPrio());
				// writer.printf("%s,%s,%s,%d,%s\n", entry.getKey(), data.getSubmitTime(), data.getAllocateTime(), data.getDuration(), data.getInitPrio());
			
				
		}
		
		
	}
}

class SubmitData {
	private LocalDateTime submitTime;
	private LocalDateTime allocateTime;
	private String jobID;
	private String initPrio;
	
	public String getSubmitTime() {
		return (this.submitTime == null) ? "" : this.submitTime.toString();
	}
	
	public String getAllocateTime() {
		return (this.allocateTime == null) ? "" : this.allocateTime.toString();
	}
	
	public void setSubmitTime(String submitTime) {
		this.submitTime = LocalDateTime.parse(submitTime);
	}
	
	public void setAllocateTime(String allocateTime) {
		if (this.allocateTime == null)
			this.allocateTime = LocalDateTime.parse(allocateTime);
	}
	
	public void setInitPrio(String initPrio) {
		if(this.initPrio == null)
			this.initPrio = initPrio;
	}
	
	public String getInitPrio() {
		return this.initPrio;
	}
	public long getDuration() {
		return (submitTime == null || allocateTime == null) ? 0 : ChronoUnit.MILLIS.between(submitTime, allocateTime);
	}
}
