package com.fyiernzy.simplegrep.analyzer;

import com.fyiernzy.simplegrep.domain.enums.PipeTypeEnum;
import lombok.Data;

import java.util.List;

@Data
public class Pipe {
    private PipeTypeEnum pipeTypeEnum;
    private String content;
    private List<String> flagList;
    private List<String> operationList;
}
