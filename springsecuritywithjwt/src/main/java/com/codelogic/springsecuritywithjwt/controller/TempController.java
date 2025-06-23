package com.codelogic.springsecuritywithjwt.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class TempController implements CommandLineRunner {@Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'run'");

        log.info("commandline runner called");
    }

}
