package com.example.service;

import com.example.domain.Command;
import com.sun.jmx.remote.internal.ClientCommunicatorAdmin;
import org.springframework.stereotype.Component;

import javax.xml.ws.Provider;

/**
 * @author licc
 */
@Component
public class ProviderService {

    private Provider<Command> commandProvider;
    public void setCommandProvider(){

    }

}
