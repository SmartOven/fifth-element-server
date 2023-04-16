package ru.fifthelementserver.traffic;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NetworkTraffic {
    private DeviceInfo device_info;
    private List<NetworkTransactionDto> transactions;
}
