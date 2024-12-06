package com.fyiernzy.simplegrep.domain.request;

import com.fyiernzy.simplegrep.domain.enums.GrepTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.List;
import java.util.Objects;

/**
 * Represents a request for performing a grep search with various configurable options.
 * <p>
 * Supported grep options:
 * <p>
 * <ul>
 *   <li><b>{@code -n <num>}</b> - Show the first <i>{@code <num>}</i> matching lines.</li>
 *   <li><b>{@code -b <num>}</b> - Show the first <i>{@code <num>}</i> bytes of each matching line.</li>
 *   <li><b>{@code -a <num>}</b> - Show the first <i>{@code <num>}</i> characters of each matching line.</li>
 *   <li><b>{@code -c <num>}</b> - Limit the output to the first <i>{@code <num>}</i> matches.</li>
 *   <li><b>{@code --color=<color>}</b> - Highlight matches using the specified color.</li>
 *   <li><b>{@code --count}</b> - Show the number of matching lines, not the lines themselves.</li>
 *   <li><b>{@code --type=<type>}</b> - Define the match type:
 *       <ul>
 *         <li>{@code regex}: Matches a single regular expression.</li>
 *         <li>{@code chain}: Matches lines with multiple patterns (AND logic).</li>
 *       </ul>
 *   </li>
 *   <li><b>{@code --save=<path1,path2>}</b> - Save the results to one or more files.</li>
 *   <li><b>{@code --ignore-case}</b> - Perform case-insensitive matching.</li>
 *   <li><b>{@code --inverted}</b> - Invert the match (show lines that do <i>not</i> match).</li>
 * </ul>
 *
 * @author Ng Zhi Yang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GrepRequest extends SavedRequest {
    
    /**
     * {@code nFlag} indicates the number of lines displayed.
     * A value of {@code null} means this flag is not set.
     */
    @Nullable
    private Long nFlag;

    /**
     * {@code aFlag} indicates the number of lines displayed after the target matching line.
     * A value of {@code null} means this flag is not set.
     */
    @Nullable
    private Long aFlag;

    /**
     * {@code bFlag} indicates the number of lines displayed before the target matching line.
     * A value of {@code null} means this flag is not set.
     */
    @Nullable
    private Long bFlag;

    /**
     * {@code cFlag} indicates the number of lines displayed around the target matching line.
     * A value of {@code null} means this flag is not set.
     */
    @Nullable
    private Long cFlag;

    // Visual and counting options
    /**
     * {@code color} specifies the color used for highlighting the matching lines.
     * A value of {@code null} means the color option is not set.
     */
    @Nullable
    private String color;

    /**
     * {@code count} determines whether to show the number of matching lines, rather than the matching lines themselves.
     * A value of {@code false} indicates this option is not set.
     */
    private boolean count;

    // Match Type
    /**
     * {@code grepTypeEnum} defines the type of match. It can be one of the values from {@link GrepTypeEnum}.
     * The default value is {@code chain}.
     */
    @NotNull
    private GrepTypeEnum grepTypeEnum;

    // Case-insensitivity and inversion flags
    /**
     * {@code ignoreCase} determines whether the search should be case-insensitive.
     * A value of {@code false} indicates this option is not set.
     */
    private boolean ignoreCase;

    /**
     * {@code inverted} determines whether to show lines that do <i>not</i> match the pattern.
     * A value of {@code false} indicates this option is not set.
     */
    private boolean inverted;

    // Files and patterns
    /**
     * {@code files} is a list of files to be searched. 
     * A value of {@code null} or empty indicates the option is not set.
     */
    @Nullable
    private List<File> files;

    /**
     * {@code patterns} is a list of patterns (strings or regex) to search for within the files.
     * A value of {@code null} means no patterns are defined.
     */
    @NonNull
    private List<String> patterns;

    // Methods to check if options are set

    /**
     * Checks if the {@code count} option is set.
     *
     * @return {@code true} if the {@code count} option is set, {@code false} otherwise.
     */
    public boolean isCountOptionSet() {
        return count;
    }

    /**
     * Checks if the {@code ignoreCase} option is set.
     *
     * @return {@code true} if the {@code ignoreCase} option is set, {@code false} otherwise.
     */
    public boolean isIgnoreCaseOptionSet() {
        return ignoreCase;
    }

    /**
     * Checks if the {@code inverted} option is set.
     *
     * @return {@code true} if the {@code inverted} option is set, {@code false} otherwise.
     */
    public boolean isInvertedOptionSet() {
        return inverted;
    }

    /**
     * Checks if the {@code aFlag} option is set.
     *
     * @return {@code true} if the {@code aFlag} option is set, {@code false} otherwise.
     */
    public boolean isAFlagSet() {
        return Objects.nonNull(aFlag);
    }

    /**
     * Checks if the {@code bFlag} option is set.
     *
     * @return {@code true} if the {@code bFlag} option is set, {@code false} otherwise.
     */
    public boolean isBFlagSet() {
        return Objects.nonNull(bFlag);
    }

    /**
     * Checks if the {@code cFlag} option is set.
     *
     * @return {@code true} if the {@code cFlag} option is set, {@code false} otherwise.
     */
    public boolean isCFlagSet() {
        return Objects.nonNull(cFlag);
    }

    /**
     * Checks if the {@code color} option is set.
     *
     * @return {@code true} if the {@code color} option is set, {@code false} otherwise.
     */
    public boolean isColorOptionSet() {
        return Objects.nonNull(color);
    }

}
