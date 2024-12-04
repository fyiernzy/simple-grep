package com.fyiernzy.simplegrep.analyzer;

import com.fyiernzy.simplegrep.domain.request.BaseRequest;

public class PreChecker {
    public BaseRequest preProcess(String command) {
        BaseRequest request = new BaseRequest();
        Sanitizer sanitizer = new Sanitizer();
        Validator validator = new Validator();
        Analyzer analyzer = new Analyzer();

        String[] sanitizedCommand = sanitizer.sanitize(command);
        validator.validate(sanitizedCommand);
        request = analyzer.analyze(sanitizedCommand);
        return request;
    }
}
