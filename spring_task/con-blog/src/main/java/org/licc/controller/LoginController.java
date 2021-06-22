package org.licc.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author licc
 * @date 2021/6/22
 */
public class LoginController implements org.springframework.web.servlet.mvc.Controller {


    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView modelAndView = new ModelAndView("loginPage");
        modelAndView.addObject("name" , "zhangsan");
        return modelAndView;
    }
}
