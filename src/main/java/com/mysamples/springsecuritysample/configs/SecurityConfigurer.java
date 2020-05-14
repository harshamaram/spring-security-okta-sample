package com.mysamples.springsecuritysample.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**")
			.authorizeRequests()
			.antMatchers("/", "/login**")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.oauth2Login();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("foo")
			.password("{noop}foo")
			.roles("USER");
	}
	
}
