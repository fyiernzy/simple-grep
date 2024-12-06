package com.fyiernzy.simplegrep.validator.flag;

import com.fyiernzy.simplegrep.validator.ArgValidator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Ng Zhi Yang
 */
public interface FlagArgValidator extends ArgValidator {
    @Override
    void validate(@NotNull String arg, @Nullable String possibleValue);
}
