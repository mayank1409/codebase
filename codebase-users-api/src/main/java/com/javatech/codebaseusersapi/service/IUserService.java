package com.javatech.codebaseusersapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.javatech.codebaseusersapi.exception.EntityAlreadyExistsException;
import com.javatech.codebaseusersapi.shared.dto.UserDto;

public interface IUserService extends UserDetailsService {

	public UserDto createUser(UserDto userDto) throws EntityAlreadyExistsException;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
