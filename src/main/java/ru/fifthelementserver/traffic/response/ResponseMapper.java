package ru.fifthelementserver.traffic.response;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ResponseMapper {
    public Response fromDto(ResponseDto responseDto) {
        return new Response(
                null,
                new Timestamp(responseDto.getTimestamp()), responseDto.getBytes(),
                responseDto.getContentType()
        );
    }

    public ResponseDto fromEntity(Response response) {
        return new ResponseDto(
                response.getTimestamp().toInstant().toEpochMilli(), response.getBytes(),
                response.getContentType()
        );
    }
}
