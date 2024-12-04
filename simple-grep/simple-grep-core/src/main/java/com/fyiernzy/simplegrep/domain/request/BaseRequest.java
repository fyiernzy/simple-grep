package com.fyiernzy.simplegrep.domain.request;

import com.fyiernzy.simplegrep.domain.enums.CommandTypeEnum;
import lombok.Data;

import java.util.List;

@Data
public class BaseRequest {
    private CommandTypeEnum requestType;
    private String command;
    private List<String> arguments;
}
