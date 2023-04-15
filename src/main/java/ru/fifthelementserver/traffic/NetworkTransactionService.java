package ru.fifthelementserver.traffic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkTransactionService {
    private final NetworkTransactionRepository transactionRepository;
    private final NetworkTransactionMapper transactionMapper;

    public NetworkTransactionService(
            @Autowired NetworkTransactionRepository transactionRepository,
            @Autowired NetworkTransactionMapper transactionMapper
    ) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    public NetworkTransaction createTransaction(NetworkTransactionDto transactionDto, String deviceModel) {
        return transactionRepository.save(transactionMapper.fromDto(transactionDto, deviceModel));
    }
}
