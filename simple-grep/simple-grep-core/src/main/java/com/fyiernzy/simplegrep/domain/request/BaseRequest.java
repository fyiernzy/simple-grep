package com.fyiernzy.simplegrep.domain.request;

import com.fyiernzy.simplegrep.domain.enums.CommandTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

/**
 * @author Ng Zhi Yang
 */
@Data
@NoArgsConstructor
public class BaseRequest {
    /**
     * Command type which is, by default, the second arguments in a command.
     * See {@link CommandTypeEnum} for more currently supported commands.
     * @see CommandTypeEnum
     */
    @NonNull
    private CommandTypeEnum commandType;

    /**
     * The command is the input string from the user.
     */
    @NonNull
    private String command;

    /**
     * The arguments are pieces that form the command. 
     * For example, the command "grep -i -r -n -c -o" will have arguments ["grep", "-i", "-r", "-n", "-c", "-o"]
     */
    @NonNull
    private List<String> arguments;
}
