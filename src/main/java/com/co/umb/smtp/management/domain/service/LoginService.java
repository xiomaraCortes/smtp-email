package com.co.umb.smtp.management.domain.service;
import com.co.umb.smtp.management.adapter.email.model.request.EmailEMRequestDTO;
import com.co.umb.smtp.management.domain.repository.EmailRepository;
import com.co.umb.smtp.management.domain.service.model.request.EmailPasswordRequestDTO;
import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	final static Logger logger = Logger.getLogger(LoginService.class);
	private EmailRepository emailRepository;
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	public LoginService(DozerBeanMapper dozerBeanMapper, EmailRepository emailRepository) {
		this.dozerBeanMapper = dozerBeanMapper;
		this.emailRepository = emailRepository;
	}

	public void executeEmail(EmailPasswordRequestDTO emailPasswordRequestDTO)  {
		try {
			this.emailRepository.sendEmail(emailPasswordRequestDTO);
			return;
		}catch (Exception e) {
			logger.error("Se presentaron para ejecutar el services executeEmail",e);
		}
	}
}