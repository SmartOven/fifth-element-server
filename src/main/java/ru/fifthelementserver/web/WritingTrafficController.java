package ru.fifthelementserver.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fifthelementserver.traffic.DeviceInfo;
import ru.fifthelementserver.traffic.NetworkTraffic;
import ru.fifthelementserver.traffic.NetworkTransactionDto;
import ru.fifthelementserver.traffic.NetworkTransactionService;

@RestController
@RequestMapping("/api/write")
public class WritingTrafficController {
    private static final Logger log = LoggerFactory.getLogger(WritingTrafficController.class);
    private final NetworkTransactionService transactionService;

    public WritingTrafficController(@Autowired NetworkTransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/networkTraffic")
    public ResponseEntity<?> writeNetworkTrafficBatch(@RequestBody NetworkTraffic networkTraffic) {
        DeviceInfo deviceInfo = networkTraffic.getDevice_info();
        for (NetworkTransactionDto transaction : networkTraffic.getTransactions()) {
            transactionService.createTransaction(transaction, deviceInfo);
        }
        log.info(networkTraffic.toString());
        return ResponseEntity.ok("");
    }
}
