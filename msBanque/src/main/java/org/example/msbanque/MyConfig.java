package org.example.msbanque;

import org.example.msbanque.web.CompteRESTJaxRsAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    //c'est la class qui deploie le web service REST jersey
    //@Bean
    public ResourceConfig resourceConfig(){
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRESTJaxRsAPI.class);
        return  jerseyServlet;
    }
}
