package io.github.suxil.auth.exception;

import io.github.suxil.core.common.ResponseResult;
import io.github.suxil.core.exception.GlobalCommonException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalErrorControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
            GlobalCommonException.class
    })
    @Nullable
    public final ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) throws Exception {
        HttpHeaders headers = new HttpHeaders();

        if (ex instanceof GlobalCommonException) {
            ResponseResult responseResult = ResponseResult.message(ex.getMessage());
            HttpStatus status = HttpStatus.OK;

            return handleExceptionInternal(ex, responseResult, headers, status, request);
        } else {
            // Unknown exception, typically a wrapper with a common MVC exception as cause
            // (since @ExceptionHandler type declarations also match first-level causes):
            // We only deal with top-level MVC exceptions here, so let's rethrow the given
            // exception for further processing through the HandlerExceptionResolver chain.
            throw ex;
        }
    }

}
