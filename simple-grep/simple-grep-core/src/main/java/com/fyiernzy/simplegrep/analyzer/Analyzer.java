package com.fyiernzy.simplegrep.analyzer;

import com.fyiernzy.simplegrep.domain.enums.PipeTypeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Allow only fop grep -n 5 -b 10 -a 10 -c 10 --color=red --count --help --version --type=regex/chain content
 */
public class Analyzer {
    public List<Pipe> analyze(String command) {
        String[] parts = clean(command);
        List<Pipe> pipeList = new ArrayList<>();
        for (String part : parts) {
            pipeList.add(analyzePart(part));
        }
        return pipeList;
    }

    public Pipe analyzePart(String part) {
        String[] commandList = part.split(" ");
        PipeTypeEnum pipeTypeEnum = PipeTypeEnum.getByValue(part);
        AssertUtil.notNull(pipeTypeEnum);
        List<String> flagList = new ArrayList<>();
        List<String> operationList = new ArrayList<>();
        Pipe pipe = new Pipe();
        for(int i = 1; i < commandList.length; i++) {
            if(isFlag(commandList[i])) {
                flagList.add(commandList[i]);
            } else if(isOperation(commandList[i])) {
                operationList.add(commandList[i]);
            } else {
                pipe.setContent(commandList[i]);
            }
        }
        pipe.setPipeTypeEnum(pipeTypeEnum);
        pipe.setFlagList(flagList);
        pipe.setOperationList(operationList);
        return pipe;
    }

    private boolean isFlag(String part) {
        return part.startsWith("-");
    }

    private boolean isPair(String part) {
        return part.startsWith("--");
    }
}
