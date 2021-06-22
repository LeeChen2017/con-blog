package com.example.domain;

import java.util.Map;

public class Command {

    private String id;

    private Map commandState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map getCommandState() {
        return commandState;
    }

    public void setCommandState(Map commandState) {
        this.commandState = commandState;
    }
}
