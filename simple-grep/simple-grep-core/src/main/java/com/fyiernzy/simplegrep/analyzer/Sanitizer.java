package com.fyiernzy.simplegrep.analyzer;

import com.fyiernzy.simplegrep.domain.dto.SanitizedResult;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Sanitizer class is responsible for sanitizing the command string.
 * @author Ng Zhi Yang
 */
public class Sanitizer {
    public SanitizedResult sanitize(String command) {
        List<String> arguments = Arrays.stream(command.trim().split("\"([^\"]*)\"|\\S+"))
            .filter(StringUtils::isNotBlank)
            .map(String::trim)
            .toList();
        return new SanitizedResult(command, arguments);
    }
}
