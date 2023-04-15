package ru.fifthelementserver.traffic.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.fifthelementserver.traffic.request.RequestDto;
import ru.fifthelementserver.traffic.response.ResponseDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NetworkTransactionDto {
    private String transactionType;
    private String deviceModel;
    private RequestDto request;
    private ResponseDto response;
}
