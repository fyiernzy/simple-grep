package com.fyiernzy.simplegrep.handler;

import java.util.stream.Stream;

public interface Handler {
    /**
     * Takes in some content and returns the processed content
     * @param content the content to be processed
     * @return the processed content
     */
    Stream<String> handle(Stream<String> content);
}
