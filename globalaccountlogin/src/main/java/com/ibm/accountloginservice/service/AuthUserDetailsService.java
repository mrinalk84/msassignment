package com.ibm.accountloginservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ibm.accountloginservice.entity.User;
import com.ibm.accountloginservice.oauth2.AuthUserDetails;
import com.ibm.accountloginservice.repository.UserRepository;
import com.ibm.accountloginservice.repository.UserRoleRepository;


@Service
public class AuthUserDetailsService implements UserDetailsService{
	private static Logger logger = LoggerFactory.getLogger(AuthUserDetailsService.class);
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("username:["+ username + "]");
		User user = userRepository.findByUsername(username);
		if (null == user) {
			throw new UsernameNotFoundException(
					"INVALID USER WITH LOGIN: " + username);
		} else {
			List<String> userRoles = userRoleRepository.findRoleByUserId(user.getId());
			return new AuthUserDetails(user,userRoles);
		}
	}

}
