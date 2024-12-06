package com.fyiernzy.simplegrep.validator.flag;

import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.fyiernzy.simplegrep.constant.FlagConstant.*;

/**
 * @author Ng Zhi Yang
 */
public class FlagValidatorFacade {

    public static void validate(@NotNull String flag, @Nullable String possibleValue) {
        FlagArgValidator validator = getValidator(flag);
        Validate.notNull(validator, "Flag %s is not supported", flag);
        validator.validate(flag, possibleValue);
    }

    private static @Nullable FlagArgValidator getValidator(@NotNull String flag) {
        return switch (flag) {
            case A, B, C, N:
                yield new NumberFlagArgValidator();
            default:
                yield null;
        };
    }
}
