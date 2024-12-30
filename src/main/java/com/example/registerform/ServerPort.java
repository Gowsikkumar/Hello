package com.example.registerform;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;


@Component
public class ServerPort implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>
{


    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        String port = System.getenv("x_ZOHO_CATALYST_LISTEN_PORT");
        int listenPort;
        if(port != null && !port.isEmpty()){
            listenPort = Integer.parseInt(System.getenv("x_ZOHO_CATALYST_LISTEN_PORT"));
        }
        else {
            listenPort = 9000;
        }
        factory.setPort(listenPort);
    }
}
