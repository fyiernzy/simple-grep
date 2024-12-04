package com.fyiernzy.simplegrep.analyzer;

import java.util.Arrays;

/**
 * Sanitizer class is responsible for sanitizing the command string.
 */
public class Sanitizer {
    public String[] sanitize(String command) {
        String[] parts = command.trim().split("\"([^\"]*)\"|\\S+");
        return Arrays.stream(parts).map(String::trim).toArray(String[]::new);
    }
}
