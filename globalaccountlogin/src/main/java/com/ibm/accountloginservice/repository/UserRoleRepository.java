package com.ibm.accountloginservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.accountloginservice.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	@Query("select r.name " + "from User u,Role r,UserRole ur "
		+ "where  u.id=?1 " + "and ur.userId = u.id "
		+ "and ur.roleId = r.id")
	List<String> findRoleByUserId(Integer id);

}
