package com.fyiernzy.simplegrep.validator.command;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.fyiernzy.simplegrep.constant.FlagConstant.*;
import static com.fyiernzy.simplegrep.constant.OptionConstant.*;

/**
 * @author Ng Zhi Yang
 */
public class GrepValidator extends AbstractValidator {
    private static final Set<String> OPTIONS = new HashSet<>();
    private static final Set<String> FLAGS = new HashSet<>();
    
    static {
        OPTIONS.addAll(List.of(SAVE, IGNORE_CASE, TYPE, COUNT, COLOR, INVERTED));
        FLAGS.addAll(List.of(N, A, B, C));
    }
    
    @Override
    protected boolean isSupportedOption(String option) {
        return OPTIONS.contains(option);
    }

    @Override
    protected boolean isSupportedFlag(String flag) {
        return FLAGS.contains(flag);
    }
    
}
