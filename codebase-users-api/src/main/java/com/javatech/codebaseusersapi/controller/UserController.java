package com.javatech.codebaseusersapi.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatech.codebaseusersapi.exception.EntityAlreadyExistsException;
import com.javatech.codebaseusersapi.service.IUserService;
import com.javatech.codebaseusersapi.shared.dto.UserDto;
import com.javatech.codebaseusersapi.ui.model.UserSignupRequestModel;
import com.javatech.codebaseusersapi.ui.model.UserSignupResponseModel;
import com.javatech.codebaseusersapi.util.RestResponse;

@RestController
@RequestMapping(value = "/users")
public class UserController {

//	private static Logger log = LogManager.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@PostMapping
	public RestResponse<UserSignupResponseModel> signUp(@Valid @RequestBody UserSignupRequestModel userSignupRequest)
			throws EntityAlreadyExistsException {
		ModelMapper mapper = new ModelMapper();
		UserDto userDto = mapper.map(userSignupRequest, UserDto.class);
		UserDto createUser = userService.createUser(userDto);
		UserSignupResponseModel userSignupResponseModel = mapper.map(createUser, UserSignupResponseModel.class);
		return new RestResponse<UserSignupResponseModel>(System.currentTimeMillis(), HttpStatus.CREATED.value(),
				userSignupResponseModel);
	}
}
