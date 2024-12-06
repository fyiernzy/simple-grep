package com.fyiernzy.simplegrep.validator.option;

import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ColorOptionArgValidator implements OptionArgValidator {

    private static final Set<String> SUPPORTED_COLOR = new HashSet<>();
    
    static {
        SUPPORTED_COLOR.addAll(List.of("red", "blue", "green", "yellow"));
    }
    @Override
    public void validate(@NotNull String arg, @Nullable String possibleValue) {
        Validate.notNull(arg, "Argument cannot be null");
        Validate.notBlank(arg, "Argument cannot be blank");
        Validate.notNull(possibleValue, "Color value cannot be blank");
        Validate.notBlank(possibleValue, "Color value cannot be blank");
        Validate.isTrue(SUPPORTED_COLOR.contains(possibleValue));
    }
    
}
