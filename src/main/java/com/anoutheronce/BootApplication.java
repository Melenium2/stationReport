package com.anoutheronce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class BootApplication
{
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(BootApplication.class, args);
    }
}
