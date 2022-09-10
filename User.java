package com.tweetapp.tweet.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
 

@Entity
@NoArgsConstructor
@Table
@AllArgsConstructor
public class User implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public List<Tweet> getTweetJpaList() {
		return tweetJpaList;
	}

	public void setTweetJpaList(List<Tweet> tweetJpaList) {
		this.tweetJpaList = tweetJpaList;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	private String Firstname;
	
	private String middlename=null;
	
	@NotNull
	private String LastName;
	
	//@Size(max = 10)
	private String phoneNumber;
	
	@NotNull
	@Email
	private String username;
	
	@NotNull
	private String password;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Tweet> tweetJpaList;
	
	public User(int id,String Firstname,String Middlename,String Lastname,String phone,String username,String password)
	{
		this.id=id;
		this.Firstname=Firstname;
		this.middlename=Middlename;
		this.LastName=Lastname;
		this.phoneNumber=phone;
		this.username=username;
		this.password=password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
