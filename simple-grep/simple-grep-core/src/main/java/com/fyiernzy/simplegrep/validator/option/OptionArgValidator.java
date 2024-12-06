package com.fyiernzy.simplegrep.validator.option;

import com.fyiernzy.simplegrep.validator.ArgValidator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Ng Zhi Yang
 */
public interface OptionArgValidator extends ArgValidator {
    @Override
    void validate(@NotNull String arg, @Nullable String possibleValue);
}
