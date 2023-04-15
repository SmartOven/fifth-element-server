package ru.fifthelementserver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fifthelementserver.traffic.NetworkTraffic;
import ru.fifthelementserver.traffic.transaction.NetworkTransactionService;

@RestController
@RequestMapping("/api/write")
public class WritingTrafficController {
    private final NetworkTransactionService transactionService;

    public WritingTrafficController(@Autowired NetworkTransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/networkTraffic")
    public ResponseEntity<?> writeNetworkTrafficBatch(@RequestBody NetworkTraffic networkTraffic) {
        return ResponseEntity.ok(networkTraffic.getTransactions().stream().map(transactionService::createTransaction));
    }
}
