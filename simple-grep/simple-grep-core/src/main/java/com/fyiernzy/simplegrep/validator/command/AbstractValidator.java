package com.fyiernzy.simplegrep.validator.command;

import com.fyiernzy.simplegrep.constant.RegexConstant;
import com.fyiernzy.simplegrep.domain.dto.SanitizedResult;
import com.fyiernzy.simplegrep.domain.enums.CommandTypeEnum;
import com.fyiernzy.simplegrep.validator.flag.FlagValidatorFacade;
import com.fyiernzy.simplegrep.validator.option.OptionValidatorFacade;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Validator
 *
 * @author Ng Zhi Yang
 */
public abstract class AbstractValidator {
    private static final int COMMAND_TYPE_INDEX = 1;
    private static final int MIN_ARGUMENTS = 3;
    private static final String INITIALIZER = "fop";
    private static final int FLAG_LENGTH = 1;
    private static final int FLAG_INDEX = 1;
    private static final int OPTION_BEGIN_INDEX = 2;
    private static final String KEY_VALUE_SEPARATOR = "=";
    private static final int NOT_FOUND = -1;
    private static final int ARGUMENT_BEGIN_INDEX = 2;

    public void validate(SanitizedResult sanitizedResult) {
        Validate.notNull(sanitizedResult, "SanitizedResult is null");
        List<String> arguments = sanitizedResult.arguments();
        validateArguments(arguments);
        validateCommandType(arguments);
        validateFlagsAndOptions(arguments);
    }

    private void validateArguments(List<String> arguments) {
        Validate.notNull(arguments, "Arguments is null");
        Validate.isTrue(!arguments.isEmpty(), "No arguments provided");
        Validate.isTrue(arguments.size() >= MIN_ARGUMENTS, "Too few arguments provided");
        Validate.isTrue(isInitializer(arguments.getFirst()), "Invalid initializer: " + arguments.getFirst());
        arguments.forEach(this::validateArgument);
    }

    private void validateCommandType(List<String> arguments) {
        CommandTypeEnum commandType = CommandTypeEnum.of(arguments.get(COMMAND_TYPE_INDEX));
        Validate.notNull(commandType, "Invalid command type: " + arguments.get(COMMAND_TYPE_INDEX));
    }

    private void validateFlagsAndOptions(List<String> arguments) {
        for (int i = ARGUMENT_BEGIN_INDEX; i < arguments.size(); i++) {
            String arg = arguments.get(i);
            if (hasFlagSign(arg)) {
                String next = getNextArgument(arguments, i);
                validateFlag(arg, next);
            } else if (hasOptionSign(arg)) {
                validateOption(arg);
            }
        }
    }

    private void validateArgument(String arg) {
        Validate.notNull(arg, "Argument is null");
        Validate.isTrue(RegexConstant.ARGUMENT.pattern().matches(arg), "Invalid argument: " + arg);
    }

    private void validateFlag(@NotNull String arg, @Nullable String possibleValue) {
        Validate.notNull(arg, "Flag is null");
        String flag = arg.substring(FLAG_INDEX);
        Validate.isTrue(flag.length() == FLAG_LENGTH, "Invalid flag= " + flag);
        Validate.isTrue(isSupportedFlag(flag), "Unsupported flag= " + flag);
        FlagValidatorFacade.validate(flag, possibleValue);
    }

    private void validateOption(String arg) {
        Validate.notNull(arg, "Option is null");
        int equalsIndex = arg.indexOf(KEY_VALUE_SEPARATOR);
        String option = equalsIndex == NOT_FOUND ? arg.substring(OPTION_BEGIN_INDEX) : arg.substring(OPTION_BEGIN_INDEX, equalsIndex);
        String possibleValue = equalsIndex == NOT_FOUND ? null : arg.substring(equalsIndex);
        Validate.isTrue(isSupportedOption(option), "Unsupported option: " + option);
        OptionValidatorFacade.validate(option, possibleValue);
    }

    private @Nullable String getNextArgument(@NotNull List<String> arguments, int currentIndex) {
        return currentIndex < arguments.size() - 1 ? arguments.get(currentIndex + 1) : null;
    }

    private static boolean isInitializer(String initializer) {
        return INITIALIZER.equals(initializer);
    }

    private static boolean hasFlagSign(@NotNull String arg) {
        return arg.startsWith("-") && !hasOptionSign(arg);
    }

    private static boolean hasOptionSign(@NotNull String arg) {
        return arg.startsWith("--");
    }

    protected abstract boolean isSupportedOption(String option);

    protected abstract boolean isSupportedFlag(String flag);

}
