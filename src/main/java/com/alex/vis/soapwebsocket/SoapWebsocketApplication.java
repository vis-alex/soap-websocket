package com.alex.vis.soapwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapWebsocketApplication.class, args);
    }
    //After start we`ll go to http://localhost:8080/ws/greeting.wsdl

}
