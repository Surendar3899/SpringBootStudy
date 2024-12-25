package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component("outside")
public class BSNL {
    private String ipAddress;
    private int speed;
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void switchOn(){
        System.out.println("BSNL modem outside connected");
    }
    
}
