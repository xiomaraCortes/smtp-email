package com.co.umb.smtp.management.adapter.api.facade;
import com.co.umb.smtp.management.domain.service.model.request.EmailPasswordRequestDTO;
import com.co.umb.smtp.management.domain.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LoginFacade {


    final static Logger logger = Logger.getLogger(LoginFacade.class);
    
    private LoginService loginService;
    
    @Autowired
    public LoginFacade(LoginService loginService) {
    	this.loginService = loginService;
    }

    @Async
    public void executeSendEmail(EmailPasswordRequestDTO emailPasswordRequestDTO){
         this.loginService.executeEmail(emailPasswordRequestDTO);
    }
}
