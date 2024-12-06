package com.fyiernzy.simplegrep.validator.flag;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.math.NumberUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Ng Zhi Yang
 */
public class NumberFlagArgValidator implements FlagArgValidator {
    @Override
    public void validate(@NotNull String arg, @Nullable String possibleValue) {
        Validate.notNull(arg, "Argument cannot be null");
        Validate.notBlank(arg, "Argument cannot be blank");
        Validate.notNull(possibleValue, "Value string cannot be null");
        Validate.notBlank(possibleValue, "Value string cannot be blank");
        Validate.isTrue(isInteger(possibleValue), "Value must be an positive integer");
    }
    
    private boolean isInteger(String possibleValue) {
        return NumberUtils.isDigits(possibleValue);
    }
}
