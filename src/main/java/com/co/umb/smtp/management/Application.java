package com.co.umb.smtp.management;

import com.co.umb.smtp.management.adapter.api.ApiConst;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application {

	final static Logger logger = Logger.getLogger(Application.class);
    
    public static void main(String[] args) {
         ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(Application.class)
		.properties("spring.config.name:local.application")
		.build()
		.run(args);
		 ConfigurableEnvironment configurableEnvironment = applicationContext.getEnvironment();
         ApiConst.CONFIGURABLE_PROPERTIES = configurableEnvironment;
		logger.debug("environment.getProperty(\"spring.mail.username\") " + configurableEnvironment.getProperty("spring.mail.username"));
		 logger.debug("environment.getProperty(\"spring.jpa.show-sql\") " + configurableEnvironment.getProperty("spring.datasource.url"));
    }

}
