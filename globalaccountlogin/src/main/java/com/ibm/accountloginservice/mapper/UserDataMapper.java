package com.ibm.accountloginservice.mapper;

import com.ibm.accountloginservice.dto.UserDataDTO;
import com.ibm.accountloginservice.entity.User;

public class UserDataMapper {
	
	public User conertToUserEntity(UserDataDTO dto) {
		User user = new User();
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getFirstName());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setPhoneNumber(dto.getPhoneNumber());
		user.setEmail(dto.getEmail());
		user.setActive(true);
		return user;
	}

}
