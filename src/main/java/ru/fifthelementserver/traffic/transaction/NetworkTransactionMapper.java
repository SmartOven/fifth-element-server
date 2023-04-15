package ru.fifthelementserver.traffic.transaction;

import org.springframework.stereotype.Service;
import ru.fifthelementserver.traffic.request.Request;
import ru.fifthelementserver.traffic.request.RequestDto;
import ru.fifthelementserver.traffic.response.Response;
import ru.fifthelementserver.traffic.response.ResponseDto;

@Service
public class NetworkTransactionMapper {
    public NetworkTransaction fromDto(
            NetworkTransactionDto transactionDto, Request request, Response response
    ) {
        return new NetworkTransaction(
                null,
                TransactionType.fromString(transactionDto.getTransactionType()), transactionDto.getDeviceModel(),
                request, response
        );
    }

    public NetworkTransactionDto fromEntity(
            NetworkTransaction transaction, RequestDto requestDto, ResponseDto responseDto
    ) {
        return new NetworkTransactionDto(
                transaction.getTransactionType().toString(), transaction.getDeviceModel(),
                requestDto, responseDto
        );
    }
}
