package org.foodeezz.controller;

import org.foodeezz.util.DateTimeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.OptimisticLockException;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by bakhtiar.galib on 4/12/15.
 */
@ControllerAdvice
public class GlobalExceptionController {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionController.class);

    @ExceptionHandler(SQLException.class)
    public ModelAndView handleSqlException(HttpServletRequest httpServletRequest, SQLException exception) {
        logError(httpServletRequest, exception);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("errMessage", "SQL ERROR OCCURRED");
        modelAndView.setViewName("error");

        return modelAndView;
    }

    @ExceptionHandler(OptimisticLockException.class)
    public ModelAndView handleOptimisticLockException(HttpServletRequest httpServletRequest, OptimisticLockException exception) {
        logError(httpServletRequest, exception);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("errorMessage", "OPTIMISTIC LOCKING ERROR");
        modelAndView.setViewName("error");

        return modelAndView;
    }

    @ExceptionHandler(OptimisticLockingFailureException.class)
    public ModelAndView handleOptimisticLockingFailureException(HttpServletRequest httpServletRequest, OptimisticLockingFailureException exception) {
        logError(httpServletRequest, exception);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("errorMessage", "OPTIMISTIC LOCKING FAILURE ERROR");
        modelAndView.setViewName("error");

        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(HttpServletRequest httpServletRequest, Exception exception) {
        logError(httpServletRequest, exception);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("errorMessage", "AN ERROR OCCURED");
        modelAndView.setViewName("error");

        return modelAndView;
    }

    private void logError(HttpServletRequest httpServletRequest, Exception exception) {
        log.error(httpServletRequest + " raised " + exception + " At " + DateTimeHelper.getCurrentDateTimeString());
        log.error(exception.getStackTrace().toString());
    }


   /* private ModelAndView getModelAndView(HttpServletRequest httpServletRequest,Exception exception){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("url", httpServletRequest.getRequestURL());
        modelAndView.setViewName("error");

        return modelAndView;
    }*/


}