package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SpringSecurityImplementation extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {  //@formatter:off
		authentication
		              .inMemoryAuthentication()
		              .withUser("user")
		              .password("{noop}password")
		              .roles("USER");
	} // @formatter:on
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
	
		http
		   .authorizeRequests()
		    .antMatchers("/signup","/saveRegistration").permitAll()
		    .anyRequest().authenticated()
		   .and()
		   .formLogin()
		    .loginPage("/login").permitAll()
		    .loginProcessingUrl("/loginSubmit")
		    .and()
		    .logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logoutSubmit","GET"))
		    .and()
		    .csrf().disable(); 
		
	} 

}
