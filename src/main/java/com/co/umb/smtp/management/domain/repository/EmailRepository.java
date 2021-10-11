package com.co.umb.smtp.management.domain.repository;

import com.co.umb.smtp.management.adapter.email.model.request.EmailEMRequestDTO;

import com.co.umb.smtp.management.domain.service.model.request.EmailPasswordRequestDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public interface EmailRepository {

	final static Logger logger = Logger.getLogger(EmailRepository.class);

	void sendEmail(EmailPasswordRequestDTO emailPasswordRequestDTO) throws MessagingException;

}
