package com.codelogic.springsecuritywithjwt.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class TempController2 {

    @PostConstruct
    public void test() {
        log.info("Bean has been initialized using @PostConstruct");
    }

}
