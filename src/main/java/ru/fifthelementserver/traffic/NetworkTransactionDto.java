package ru.fifthelementserver.traffic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NetworkTransactionDto {
    private String transaction_type;
    private String url;
    private String uri;
    private String error;
    private Long request_date;
    private Long response_date;
    private Long duration;
    private String method;
    private String request_content_type;
    private String response_content_type;
    private Long request_size;
    private Long response_size;
    private Integer response_code;
}
