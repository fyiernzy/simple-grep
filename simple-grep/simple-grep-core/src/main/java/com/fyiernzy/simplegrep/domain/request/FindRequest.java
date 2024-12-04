package com.fyiernzy.simplegrep.domain.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class FindRequest extends BaseRequest {
    private List<String> keywords;
}
