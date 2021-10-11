package com.co.umb.smtp.management.adapter.email.repository;

import com.co.umb.smtp.management.domain.repository.EmailRepository;
import com.co.umb.smtp.management.domain.service.model.request.EmailPasswordRequestDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;

@Repository
public class EmailSMTPRepository implements EmailRepository {
	final static Logger logger = Logger.getLogger(EmailSMTPRepository.class);

	private JavaMailSender javaMailSender;

	@Value("${email.subject}")
	private String subject;

	@Autowired
	public EmailSMTPRepository(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendEmail(EmailPasswordRequestDTO emailPasswordRequestDTO) throws MessagingException {
		javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setSubject(subject);

		String html = "\n" +
				"<!doctype html>\n" +
				"<html lang=\"en-US\">\n" +
				"\n" +
				"<head>\n" +
				"    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n" +
				"    <title>Reset Password Email Template</title>\n" +
				"    <meta name=\"description\" content=\"Reset Password Email Template.\">\n" +
				"    <style type=\"text/css\">\n" +
				"        a:hover {text-decoration: underline !important;}\n" +
				"    </style>\n" +
				"</head>\n" +
				"\n" +
				"<body marginheight=\"0\" topmargin=\"0\" marginwidth=\"0\" style=\"margin: 0px; background-color: #f2f3f8;\" leftmargin=\"0\">\n" +
				"    <!--100% body table-->\n" +
				"    <table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\"\n" +
				"        style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">\n" +
				"        <tr>\n" +
				"            <td>\n" +
				"                <table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\"\n" +
				"                    align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
				"                    <tr>\n" +
				"                        <td style=\"height:80px;\">&nbsp;</td>\n" +
				"                    </tr>\n" +
				"                    <tr>\n" +
				"                        <td style=\"text-align:center;\">\n" +
				"                          <a href=\"https://rakeshmandal.com\" title=\"logo\" target=\"_blank\">\n" +
				"                            <img width=\"140\" src=\"https://vicecalidad.umb.edu.co/viceadmin/images/vice/umb.png\" title=\"logo\" alt=\"logo\">\n" +
				"                          </a>\n" +
				"                        </td>\n" +
				"                    </tr>\n" +
				"                    <tr>\n" +
				"                        <td style=\"height:20px;\">&nbsp;</td>\n" +
				"                    </tr>\n" +
				"                    <tr>\n" +
				"                        <td>\n" +
				"                            <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"\n" +
				"                                style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">\n" +
				"                                <tr>\n" +
				"                                    <td style=\"height:40px;\">&nbsp;</td>\n" +
				"                                </tr>\n" +
				"                                <tr>\n" +
				"                                    <td style=\"padding:0 35px;\">\n" +
				"                                        <h1 style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">Te recordamos\n" +
				"                                            tu contraseña del sistema de  rutas de la Universidad Manuela Beltran</h1>\n" +
				"                                        <span\n" +
				"                                            style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100%;\"></span>\n" +
				"                                        <p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">\n" +
				"                                          \n" +
				"                                        </p>\n" +
				"\t\t\t\t\t\t\t\t\t\t<div  style=\"height:8px\">\n" +
				"\t\t\t\t\t\t\t\t\t\t</div>\n" +
				"\t\t\t\t\t\t\t\t\t\t<p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">\n" +
				"                                         Email: "+emailPasswordRequestDTO.getEmail()+"\n" +
				"                                        </p>\n" +
				"\t\t\t\t\t\t\t\t\t\t<div  style=\"height:8px\">\n" +
				"\t\t\t\t\t\t\t\t\t\t</div>\n" +
				"\t\t\t\t\t\t\t\t\t\t<p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">\n" +
				"                                         Password: \n" +
				"                                        </p\n" +
				"                                        \n" +
				"                                    </td>\n" +
				"                                </tr>\n" +
				"                                <tr>\n" +
				"                                    <td style=\"height:40px;\">&nbsp;</td>\n" +
				"                                </tr>\n" +
				"                            </table>\n" +
				"                        </td>\n" +
				"                    <tr>\n" +
				"                        <td style=\"height:20px;\">&nbsp;</td>\n" +
				"                    </tr>\n" +
				"                    \n" +
				"                    <tr>\n" +
				"                        <td style=\"height:80px;\">&nbsp;</td>\n" +
				"                    </tr>\n" +
				"                </table>\n" +
				"            </td>\n" +
				"        </tr>\n" +
				"    </table>\n" +
				"    <!--/100% body table-->\n" +
				"</body>\n" +
				"\n" +
				"</html>";
		helper.setText(html, true);
		helper.setTo(emailPasswordRequestDTO.getEmail());
		javaMailSender.send(mimeMessage);
	}
}
