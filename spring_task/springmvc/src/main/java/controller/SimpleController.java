package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 实现 spring-webmvc 中Controller 接口 (需要指定Adapter 类型)
 *
 * @author licc
 * @date 2021/6/19
 */
public class SimpleController implements Controller {


    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView modelAndView = new ModelAndView("userPage");
        modelAndView.addObject("name" , "zhangsan");
        return modelAndView;
    }
}
