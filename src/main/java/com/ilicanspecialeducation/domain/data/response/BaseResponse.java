package com.ilicanspecialeducation.domain.data.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {
    private T data;
    private String errorCode;
    private Map<String, Object> errorDetail;
    private Boolean isSuccess = Boolean.TRUE;

    public BaseResponse(T data) {
        this.data = data;
    }
}
