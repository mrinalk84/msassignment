/**
 * 
 */
package com.ibm.accountloginservice.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * @author MrinalJana
 *
 */
@Entity
@Table(name = "users", catalog = "security", schema = "", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"username"})})
public class User implements Serializable {


	    /**
	 * 
	 */
	private static final long serialVersionUID = -8497908907866437296L;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    private Integer id;
		@Column(name = "username", nullable = false, length = 12)
	    private String username;
		
		@Column(name = "password", nullable = false, length = 100)
	    private String password;
		
	    @Column(name = "first_name", nullable = false, length = 50)
	    private String firstName;
	    @Column(name = "last_name", nullable = false, length = 50)
	    private String lastName;
	    
	    @Column(name = "email", nullable = false, length = 50)
	    private String email;
	    
	    @Column(name = "phone_number", nullable = false, length = 10)
	    private String phoneNumber;
	    
	    @Column(name = "active", nullable = false)
	    private Boolean active;
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.EAGER)
	    private List<UserRole> userRoleList;

	    

	    public User() {
	    }

	    public User(Integer id) {
	        this.id = id;
	    }

	    public User(Integer id, String firstName, String lastName, String username, String password) {
	        this.id = id;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.username = username;
	        this.password = password;
	    }

	    public User(User user) {
	        this.id = user.id;
	        this.firstName = user.firstName;
	        this.lastName = user.lastName;
	        this.username = user.username;
	        this.password = user.password;
	    }

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public Boolean getActive() {
			return active;
		}

		public void setActive(Boolean active) {
			this.active = active;
		}

		public List<UserRole> getUserRoleList() {
			return userRoleList;
		}

		public void setUserRoleList(List<UserRole> userRoleList) {
			this.userRoleList = userRoleList;
		}

	    
	    
}
