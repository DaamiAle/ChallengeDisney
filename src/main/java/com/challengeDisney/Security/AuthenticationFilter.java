package com.challengeDisney.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.Algorithm;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.challengeDisney.Models.UserModel;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	private final AuthenticationManager authManager;
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userName, password);
		return authManager.authenticate(authToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
		UserModel userEntity = (UserModel) authentication.getPrincipal();
		Algorithm algorithm = Algorithm.HS256;
		String access_token = JWT.create().withSubject("");
	}

}
