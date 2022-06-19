package com.evil.ibet.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private Integer code;
    private String message;
    private T data;

    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
