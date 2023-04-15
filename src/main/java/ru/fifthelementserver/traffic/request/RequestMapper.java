package ru.fifthelementserver.traffic.request;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class RequestMapper {
    public Request fromDto(RequestDto requestDto) {
        return new Request(
                null,
                new Timestamp(requestDto.getTimestamp()), requestDto.getBytes(),
                requestDto.getUrl(), requestDto.getUri(),
                requestDto.getMethod(), requestDto.getContentType()
        );
    }

    public RequestDto fromEntity(Request request) {
        return new RequestDto(
                request.getTimestamp().toInstant().toEpochMilli(), request.getBytes(),
                request.getUrl(), request.getUri(),
                request.getMethod(), request.getContentType()
        );
    }
}
