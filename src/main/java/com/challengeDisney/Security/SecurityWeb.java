package com.challengeDisney.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityWeb extends WebSecurityConfigurerAdapter{
	private final UserDetailsService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().anyRequest().permitAll();
		http.addFilter(new AuthenticationFilter(authenticationManagerBean()));
	}
	@Bean @Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	
	
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/","/auth/*").permitAll()
//			.antMatchers("/users").access("hasRole('USER')")
//			.antMatchers("/webAdministration/*").access("hasRole('ADMIN')")
//			.anyRequest().authenticated()
//			.and()
//				.formLogin().loginPage("/auth/login").permitAll()
//				.defaultSuccessUrl("/auth/login/user").failureUrl("/auth/login?error=true")
//				.usernameParameter("username")
//				.passwordParameter("password")
//			.and()
//				.logout().permitAll().logoutSuccessUrl("/auth/login?logout");
//	}
//	
}
