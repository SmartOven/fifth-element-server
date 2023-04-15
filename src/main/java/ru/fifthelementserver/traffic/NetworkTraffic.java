package ru.fifthelementserver.traffic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.fifthelementserver.traffic.transaction.NetworkTransactionDto;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NetworkTraffic {
    private List<NetworkTransactionDto> transactions;
}
