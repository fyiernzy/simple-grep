package com.fyiernzy.system.analyze;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.*;

public class DataTime implements Comparable<DataTime> {

    public final static Pattern PATTERN = Pattern.compile("[0-9]{4}-([0-9]{2})-[0-9]{2}T(.*)");
    LocalDateTime startTime;
    LocalDateTime endTime;
    Duration duration;
    String startMonth;

    @Override
    public int compareTo(DataTime another) {
        if (this.getStartTime() == null && another.getStartTime() == null) {
            return 0;
        }
        if (this.getStartTime() == null) {
            return -1;
        }
        if (another.getStartTime() == null) {
            return 1;
        }

        return this.getStartTime().compareTo(another.getStartTime());
    }

    public void setStartTime(String startTime) {
        this.startTime = LocalDateTime.parse(startTime);
        Matcher matcher = PATTERN.matcher(startTime);
        matcher.matches();
        this.startMonth = matcher.group(1);
    }

    public void setEndTime(String endTime) {
        this.endTime = LocalDateTime.parse(endTime);
    }

    public String getStartTime() {
        return (this.startTime == null) ? null : this.startTime.toString();
    }

    public String getEndTime() {
        return (this.endTime == null) ? null : this.endTime.toString();
    }

    public long getDuration() {
        return (startTime == null || endTime == null) ? 0 : ChronoUnit.MILLIS.between(startTime, endTime);
    }

    public String getStartMonth() {
        return this.startMonth;
    }

}
