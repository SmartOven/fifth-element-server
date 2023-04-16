package ru.fifthelementserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.fifthelementserver.traffic.DeviceInfo;
import ru.fifthelementserver.traffic.NetworkTransactionDto;
import ru.fifthelementserver.traffic.NetworkTransactionService;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
public class DbFillerTest {
    private final NetworkTransactionService service;

    public DbFillerTest(
            @Autowired NetworkTransactionService service
    ) {
        this.service = service;
    }

    @Test
    void test1() {
        List<String> deviceModels = List.of(
                "iPhone 11", "iPhone 12", "iPhone 13",
                "iPhone 14", "Google Pixel 5", "Google Pixel 6",
                "Google Pixel 7", "Google Pixel 8"
        );
        int devicesCount = (int)randomInBound(10, 25);
        List<String> deviceIdList = IntStream.range(0, devicesCount)
                .mapToObj(i -> i + "--" + UUID.randomUUID())
                .toList();
        List<String> deviceModelList = deviceIdList.stream().map(deviceId -> randomFromList(deviceModels)).toList();
        for (int i = 0; i < devicesCount; i++) {
            DeviceInfo deviceInfo = new DeviceInfo(deviceModelList.get(i), deviceIdList.get(i));

            int transactionsCount = (int) randomInBound(100, 500);
            List<NetworkTransactionDto> transactions = IntStream.range(0, transactionsCount)
                    .mapToObj(j -> randomNetworkTransaction())
                    .toList();
            for (NetworkTransactionDto transaction : transactions) {
                service.createTransaction(transaction, deviceInfo);
            }
        }
    }

    private NetworkTransactionDto randomNetworkTransaction() {
        List<String> transactionTypes = List.of("HTTP_CLIENT", "DOWNLOAD_MANAGER", "EXO_PLAYER");
        List<String> requestMethods = List.of("GET", "POST", "PUT", "DELETE", "HEAD", "PATCH", "OPTIONS");
        List<String> contentTypes = List.of("application/json", "videvo stream", "audivo stream", "picture xd");
        List<Integer> responseCodes = List.of(100, 200, 204, 400, 402, 403, 418, 500, 504);

        String transaction_type = randomFromList(transactionTypes);
        String url = randomInBound(0, 1) == 0 ? randomUrl() : null;
        String uri = url == null ? randomUrl() : null;
        String error = null;
        long now = System.currentTimeMillis() - 3*60*60*1000;
        long request_date = randomInBound(now - 60*60*1000, now);
        long response_date = randomInBound(request_date + 1, request_date + 51);
        long duration = response_date - request_date;
        String method = randomInBound(0, 6) == 0 ? randomFromList(requestMethods) : "GET";
        String request_content_type = randomFromList(contentTypes);
        String response_content_type = randomFromList(contentTypes);
        long request_size = randomInBound(1, 6) * 32;
        long response_size = randomInBound(4, 32) * 256;
        int response_code = randomInBound(0, 5) == 0 ? randomFromList(responseCodes) : 200;
        return new NetworkTransactionDto(
                transaction_type, url, uri, error, request_date, response_date,
                duration, method, request_content_type, response_content_type,
                request_size, response_size, response_code
        );
    }

    private <T> T randomFromList(List<T> list) {
        return list.get((int)randomInBound(0, list.size() - 1));
    }

    private long randomInBound(long min, long max) {
        Random random = new Random();
        return random.nextInt((int)(max - min + 1)) + min;
    }

    private String randomUrl() {
        List<String> randomWords = List.of("getSomething", "addSomething", "seeMagic", "iWillBeLucky");
        return "our-best-service.ru/" + randomFromList(randomWords);
    }
}
