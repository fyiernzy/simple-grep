	package Assignment.OOP;

import java.util.HashMap;
import java.util.regex.*;
import java.io.*;

public class DataExtractor {

    public static final Pattern pattern= Pattern.compile("\\[(.*)\\].*JobId=(.*) (done|N.*)");
    private final String path;
    private HashMap<String, DataTime> map;

    public DataExtractor(String path) {
        this.path = path;
        this.map = new HashMap<String, DataTime>();
    }

    public DataExtractor extractData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            Matcher matcher;

            while ((line = reader.readLine()) != null) {
                matcher = pattern.matcher(line);

                if (matcher.matches()) {

                    String jobID = matcher.group(2);

                    if (!map.containsKey(jobID)) {
                        map.put(jobID, new DataTime());
                    }

                    if (line.contains("Allocate")) {
                        map.get(jobID).setStartTime(matcher.group(1));
                        continue;
                    }

                    if (line.contains("job") && line.contains("done")) {
                        map.get(jobID).setEndTime(matcher.group(1));
                    }
                }
            }

            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return this;
    }

    public HashMap<String, DataTime> getMap() {
        return this.map;
    }
}
