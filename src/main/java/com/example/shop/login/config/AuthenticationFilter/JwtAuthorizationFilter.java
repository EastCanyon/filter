package com.example.shop.login.config.AuthenticationFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.shop.login.config.AuthenticationFilter.service.JwtService;
import com.example.shop.login.config.auth.PrincipalDetails;
import com.example.shop.login.dao.TestDAO;
import com.example.shop.login.dto.User;



//시큐리티가 filter 가지고 있는데 그 필터 중에 BasicAuthenticationFilter 라는 것이 있음
//권한이나 인증에 필요한 특정 주소를 요청했을 때 위 필터를 무조건 타게 되어있음
//만약에 권한이 인증이 필요한 주소가 아니라면 이 필터를 안탐

public class JwtAuthorizationFilter extends BasicAuthenticationFilter{
	
	private TestDAO dao;
	
	@Autowired
	private JwtService jwtService;
	
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, TestDAO dao) {
		super(authenticationManager);
		this.dao= dao;
		
	}
	
	
	//인증이나 권한이 필요한 주소요청이 있을 때 해당 필터를 타게 됨
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//super.doFilterInternal(request, response, chain);
		System.out.println("인증이나 권한이 필요한 주소 요청이 됨");
		
		String jwtHeader = request.getHeader("Authorization");
		
		System.out.println("jwtHeader : " + jwtHeader);
		
		//header가 있는지 확인
		//Header가 비어 있거나, 비어있지 않지만 Bearer 방식이 아니면 반환한다.
 		//JWT 토큰 검증을 해서 정상적인 사용자인지 확인=> 정상적인 요청이 아닌경우
		if(jwtHeader ==null ||!jwtHeader.startsWith("Bearer")) {
			
			chain.doFilter(request, response);
			
			return;
			
			
		}
		
		//JWT 토큰을 검증을 해서 정상적인 사용자인지 확인
		//String jwtToken = request.getHeader("Authorizaion").replace("Bearer ", "");
		
		//String username = JWT.require(Algorithm.HMAC512("cos")).build().verify(jwtToken).getClaim("username").asString();
		
		String username = jwtService.extractUserInfo(jwtHeader);
		
		// 서명이 정상적으로 됨
		if(username!=null) {
			User userEntity = dao.SelectByMember(username);
			
			PrincipalDetails principalDetails = new PrincipalDetails(userEntity);
			
			// Jwt 토큰 서명을 통해서 서명이 정상이면 Authentication 객체를 만들어 준다.
			Authentication authentication = 
					new UsernamePasswordAuthenticationToken(principalDetails, null,principalDetails.getAuthorities());
			
			//강제로 시큐리티의 세션에 접근하며 Authentication 객체를 저장
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			
			
		}
		
		chain.doFilter(request, response);
		
	}

	
	
}















