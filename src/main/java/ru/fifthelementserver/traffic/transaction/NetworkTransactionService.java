package ru.fifthelementserver.traffic.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fifthelementserver.traffic.request.Request;
import ru.fifthelementserver.traffic.request.RequestMapper;
import ru.fifthelementserver.traffic.request.RequestRepository;
import ru.fifthelementserver.traffic.response.Response;
import ru.fifthelementserver.traffic.response.ResponseMapper;
import ru.fifthelementserver.traffic.response.ResponseRepository;

@Service
public class NetworkTransactionService {
    private final NetworkTransactionRepository transactionRepository;
    private final RequestRepository requestRepository;
    private final ResponseRepository responseRepository;
    private final RequestMapper requestMapper;
    private final ResponseMapper responseMapper;
    private final NetworkTransactionMapper transactionMapper;

    public NetworkTransactionService(
            @Autowired NetworkTransactionRepository transactionRepository,
            @Autowired RequestRepository requestRepository,
            @Autowired ResponseRepository responseRepository,
            @Autowired RequestMapper requestMapper,
            @Autowired ResponseMapper responseMapper,
            @Autowired NetworkTransactionMapper transactionMapper
    ) {
        this.transactionRepository = transactionRepository;
        this.requestRepository = requestRepository;
        this.responseRepository = responseRepository;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
        this.transactionMapper = transactionMapper;
    }

    public NetworkTransaction createTransaction(NetworkTransactionDto transactionDto) {
        Request request = requestRepository.save(requestMapper.fromDto(transactionDto.getRequest()));
        Response response = responseRepository.save(responseMapper.fromDto(transactionDto.getResponse()));
        return transactionRepository.save(transactionMapper.fromDto(transactionDto, request, response));
    }
}
