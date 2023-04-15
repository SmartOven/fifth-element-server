package ru.fifthelementserver.traffic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

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
    private TransactionType transaction_type;

    @Column(nullable = false)
    private Timestamp request_date;

    @Column(nullable = false)
    private Timestamp response_date;

    @Column(nullable = false)
    private Long duration;

    @Column(nullable = false)
    private Long request_size;

    @Column(nullable = false)
    private Long response_size;

    private String device_model;
    private Integer response_code;
    private String url;
    private String uri;
    private String error;
    private String method;
    private String request_content_type;
    private String response_content_type;
}
