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
    private DeviceInfo device_info;
    private List<NetworkTransactionDto> transactions;
}
