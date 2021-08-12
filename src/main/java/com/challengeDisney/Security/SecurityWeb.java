package com.challengeDisney.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration @EnableWebSecurity
public class SecurityWeb extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/","/auth/*").permitAll()
			.antMatchers("/users").access("hasRole('USER')")
			.antMatchers("/webAdministration/*").access("hasRole('ADMIN')")
			.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/auth/login").permitAll()
				.defaultSuccessUrl("/auth/login/user").failureUrl("/auth/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
			.and()
				.logout().permitAll().logoutSuccessUrl("/auth/login?logout");
	}
	
}
