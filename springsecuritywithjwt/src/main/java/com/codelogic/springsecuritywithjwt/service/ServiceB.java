package com.codelogic.springsecuritywithjwt.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceB {

    private final ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public void doSomethingB() {
        System.out.println("ServiceB is doing something");
    }
}