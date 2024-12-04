package com.fyiernzy.simplegrep.reader;

import com.fyiernzy.simplegrep.constant.CommonConstant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {
    public String readFrom(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines.collect(Collectors.joining(CommonConstant.LINE_SEPARATOR));
        }
    }
}
