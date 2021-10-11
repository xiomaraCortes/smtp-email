package com.co.umb.smtp.management.adapter.api.controller;
import com.co.umb.smtp.management.adapter.api.ApiConst;
import com.co.umb.smtp.management.adapter.api.facade.LoginFacade;
import com.co.umb.smtp.management.domain.service.model.request.EmailPasswordRequestDTO;
import com.co.umb.smtp.management.utils.exception.ConstantErrors;
import com.co.umb.smtp.management.utils.exception.UMBErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import com.google.gson.Gson;


import org.apache.log4j.Logger;
@RestController
@RequestMapping(value = ApiConst.LOGIN_PATH)
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class LoginController {

    final static Logger logger = Logger.getLogger(LoginController.class);
    
    private com.co.umb.smtp.management.adapter.api.facade.LoginFacade LoginFacade;
    private Gson gson;
    
    @Autowired
    public LoginController(LoginFacade loginFacade, Gson gson) {
        this.LoginFacade = loginFacade;
        this.gson = gson;
    }
    
	@GetMapping("/message")
	public String getMessage() {
		return "V20200914_01";
	}


	@ApiOperation(value = "sendEmail")
	@RequestMapping(value = "/sendEmail/", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> forgetPassword(@RequestBody EmailPasswordRequestDTO emailPasswordRequestDTO) {
		this.LoginFacade.executeSendEmail(emailPasswordRequestDTO);
		return new ResponseEntity<String>(this.gson.toJson(ConstantErrors.ERRORS_STATES.get(UMBErrorEnum.SUCCESS_TRANSACTION.getCode())), HttpStatus.OK);
	}
}
