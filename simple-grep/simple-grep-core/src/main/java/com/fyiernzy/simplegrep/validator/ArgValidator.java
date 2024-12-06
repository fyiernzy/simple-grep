package com.fyiernzy.simplegrep.validator;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ArgValidator {
    void validate(@NotNull String arg, @Nullable String possibleValue);
}
