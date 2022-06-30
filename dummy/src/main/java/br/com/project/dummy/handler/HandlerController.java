package br.com.project.dummy.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestControllerAdvice
public class HandlerController {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<?> handleEntityNotFound(EntityNotFoundException exception, HttpServletRequest httpRequest) {

        String userMessage = "Não foi possivel encontrar registros na base de dados com os parâmetros informados.";
        String devMessage = exception.getMessage();
        List<ApiError<String>> errors = List.of(new ApiError<>(devMessage, userMessage, httpRequest.getRequestURI(), null));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);

    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ ExistingEntityException.class })
    public ResponseEntity<?> handleExistingEntity(ExistingEntityException exception, HttpServletRequest httpRequest) {

        String messageDev = exception.toString();
        List<ApiError<String>> errors = List.of(new ApiError<>( messageDev, exception.getMessage(), httpRequest.getRequestURI(), null));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);

    }

}
