package com.co.umb.smtp.management;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.Properties;

@Configuration
public class AppConfig {

	final static Logger logger = Logger.getLogger(AppConfig.class);

    public AppConfig(@Autowired ConfigurableEnvironment env) {
		this.initLogger();
	}

	public void initLogger() {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Cargo la configuracion de logger correctamente");
	}

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    Gson getObjectGson() {
        return new Gson();
    }
}
