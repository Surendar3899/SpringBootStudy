package com.codelogic.springsecuritywithjwt.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ServiceA {

    private final ServiceB serviceB;

    public ServiceA(@Lazy ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public void doSomethingA() {
        System.out.println("ServiceA is doing something");
    }
}
