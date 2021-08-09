package com.challengeDisney.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.challengeDisney.Services.UserServiceDetails;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private UserServiceDetails userDetService;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetService).passwordEncoder(bCrypt);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/auth*").permitAll()
		.antMatchers("/users").access("hasRole('USER')")
		.antMatchers("/webAdministration*").access("hasRole('ADMIN')")
		.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/auth/login").permitAll()
			.defaultSuccessUrl("/").failureUrl("/auth/login?error=true")
			.usernameParameter("username")
			.passwordParameter("password")
		.and()
			.logout().permitAll().logoutSuccessUrl("/auth/login?logout");
		/*http
			.authorizeRequests()
				.antMatchers("/webAdministration/*").hasRole("FULLADMIN")
				.antMatchers("/","/auth*").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/auth/login").defaultSuccessUrl("/user",true).failureUrl("/auth/login?error=true")
				.loginProcessingUrl("/auth/login").permitAll()
				.usernameParameter("username").passwordParameter("password")
			.and()
				.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/auth");*/
	}
}
