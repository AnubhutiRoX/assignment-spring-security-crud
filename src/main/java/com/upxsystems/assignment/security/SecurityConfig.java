package com.upxsystems.assignment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/user/list").hasRole("USER")
			.antMatchers(HttpMethod.GET, "/user/**").hasAnyRole("USER", "MANAGER")
			.antMatchers(HttpMethod.DELETE, "/user/**").hasRole("MANAGER")
			.antMatchers(HttpMethod.POST, "/user/**").hasRole("MANAGER")
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("anubhuti").password("{noop}anubhuti").roles("USER").and()
				.withUser("vinay").password("{noop}vinay").roles("MANAGER");
	}

}
