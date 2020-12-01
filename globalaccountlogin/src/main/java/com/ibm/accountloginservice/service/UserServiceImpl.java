package com.ibm.accountloginservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Service;

import com.ibm.accountloginservice.dto.UserDataDTO;
import com.ibm.accountloginservice.entity.User;
import com.ibm.accountloginservice.entity.UserRole;
import com.ibm.accountloginservice.mapper.UserDataMapper;
import com.ibm.accountloginservice.repository.RoleRepository;
import com.ibm.accountloginservice.repository.UserRepository;
import com.ibm.accountloginservice.repository.UserRoleRepository;

@Service
public class UserServiceImpl  implements UserService{
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	DefaultTokenServices tokenServices;
	@Override
	public Authentication signin(String username, String password) {
		Authentication auth = null;
		try {
			auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			//tokenServices.createAccessToken(authentication)
			
		}
		catch(AuthenticationException e) {
			logger.error("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		return auth;
	}

	@Override
	public String signup(UserDataDTO userDTO) {
		User user = new UserDataMapper().conertToUserEntity(userDTO);
		User u =userRepository.save(user);
		UserRole ur = new UserRole();
		//Setting DEFAULT Role
		ur.setRoleId(roleRepository.findByName("USER"));
		ur.setUserId(u);
		userRoleRepository.save(ur);
		return userDTO.getUsername();
	}

	@Override
	public void delete(String username) {
		userRepository.deleteByUsername(username);
		
	}

	@Override
	public UserDataDTO search(String username) {
		// TODO Auto-generated method stub
		//User user = 
		return null;
	}
	
	

}
