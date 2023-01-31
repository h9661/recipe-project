package chanwoo.recipe.project.controllers;

import chanwoo.recipe.project.exceptions.NumberFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(java.lang.NumberFormatException.class)
    public String handleNumberFormatException(Exception exception, Model model){
        log.error("handling number format exception");
        log.error(exception.getMessage());

        model.addAttribute("exception", exception);

        return "recipe/400error";
    }
}
