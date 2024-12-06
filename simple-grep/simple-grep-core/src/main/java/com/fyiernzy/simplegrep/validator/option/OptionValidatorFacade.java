package com.fyiernzy.simplegrep.validator.option;

import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ng Zhi Yang
 */
public class OptionValidatorFacade {
    private static final Map<String, OptionArgValidator> MAP = new HashMap<>();

    static {

    }

    public static void validate(@NotNull String flag, @Nullable String possibleValue) {
        OptionArgValidator validator = MAP.get(flag);
        Validate.notNull(validator, "Option %s is not supported", flag);
        validator.validate(flag, possibleValue);
    }
}
