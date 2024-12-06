//package com.fyiernzy.simplegrep.analyzer;
//
//import com.fyiernzy.simplegrep.domain.dto.SanitizedResult;
//import com.fyiernzy.simplegrep.domain.request.BaseRequest;
//import com.fyiernzy.simplegrep.validator.command.AbstractValidator;
//
//public class PreChecker {
//    public BaseRequest preProcess(String command) {
//        BaseRequest request = new BaseRequest();
//        Sanitizer sanitizer = new Sanitizer();
//        AbstractValidator abstractValidator = new AbstractValidator();
//        Analyzer analyzer = new Analyzer();
//
//        SanitizedResult result = sanitizer.sanitize(command);
//        abstractValidator.validate(result);
//        request = analyzer.analyze(sanitizedCommand);
//        return request;
//    }
//}
