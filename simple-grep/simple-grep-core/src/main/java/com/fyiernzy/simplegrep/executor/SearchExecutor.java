package com.fyiernzy.simplegrep.executor;

import com.fyiernzy.simplegrep.constant.RegexConstant;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public abstract class SearchExecutor {
    protected final StringBuilder COMMAND;
    protected final String SOURCE;

    private static final Predicate<String> isTime = cmd -> Pattern.matches(RegexConstant.TIME.pattern(), cmd);
    private static final Predicate<String> isArgument = cmd -> Pattern.matches(RegexConstant.ARGUMENT.pattern(), cmd);

    public List<String> getCommandList() {
        return this.getCommandList(2);
    }

    public List<String> getCommandList(int startIndex) {
        return Arrays.stream(RegexConstant.SPLIT.split(this.COMMAND))
                .skip(startIndex)
                .filter(cmd -> isTimeCmd(cmd) || isArgumentCmd(cmd))
                .map(cmd -> isTimeCmd(cmd) ? cmd.substring(1) : cmd)
                .toList();
    }

    private boolean isTimeCmd(String cmd) {
        return isTime.test(cmd);
    }

    private boolean isArgumentCmd(String cmd) {
        return isArgument.test(cmd);
    }

    abstract StringBuilder perform();
}
