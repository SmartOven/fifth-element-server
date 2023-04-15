package ru.fifthelementserver.traffic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NetworkTraffic {
    private String device_model;
    private List<NetworkTransactionDto> transactions;
}
