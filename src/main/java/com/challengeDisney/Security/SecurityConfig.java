package com.challengeDisney.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.challengeDisney.Users.UserService;

//import com.challengeDisney.Users.UserDetService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private UserService userDetService;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetService).passwordEncoder(bCrypt);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers("/","/auth/**").permitAll().anyRequest().authenticated()
			.and()
				.formLogin().loginProcessingUrl("/auth/login").loginPage("/auth/login")
				.defaultSuccessUrl("/user").failureUrl("/auth/login?error=true").permitAll()
				.usernameParameter("username").passwordParameter("password")
			.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/auth");
	}
}
