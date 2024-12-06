package com.fyiernzy.simplegrep.domain.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Ng Zhi Yang
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SavedRequest extends BaseRequest {
    private boolean saved;
}
