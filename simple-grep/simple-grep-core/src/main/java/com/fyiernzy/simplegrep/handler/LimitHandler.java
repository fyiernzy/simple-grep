package com.fyiernzy.simplegrep.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.stream.Stream;

@Data
@AllArgsConstructor
public class LimitHandler implements Handler {
    private int limit;

    /**
     * Filters the lines that contain all the keywords.
     * @param lines the lines to be processed as a Stream
     * @return a Stream with lines that match all keywords
     */
    @Override
    public Stream<String> handle(Stream<String> lines) {
        return lines.limit(limit);
    }
}
