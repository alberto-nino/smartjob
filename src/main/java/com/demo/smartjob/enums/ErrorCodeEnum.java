package com.demo.smartjob.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

/**
 * Errors to be returned as an API error response:
 * <pre>{@code
 *  {
 *      "code": "< error code>",
 *      "messages": [
 *          "message1", "message2", ..., "messageN"
 *      ]
 *  }
 * }</pre>
 * <p>
 * Messages could have format specifiers such as "%s" to be formatted by {@link String#format(String, Object...)}.
 *
 * @author Alberto Niño
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    // Common errors
    INVALID_REQUEST(400, "Invalid Parameter %s %s", HttpStatus.BAD_REQUEST),
    INVALID_REQUEST_NOT_FOUND(404, "No se encontró ninguna coincidencia con los parámetros enviados", HttpStatus.NOT_FOUND),
    INVALID_REQUEST_COUNTRY(400, "El campo country %s no es válido", HttpStatus.BAD_REQUEST),
    FEIGN_CLIENT_ERROR(500, "Error when call %s status response %s", HttpStatus.INTERNAL_SERVER_ERROR),
    FEIGN_MERCHANT_CLIENT_ERROR(500, "No es posible obtener los datos del comercio", HttpStatus.INTERNAL_SERVER_ERROR),
    INTERNAL_SERVER_ERROR(500, "Internal Error %s.", HttpStatus.INTERNAL_SERVER_ERROR),
    PROVIDER_AUTH_TOKEN_ERROR(500, "Inventory provider access token error", HttpStatus.INTERNAL_SERVER_ERROR),
    FILE_LOAD_ERROR(500, "Error when try upload file %s", HttpStatus.INTERNAL_SERVER_ERROR),
    ACCESS_DENIED(403, "No tienes permiso para acceder %s ", HttpStatus.FORBIDDEN),
    INVALID_SESSION(401, Constants.UNAUTHORIZED, HttpStatus.UNAUTHORIZED),
    BAD_REQUEST(400, "%s", HttpStatus.BAD_REQUEST),
    UNKNOWN_EXCEPTION(500, "Ocurrió un error interno al realizar la petición", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_URL(400, "La URL %s contiene caracteres invalidos %s", HttpStatus.BAD_REQUEST);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

    private static class Constants {
        private static final String UNAUTHORIZED = "No autorizado";
    }
}
