/**
 * 
 */
package com.luv2code.demo.thymeleafdemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 * @author Abhishek
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//add users for in memory authenication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("mary").password("test123").roles("MANAGER"))
		.withUser(users.username("susan").password("test123").roles("ADMIN"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateUser")
				.permitAll()
				.and()
				.logout()
				//.logoutUrl("/logout")
	            //.logoutSuccessUrl("/login")
				.permitAll();
	}

}