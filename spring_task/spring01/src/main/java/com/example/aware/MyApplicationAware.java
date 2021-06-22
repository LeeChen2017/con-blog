package com.example.aware;

import com.example.domain.Command;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * @author licc
 */
public class MyApplicationAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Object processor(Map commandState){
        Command command = createCommand();
        command.setCommandState(commandState);
        return command;
    }

    public Command createCommand(){

        return this.applicationContext.getBean("command" , Command.class);
    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
