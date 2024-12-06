package com.fyiernzy.simplegrep.domain.dto;

import java.util.List;

public record SanitizedResult(String command, List<String> arguments) {
}
