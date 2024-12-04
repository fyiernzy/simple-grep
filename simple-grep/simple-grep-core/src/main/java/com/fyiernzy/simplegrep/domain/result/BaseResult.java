package com.fyiernzy.simplegrep.domain.result;

import lombok.Data;

@Data
public class BaseResult<T> {
    private boolean isSuccess;
    private String errorMsg;
    private T result;
}
