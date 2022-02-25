package com.example.business.exception;

import com.example.business.enums.ServerResponseEnum;
import com.example.business.vo.response.ServerResponseVO;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: 刘树国
 * @create: 2022-02-25
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ServerResponseVO methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        return  ServerResponseVO.error(ServerResponseEnum.PASSWORDVALIDE);
    }


}
