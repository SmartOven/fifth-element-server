package ru.fifthelementserver.traffic.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    private long timestamp;
    private long bytes;
    private String url;
    private String uri;
    private String method;
    private String contentType;
}
