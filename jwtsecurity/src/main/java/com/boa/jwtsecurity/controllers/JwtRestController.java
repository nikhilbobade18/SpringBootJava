package com.boa.jwtsecurity.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.boa.jwtsecurity.configurations.JwtUtil;
import com.boa.jwtsecurity.dtos.JwtRequest;
import com.boa.jwtsecurity.dtos.JwtResponse;
import com.boa.jwtsecurity.exceptions.DisabledUserException;
import com.boa.jwtsecurity.exceptions.InvalidUserCredentialsException;
import com.boa.jwtsecurity.models.Role;
import com.boa.jwtsecurity.models.User;
import com.boa.jwtsecurity.services.UserAuthService;
import com.boa.jwtsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class JwtRestController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserAuthService userAuthService;
	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> generateJwtToken(@RequestBody JwtRequest jwtRequest) {
		
		System.out.println(jwtRequest.getUserName()+""+jwtRequest.getUserPwd());
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getUserPwd()));
	
		} catch (DisabledException e) {
			throw new DisabledUserException("User Inactive");
		} catch (BadCredentialsException e) {
			throw new InvalidUserCredentialsException("Invalid Credentials");
		}
		UserDetails userDetails = userAuthService.loadUserByUsername(jwtRequest.getUserName());
		String username = userDetails.getUsername();
		String userpwd = userDetails.getPassword();
		List<String> roles = userDetails.getAuthorities().stream().map(r -> r.getAuthority())
				.collect(Collectors.toList());
		
		
		User user = new User();
		user.setUserName(username);
		user.setPassword(userpwd);
		List<Role> roleList = new ArrayList(roles);
		user.setRoles(roleList);
		String token = jwtUtil.generateToken(user);
		return new ResponseEntity<JwtResponse>(new JwtResponse(token), HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody User user) {
		System.out.print(user.getUserName());
		System.out.print(user.getPassword());
		System.out.print(user.getRoles());
		User userObj = userAuthService.getUserByUsername(user.getUserName());

		if (userObj == null) {
			userService.saveUser(user);
			return new ResponseEntity<String>("User successfully registered", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("User already exists", HttpStatus.CONFLICT);
		}
	}

}
