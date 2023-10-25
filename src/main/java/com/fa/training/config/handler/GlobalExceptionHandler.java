package com.fa.training.config.handler;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IOException.class, java.sql.SQLException.class})
    public ModelAndView handleIOException(Exception ex){
        ModelAndView model = new ModelAndView("IOError");
        model.addObject("exception", ex.getMessage());
        return model;
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        ModelAndView model = new ModelAndView("IOError");
        model.addObject("exception", e.getMessage());
        return model;
    }
}
