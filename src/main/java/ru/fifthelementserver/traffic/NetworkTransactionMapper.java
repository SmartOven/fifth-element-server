package ru.fifthelementserver.traffic;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class NetworkTransactionMapper {
    public NetworkTransaction fromDto(
            NetworkTransactionDto transactionDto, String deviceModel
    ) {
        return new NetworkTransaction(
                null,
                TransactionType.fromString(transactionDto.getTransaction_type()),
                new Timestamp(transactionDto.getRequest_date()),
                new Timestamp(transactionDto.getResponse_date()),
                transactionDto.getDuration(),
                transactionDto.getRequest_size(),
                transactionDto.getResponse_size(),
                deviceModel,
                transactionDto.getResponse_code(),
                transactionDto.getUrl(),
                transactionDto.getUri(),
                transactionDto.getError(),
                transactionDto.getMethod(),
                transactionDto.getRequest_content_type(),
                transactionDto.getResponse_content_type()
        );
    }
}
