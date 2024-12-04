package com.fyiernzy.simplegrep.handler;

import com.fyiernzy.simplegrep.constant.RegexConstant;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
public class DateFilterHandler implements Handler {
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * Filters the lines that contain all the keywords.
     * @param lines the lines to be processed as a Stream
     * @return a Stream with lines that match all keywords
     */
    @Override
    public Stream<String> handle(Stream<String> lines) {
        return lines.filter(line -> {
            Matcher matcher = RegexConstant.DATE.matcher(line);

            // Check if the line contains a date that matches the expected format
            if (matcher.matches()) {
                LocalDate date = LocalDate.parse(matcher.group(1), RegexConstant.DATE_FORMATTER);

                // Filter lines based on the date range
                return !(date.isBefore(startDate) || date.isAfter(endDate));
            }
            return false;
        });
    }
}
