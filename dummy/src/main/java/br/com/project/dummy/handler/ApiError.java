package br.com.project.dummy.handler;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError<E> implements Serializable {

    private E error;

    private String message;

    private String requestedPath;

    @Builder.Default
    private List<ApiFieldError> fieldsErrors = new ArrayList<>();

}
