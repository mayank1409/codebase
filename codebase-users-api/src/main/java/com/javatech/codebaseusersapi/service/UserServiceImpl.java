package com.javatech.codebaseusersapi.service;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javatech.codebaseusersapi.constants.UserApplicationMessageConstants;
import com.javatech.codebaseusersapi.data.UserEntity;
import com.javatech.codebaseusersapi.data.UserEntityRepository;
import com.javatech.codebaseusersapi.exception.EntityAlreadyExistsException;
import com.javatech.codebaseusersapi.shared.dto.UserDto;
import com.javatech.codebaseusersapi.util.UserUtils;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserEntityRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto userDto) throws EntityAlreadyExistsException {

		if (userRepository.findByEmail(userDto.getEmail()) != null) {
			throw new EntityAlreadyExistsException(UserApplicationMessageConstants.USER_ALREADY_EXISTS_MESSAGE);
		}
		ModelMapper mapper = new ModelMapper();
		UserEntity userEntity = mapper.map(userDto, UserEntity.class);
		userEntity.setUserId(UserUtils.generateUserId());
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userRepository.save(userEntity);
		return mapper.map(userEntity, UserDto.class);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException(UserApplicationMessageConstants.USER_NOT_FOUND_MESSAGE);
		}
		return new User(username, userEntity.getEncryptedPassword(), new ArrayList<>());
	}

}
