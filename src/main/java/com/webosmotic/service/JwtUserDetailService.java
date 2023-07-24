package com.webosmotic.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailService implements UserDetailsService{

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if("gagan".equals(username)) {
		return new User("gagan","$2a$12$RvY2x1lV1VAyEYtGiAdFeO7kVpA8hVAOtsaY26y/TakrjaikWRpne",
				new ArrayList<>());	
		}
		else {
			throw new UsernameNotFoundException("user not found on server");
		}
		
		
	}

}
