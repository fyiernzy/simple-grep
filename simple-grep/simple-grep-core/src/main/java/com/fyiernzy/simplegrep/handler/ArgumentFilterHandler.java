package com.fyiernzy.simplegrep.handler;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.stream.Stream;

@Data
@EqualsAndHashCode(callSuper = false)
public class ArgumentFilterHandler implements Handler {
    private String[] keywords;

    public ArgumentFilterHandler(String... keywords) {
        this.keywords = keywords;
    }

    /**
     * Filters the lines that contain all the keywords.
     *
     * @param lines the lines to be processed as a Stream
     * @return a Stream with lines that match all keywords
     */
    @Override
    public Stream<String> handle(Stream<String> lines) {
        return lines.filter(line -> Arrays.stream(this.keywords).allMatch(line::contains));
    }
}
