package com.demo.smartjob.exception;

import com.demo.smartjob.models.dto.ErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Controller exception handler.
 *
 * @author Alberto Niño
 */
@Validated
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final String ERROR = "Error";
    private static final String BAD_REQUEST_CODE = Integer.toString(BAD_REQUEST.value());

    //private static methods
    private static ResponseEntity<ErrorResponseDTO> errorResponse(final HttpServletResponse rs, final List<String> messages, final HttpStatus status, final String code) {
        return new ResponseEntity<>(
                new ErrorResponseDTO(
                        code,
                        messages,
                        UUID.randomUUID().toString()
                ),
                status
        );
    }


    /**
     * Handles the exceptions like handlerEmailValidation
     *
     * @param ex       An exception
     * @param response Response
     * @return Response entity corresponding to the error
     */
    @ResponseBody
    @ExceptionHandler
    public ResponseEntity<ErrorResponseDTO> handlerEmailValidation(final EmailException ex, final HttpServletResponse response) {
        log.error(ERROR, ex);
        return errorResponse(response, List.of(ex.getMessage()), BAD_REQUEST, BAD_REQUEST_CODE);
    }

    /**
     * Handles the exceptions like handlerEmailValidation
     *
     * @param ex       An exception
     * @param response Response
     * @return Response entity corresponding to the error
     */
    @ResponseBody
    @ExceptionHandler
    public ResponseEntity<ErrorResponseDTO> handlerEntity(final EntityException ex, final HttpServletResponse response) {
        log.error(ERROR, ex);
        return errorResponse(response, List.of("Error al intentar obtener un usuario no existente"), BAD_REQUEST, BAD_REQUEST_CODE);
    }



}
