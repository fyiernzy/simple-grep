package com.fyiernzy.simplegrep.validator.command;

/**
 * @author Ng Zhi Yang
 */
public class SaveValidator extends AbstractValidator {

    @Override
    protected boolean isSupportedOption(String option) {
        // Currently doesn't support any options
        return false;
    }

    @Override
    protected boolean isSupportedFlag(String flag) {
        // Currently doesn't support any flags
        return false;
    }
}
