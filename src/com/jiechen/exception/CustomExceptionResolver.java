package com.jiechen.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * 异常处理器的自定义的实现类
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object obj,
                                         Exception e) {

        String msg;

        // 判断异常类型
        if (e instanceof MyException) {
            // 如果是自定义异常，读取异常信息
            msg = e.getMessage();
        } else {
            // 如果是运行时异常，则取错误堆栈，从堆栈中获取异常信息
            Writer out = new StringWriter();
            PrintWriter s = new PrintWriter(out);
            e.printStackTrace(s);
            msg = out.toString();
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", msg);
        mv.setViewName("error");
        return mv;
    }

}
