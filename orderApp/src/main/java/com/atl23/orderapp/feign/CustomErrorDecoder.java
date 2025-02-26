package com.atl23.orderapp.feign;

import com.atl23.orderapp.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.io.IOException;
import java.io.InputStream;

@RestControllerAdvice
public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        String  message = null;
        try (InputStream bodyIs = response.body().asInputStream()) {
            //ObjectMapper mapper = new ObjectMapper();
            message = bodyIs.toString();
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        return switch (response.status()) {
            case 400 -> new BadRequestException(message);
            case 404 -> new NotFoundException(message);
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}
