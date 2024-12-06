package com.fyiernzy.simplegrep.domain.enums;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Ng Zhi Yang
 */

@Getter
public enum CommandTypeEnum {
    GREP("grep", List.of("g")),
    FIND("find", List.of("f")),
    SAVE("save", List.of("s")),
    LIST("list", List.of("l")),
    REGEX("regex", List.of("r")),
    LOG("log", List.of("lg")),
    CONFIG("config", List.of("c")),
    READ("read", List.of("rd")),
    ANALYZE("analyze", List.of("a"));

    private final String code;
    private final List<String> aliases;

    CommandTypeEnum(String code, List<String> aliases) {
        this.code = code;
        this.aliases = aliases;
    }
    
    public static @Nullable CommandTypeEnum of(@Nullable String arg) {
        if (arg == null) {
            return null;
        }
        return Optional.ofNullable(fromCode(arg)).orElseGet(() -> fromAlias(arg));
    }
    
    public static @Nullable CommandTypeEnum fromCode(@Nullable String code) {
        return Arrays.stream(values())
                .filter(commandTypeEnum -> commandTypeEnum.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    public static @Nullable CommandTypeEnum fromAlias(@Nullable String alias) {
        return Arrays.stream(values())
                .filter(commandTypeEnum -> commandTypeEnum.getAliases().contains(alias))
                .findFirst()
                .orElse(null);
    }
}
