package ru.fifthelementserver.traffic;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class NetworkTransactionMapper {
    public NetworkTransaction fromDto(
            NetworkTransactionDto transactionDto, DeviceInfo deviceInfo
    ) {
        Timestamp responseTimestamp = transactionDto.getResponse_date() == null
                ? Timestamp.from(Instant.now())
                : new Timestamp(transactionDto.getResponse_date());
        return new NetworkTransaction(
                null,
                deviceInfo.getId(),
                TransactionType.fromString(transactionDto.getTransaction_type()),
                transactionDto.getRequest_date() == null ? responseTimestamp : new Timestamp(transactionDto.getRequest_date()),
                responseTimestamp,
                transactionDto.getDuration() == null ? 0 : transactionDto.getDuration(),
                transactionDto.getRequest_size() == null ? 0 : transactionDto.getRequest_size(),
                transactionDto.getResponse_size() == null ? 0 : transactionDto.getResponse_size(),
                deviceInfo.getModel(),
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
