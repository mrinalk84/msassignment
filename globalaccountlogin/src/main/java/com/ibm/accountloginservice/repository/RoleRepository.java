package com.ibm.accountloginservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.accountloginservice.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	public Role findByName(String name);
	

}
