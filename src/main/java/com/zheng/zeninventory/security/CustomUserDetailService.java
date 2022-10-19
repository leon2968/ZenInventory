package com.zheng.zeninventory.security;

import org.springframework.stereotype.Service;

import com.zheng.zeninventory.model.User;
import com.zheng.zeninventory.repository.UserRepository;

import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	UserRepository userRepository;
	
	public CustomUserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(usernameOrEmail);
		
		if(user!=null) {
			//System.out.println(user.toString());
			return new org.springframework.security.core.userdetails.User(user.getEmail(), 
					user.getPassword(),new HashSet<GrantedAuthority>());
		} else {
			throw new UsernameNotFoundException("Invalid email or password");
		}
	}

}