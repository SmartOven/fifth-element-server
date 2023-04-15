package ru.fifthelementserver.traffic.transaction;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.fifthelementserver.traffic.request.Request;
import ru.fifthelementserver.traffic.response.Response;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NetworkTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    private String deviceModel;

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Request request;

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Response response;
}
