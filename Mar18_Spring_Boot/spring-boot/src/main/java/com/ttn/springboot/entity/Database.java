package com.ttn.springboot.entity;

public class Database {
    String name;
    Integer port;

    public Database() {
    }

    public Database(String name, Integer port) {
        this.name = name;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
